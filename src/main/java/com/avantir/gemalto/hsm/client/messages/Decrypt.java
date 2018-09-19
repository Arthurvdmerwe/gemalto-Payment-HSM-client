package com.avantir.gemalto.hsm.client.messages;

import javax.xml.bind.DatatypeConverter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by lekanomotayo on 20/04/2018.
 * ADVANCED-RANDOM-KEY-GENERATION (EE0619)
 */
public class Decrypt extends HsmMsg {

    // For HSM keys - key spec length + key format + key index
    // For Host Stored keys - key spec length + key format + key
    protected String keyIndexlength = "02";
    protected String keyFormat = "00";
    protected String keyIndex = "01"; // (Allowable Key format: 0–3, 10, 11, 12, 13, 14, 16, 17,18) (1 byte)
    protected String key; // Key to use for encryption
    protected String cm = "00"; // Cipher Mode: 00 = ECB, 01 = CBC
    protected String inputChainingValueLength =  "08";
    protected String inputChainingValue =  "0000000000000000"; // input chaining value: (a.k.a initialization vector). Variable length. Must be 8 bytes
    protected String cipherText; // Data to encrypt, must be multiple of 8bytes

    protected int outputChainingValueLengthLen = 1;
    protected String outputChainingValueLength;
    protected String outputChainingValue;
    protected int clearTextLengthLen = 1;
    protected String clearTextLength;
    protected String clearText;



//    public Encrypt(String sequenceNo, String clearText){
//        super(sequenceNo, "EE0804", 3,"00");
//        this.clearText = clearText;
//    }

    public Decrypt(String sequenceNo, String key, String keyFormat, String cipherText){
        super(sequenceNo, "EE0805", 3,"00");
        this.key = key;
        this.keyFormat = keyFormat;
        this.cipherText = cipherText;
    }


    public byte[] pack()throws IOException {

        String keySpec;
        if(key == null || key.isEmpty()){
            keySpec = keyIndexlength + keyFormat + keyIndex;
        } else {
            keySpec = keyFormat + key;
            String keySpecLength = Integer.toHexString(keySpec.length() / 2).toUpperCase();
            keySpecLength = padLeft(keySpecLength, 2, "0");
            keySpec = keySpecLength + keySpec;
        }
        String cipherTextLength = Integer.toHexString(cipherText.length() / 2).toUpperCase();
        cipherTextLength = padLeft(cipherTextLength, 2, "0");

        String body = functionCode + functionModifier + keySpec + cm + inputChainingValueLength + inputChainingValue + cipherTextLength + cipherText;
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

            byte[] clearTextLengthBytes = new byte[clearTextLengthLen];
            System.arraycopy(data, messageHeaderLen + functionCodeByteLen + responseCodeByteLen + outputChainingValueLengthLen + outputChainingValueLengthInt, clearTextLengthBytes, 0, clearTextLengthLen);
            clearTextLength = hexBinaryConverter.fromBinary2Hex(clearTextLengthBytes);

            int clearTextLengthInt = Integer.parseInt(clearTextLength, 16);
            byte[] clearTextBytes = new byte[clearTextLengthInt];
            System.arraycopy(data, messageHeaderLen + functionCodeByteLen + responseCodeByteLen + outputChainingValueLengthLen + outputChainingValueLengthInt + clearTextLengthLen, clearTextBytes, 0, clearTextLengthInt);
            cipherText = hexBinaryConverter.fromBinary2Hex(clearTextBytes);
        }
    }


    @Override
    public String toString(){
        return super.toString() +
                "\nOutput Chaining Value Length: " + outputChainingValueLength +
                "\nOutput Chaining Value: " + outputChainingValue +
                "\nClear Text Length: " + clearTextLength +
                "\nClear Text: " + cipherText;
    }

}
