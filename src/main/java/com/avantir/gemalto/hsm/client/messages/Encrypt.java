package com.avantir.gemalto.hsm.client.messages;

import com.avantir.gemalto.hsm.client.utils.HexBinaryConverter;

import javax.xml.bind.DatatypeConverter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by lekanomotayo on 20/04/2018.
 * ADVANCED-RANDOM-KEY-GENERATION (EE0619)
 */
public class Encrypt extends HsmMsg {

    // For HSM keys - key spec length + key format + key index
    // For Host Stored keys - key spec length + key format + key
    protected String keyIndexlength = "02";
    protected String keyFormat = "00";
    protected String keyIndex = "01"; // (Allowable Key format: 0–3, 10, 11, 12, 13, 14, 16, 17,18) (1 byte)
    protected String key; // Key to use for encryption
    protected String cm = "00"; // Cipher Mode: 00 = ECB, 01 = CBC
    protected String inputChainingValueLength =  "08";
    protected String inputChainingValue =  "0000000000000000"; // input chaining value: (a.k.a initialization vector). Variable length. Must be 8 bytes
    protected String clearText; // Data to encrypt, must be multiple of 8bytes

    protected int outputChainingValueLengthLen = 1;
    protected String outputChainingValueLength;
    protected String outputChainingValue;
    protected int cipherTextLengthLen = 1;
    protected String cipherTextLength;
    protected String cipherText;


    public Encrypt(String sequenceNo, String key, String keyFormat, String clearText){
        super(sequenceNo, "EE0804", 3,"00");
        this.key = key;
        this.keyFormat = keyFormat;
        this.clearText = clearText;
    }


    public byte[] pack()throws IOException{

        String keySpec;
        if(key == null || key.isEmpty()){
            keySpec = keyIndexlength + keyFormat + keyIndex;
        } else {
            keySpec = keyFormat + key;
            String keySpecLength = Integer.toHexString(keySpec.length() / 2).toUpperCase();
            keySpecLength = padLeft(keySpecLength, 2, "0");
            keySpec = keySpecLength + keySpec;
        }
        String clearTextLength = Integer.toHexString(clearText.length() / 2).toUpperCase();
        clearTextLength = padLeft(clearTextLength, 2, "0");

        String body = functionCode + functionModifier + keySpec + cm + inputChainingValueLength + inputChainingValue + clearTextLength + clearText;
        String messageLength = Integer.toHexString(body.length() / 2).toUpperCase();
        messageLength = padLeft(messageLength, 4, "0");
        String header = requestHeaderSohCharacter + requestHeaderVersion + requestSequenceNo + messageLength;

        String request = header + body;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(hexBinaryConverter.parseHexBinary(request));

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
//        System.out.println(Arrays.toString(data));

        if("00".equalsIgnoreCase(errorCode)){

            byte[] outputChainingValueLengthBytes = new byte[outputChainingValueLengthLen];
            System.arraycopy(data, messageHeaderLen + functionCodeByteLen + responseCodeByteLen, outputChainingValueLengthBytes, 0, outputChainingValueLengthLen);
            outputChainingValueLength = hexBinaryConverter.fromBinary2Hex(outputChainingValueLengthBytes);

            int outputChainingValueLengthInt = Integer.parseInt(outputChainingValueLength, 16);
            byte[] outputChainingValueBytes = new byte[outputChainingValueLengthInt];
            System.arraycopy(data, messageHeaderLen + functionCodeByteLen + responseCodeByteLen + outputChainingValueLengthLen, outputChainingValueBytes, 0, outputChainingValueLengthInt);
            outputChainingValue = hexBinaryConverter.fromBinary2Hex(outputChainingValueBytes);

            byte[] cipherTextLengthBytes = new byte[cipherTextLengthLen];
            System.arraycopy(data, messageHeaderLen + functionCodeByteLen + responseCodeByteLen + outputChainingValueLengthLen + outputChainingValueLengthInt, cipherTextLengthBytes, 0, cipherTextLengthLen);
            cipherTextLength = hexBinaryConverter.fromBinary2Hex(cipherTextLengthBytes);

            int cipherTextLengthInt = Integer.parseInt(cipherTextLength, 16);
            byte[] cipherTextBytes = new byte[cipherTextLengthInt];
            System.arraycopy(data, messageHeaderLen + functionCodeByteLen + responseCodeByteLen + outputChainingValueLengthLen + outputChainingValueLengthInt + cipherTextLengthLen, cipherTextBytes, 0, cipherTextLengthInt);
            cipherText = hexBinaryConverter.fromBinary2Hex(cipherTextBytes);
        }
    }


    @Override
    public String toString(){
        return super.toString() +
                "\nOutput Chaining Value Length: " + outputChainingValueLength +
                "\nOutput Chaining Value: " + outputChainingValue +
                "\nCipher Text Length: " + cipherTextLength +
                "\nCipher Text: " + cipherText;
    }

}
