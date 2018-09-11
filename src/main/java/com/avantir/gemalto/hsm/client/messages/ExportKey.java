package com.avantir.gemalto.hsm.client.messages;

import javax.xml.bind.DatatypeConverter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by lekanomotayo on 20/04/2018.
 * Generates Thales TMK  (Terminal Master Key)
 */
public class ExportKey extends HsmMsg {


    // For HSM keys - key index length + keyformat + keyindex

    // Parent Key Specifier
    protected static final String explicitParentKeyFormat = "08"; // Parent Key Index
    protected static final String parentKeyType = "10"; // Parent Key type - KI = 10
    protected String parentKeyIndexFormat = "00"; //
    protected static final String parentKeyIndex = "01"; //
    protected String parentKey;

    protected KeyType keyType;
    protected static final String encryptionMode = "00";// 00 - ECB, 01 - CBC

    // Key Specifier
    protected static final String keyFormat = "11"; //
    protected String key;

    int keyLengthHexLen = 1;
    String keyLengthHex;
    int keyCheckDigitLength = 3;
    String keyUnderKI;
    String keyCheckDigit;


    public ExportKey(String sequenceNo, String parentKey, String key, KeyType keyType){
        super(sequenceNo, "EE0201", 3,"00");
        this.parentKey = parentKey;
        this.key = key;
        this.keyType = keyType;
    }



//    public ExportKey(String sequenceNo, String key, String keyFormat, KeyType keyType){
//        super(sequenceNo, "EE0201", 3,"00");
//        this.key = key;
//        this.keyFormat = keyFormat;
//        this.keyType = keyType;
//    }


//    public ExportKey(String sequenceNo, String parentKey, String key, String keyFormat, KeyType keyType){
//        super(sequenceNo, "EE0201", 3,"00");
//        this.parentKey = parentKey;
//        this.key = key;
//        this.keyFormat = keyFormat;
//        this.keyType = keyType;
//    }


    public byte[] pack()throws IOException{

        // Parent Key Spec
        String parentKeySpecLength = null;
        String parentKeySpec = null;
        String keyIndexKeySpec = null;
        String keyIndexKeySpecLength = null;

        if(parentKey != null){
            parentKeyIndexFormat = "11";
            keyIndexKeySpec = parentKeyIndexFormat + parentKey;
            keyIndexKeySpecLength = Integer.toHexString(keyIndexKeySpec.length() / 2).toUpperCase();
            keyIndexKeySpecLength = padLeft(keyIndexKeySpecLength, 2, "0");
        } else {
            keyIndexKeySpec = parentKeyIndexFormat + parentKeyIndex;
            keyIndexKeySpecLength = Integer.toHexString(keyIndexKeySpec.length() / 2).toUpperCase();
            keyIndexKeySpecLength = padLeft(keyIndexKeySpecLength, 2, "0");
        }

        parentKeySpec = explicitParentKeyFormat + parentKeyType + keyIndexKeySpecLength + keyIndexKeySpec;
        parentKeySpecLength = Integer.toHexString(parentKeySpec.length() / 2).toUpperCase();
        parentKeySpecLength = padLeft(parentKeySpecLength, 2, "0");


        // Key Spec
        String keySpec = keyFormat + key;
        String keySpecLength = Integer.toHexString(keySpec.length() / 2).toUpperCase();
        keySpecLength = padLeft(keySpecLength, 2, "0");

        String body = functionCode + functionModifier + parentKeySpecLength + parentKeySpec + keyType + encryptionMode + keySpecLength + keySpec;
        String messageLength = Integer.toHexString(body.length() / 2).toUpperCase();
        messageLength = padLeft(messageLength, 4, "0");
        String header = requestHeaderSohCharacter + requestHeaderVersion + requestSequenceNo + messageLength;

        String request = header + body;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(DatatypeConverter.parseHexBinary(request));

        byte[] request_data = baos.toByteArray();
        ByteArrayOutputStream raw_data = new ByteArrayOutputStream();
        raw_data.write(request_data);
        requestData = raw_data.toByteArray();
        return requestData;
    }

    public void unpack(byte[] data){
        responseData = data;
        super.unpack(data);
        String str_recvd = hexBinaryConverter.fromBinary2Hex(data);

        if("00".equalsIgnoreCase(errorCode)){
            byte[] keyLengthBytes = new byte[keyLengthHexLen];
            System.arraycopy(data, messageHeaderLen + functionCodeByteLen + responseCodeByteLen, keyLengthBytes, 0, keyLengthHexLen);
            keyLengthHex = hexBinaryConverter.fromBinary2Hex(keyLengthBytes);

            int keyLength = Integer.parseInt(keyLengthHex, 16);
            byte[] keyUnderKIBytes = new byte[keyLength];
            System.arraycopy(data, messageHeaderLen + functionCodeByteLen + responseCodeByteLen + keyLengthHexLen, keyUnderKIBytes, 0, keyLength);
            keyUnderKI = hexBinaryConverter.fromBinary2Hex(keyUnderKIBytes);

            byte[] keyCheckDigitBytes = new byte[keyCheckDigitLength];
            System.arraycopy(data, messageHeaderLen + functionCodeByteLen + responseCodeByteLen + keyLengthHexLen + keyLength, keyCheckDigitBytes, 0, keyCheckDigitLength);
            keyCheckDigit = hexBinaryConverter.fromBinary2Hex(keyCheckDigitBytes);
        }
    }


    public String getKeyUnderKI() {
        return keyUnderKI;
    }

    public String getKeyCheckDigit() {
        return keyCheckDigit;
    }

    @Override
    public String toString(){

        return super.toString() +
                "\nParent Key Index: " + parentKeyIndex +
                "\nParent Key Type: " + parentKeyType +
                "\nParent key format: " + parentKeyIndexFormat +
                "\nParent Key Index: " + parentKeyIndex +
                "\nParent Key: " + parentKey +
                "\nKey Type: " + keyType +
                "\nEncrypton Type: " + encryptionMode +
                "\nKey Format: " + keyFormat +
                "\nKey: " + key +
                "\nKey Length: " + keyLengthHex +
                "\nDES Key Under KI: " + keyUnderKI +
                "\nCheck Digit: " + keyCheckDigit;
    }


}
