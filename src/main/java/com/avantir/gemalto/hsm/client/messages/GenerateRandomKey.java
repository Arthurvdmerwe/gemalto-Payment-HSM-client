package com.avantir.gemalto.hsm.client.messages;

import javax.xml.bind.DatatypeConverter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by lekanomotayo on 20/04/2018.
 * ADVANCED-RANDOM-KEY-GENERATION (EE0619)
 */
public class GenerateRandomKey extends HsmMsg {

    protected String hsmHostedKeyFormat = "11"; // (Allowable Key format: 10,11,12,13,14,17,18,1C) (1 byte)

    // Key Details
    protected String keyDetailsLength = "01"; // Key Details length?
    protected KeyType keyType; // Key Type to generate

    protected int fieldLengthLen = 1;
    protected int generatedKeyFormatLen = 1;
    protected String fieldLength;
    protected String generatedKeyFormat;
    protected String keyUnderKM;



    public GenerateRandomKey(String sequenceNo, KeyType keyType){
        super(sequenceNo, "EE0619", 3,"00");
        this.keyType = keyType;
    }


    public byte[] pack()throws IOException{

        String body = functionCode + functionModifier + hsmHostedKeyFormat + keyDetailsLength + keyType;
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
//        System.out.println(Arrays.toString(data));

        if("00".equalsIgnoreCase(errorCode)){

            byte[] fieldLengthBytes = new byte[fieldLengthLen];
            System.arraycopy(data, messageHeaderLen + functionCodeByteLen + responseCodeByteLen, fieldLengthBytes, 0, fieldLengthLen);
            fieldLength = hexBinaryConverter.fromBinary2Hex(fieldLengthBytes);

            byte[] keyFormatBytes = new byte[generatedKeyFormatLen];
            System.arraycopy(data, messageHeaderLen + functionCodeByteLen + responseCodeByteLen + fieldLengthLen, keyFormatBytes, 0, generatedKeyFormatLen);
            generatedKeyFormat = hexBinaryConverter.fromBinary2Hex(keyFormatBytes);

            int fieldLengthInt = Integer.parseInt(fieldLength, 16);
            byte[] keyUnderKMBytes = new byte[fieldLengthInt - generatedKeyFormatLen];
            System.arraycopy(data, messageHeaderLen + functionCodeByteLen + responseCodeByteLen + fieldLengthLen + generatedKeyFormatLen, keyUnderKMBytes, 0, fieldLengthInt - generatedKeyFormatLen);
            keyUnderKM = hexBinaryConverter.fromBinary2Hex(keyUnderKMBytes);
        }
    }


    @Override
    public String toString(){
        return super.toString() +
                "\nKey Format: " + hsmHostedKeyFormat +
                "\nKey Type: " + keyType +
                "\nResponse Field Length: " + fieldLength +
                "\nGenerated Key Format: " + generatedKeyFormat +
                "\nDES Key Under KM: " + keyUnderKM;
    }

    public String getKeyUnderKM() {
        return keyUnderKM;
    }
}
