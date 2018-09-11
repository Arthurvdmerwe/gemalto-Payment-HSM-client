package com.avantir.gemalto.hsm.client.messages;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by lekanomotayo on 20/04/2018.
 */
public class GeneratePIN extends HsmMsg {

    protected String pinLength = "04"; // 00 (1 byte)
    protected String outputPinBlockFormat = "14"; // 01 - 3DES, 03 - HMAC-SHA-1 (1 byte)
    protected String anbSpeclength = "0E"; //128bit per key (2 bytes)
    protected String anbformat = "00"; // 05 = KTM, 02 = MPK, 01 = PPK (1 byte)
    protected String anbBufferLength = "0A";
    protected byte[] anbBuffer = {41,23,66,66,66,66,66,66,66,60}; // 01 = Encrypted Key, 02 = Binary Key Block   (TR-31) (1 byte)
    protected String anbStartOffset = "04";
    protected String anbLength = "0C";

    //Variable Length - ppg 43 (Host function guide)
    protected String ppkKeySpecifierLength = "8082"; // 00 = not required, 01 = 3 byte standard KVC (1 byte)
    protected String keySpecifier = "17"; //‘A’ (for GISKE), ‘2’ (for Verifone), 00 (for binary key Block) (1 byte)
    protected String kmSpecifier = "00";
    protected byte[] ppkKeyBlock = {42,30,31,32,38,50,30,41}; // E -Encrypt only, 00 - Null,
    protected byte[] keyblockVersion = {42,30,30,0x4E,30,32,30,30}; // 0000 - null
    protected byte[] key = { 50,42,30,38,30,31,32,33,
            31,30,38,30,32,44,45,37,
            34,33,34,44,37,45,38,39,
            30,45,30,39,36,33,35,31,
            30,35,38,43,44,32,35,38,
            45,39,35,33,46,46,37,34,
            33,46,31,45,38,45,37,37,
            43,34,35,42,41,42,45,30,
            37,31,37,45,41,39,32,34,
            46,45,31,35,33,43,36,30,
            33,37,31,45,46,42,32,37,
            46,45,31,41,34,41,41,41,
            30,37,41,32,45,34,34,42
    }; // 00 - null


    public GeneratePIN(String sequenceNo){
        //super("EE0628", "00");
        super(sequenceNo,"EE0E08", 3,"00");
    }


    public byte[] pack()throws IOException{
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        baos.write(functionCode.getBytes());
        baos.write(functionModifier.getBytes());
        baos.write(pinLength.getBytes());
        baos.write(outputPinBlockFormat.getBytes());
        baos.write(anbSpeclength.getBytes());
        baos.write(anbformat.getBytes());
        baos.write(anbBufferLength.getBytes());
        baos.write(anbBuffer);
        baos.write(anbStartOffset.getBytes());
        baos.write(anbLength.getBytes());
        baos.write(ppkKeySpecifierLength.getBytes());
        baos.write(keySpecifier.getBytes());
        baos.write(kmSpecifier.getBytes());
        baos.write(ppkKeyBlock);
        baos.write(keyblockVersion);
        baos.write(key);

        byte[] request_data = baos.toByteArray();
        ByteArrayOutputStream raw_data = new ByteArrayOutputStream();
//        byte[] len = hexBinaryConverter.fromShort2Hex2((short) (request_data.length + 4));
//        raw_data.write(len);
//        raw_data.write(requestHeader);
        raw_data.write(request_data);
        requestData = raw_data.toByteArray();
        return requestData;
    }

    public void unpack(byte[] data){
        responseData = data;
        super.unpack(data);
//        if("00".equalsIgnoreCase(errorCode)){
//            byte[] keySchemeUnderZmkBytes = new byte[1];
//            System.arraycopy(data, messageHeaderLen + 6, keySchemeUnderZmkBytes, 0, 1);
//            keySchemeUnderZmk = new String(keySchemeUnderZmkBytes);
//            byte[] keyUnderZmkBytes = new byte[32];
//            System.arraycopy(data, messageHeaderLen + 7, keyUnderZmkBytes, 0, 32);
//            keyUnderZmk = new String(keyUnderZmkBytes);
//            byte[] keySchemeUnderLmkBytes = new byte[1];
//            System.arraycopy(data, messageHeaderLen + 39, keySchemeUnderLmkBytes, 0, 1);
//            keySchemeUnderLmk = new String(keySchemeUnderLmkBytes);
//            byte[] keyUnderLmkBytes = new byte[32];
//            System.arraycopy(data, messageHeaderLen + 40, keyUnderLmkBytes, 0, 32);
//            keyUnderLmk = new String(keyUnderLmkBytes);
//            byte[] checkDigitBytes = new byte[16];
//            System.arraycopy(data, messageHeaderLen + 72, checkDigitBytes, 0, 16);
//            checkDigit = new String(checkDigitBytes);
//        }
    }


    @Override
    public String toString(){
        return super.toString();// +
//                "\nDES Key Type: " + desKeyType +
//                "\nDelimiter: " + delimiter +
//                "\nZMK Key Scheme: " + zmkKeyScheme +
//                "\nLMK Key Scheme: " + lmkKeyScheme +
//                "\nZMK Key: " + zmk +
//                "\nKey Scheme Under ZMK: " + keySchemeUnderZmk +
//                "\nKey Under ZMK: " + keyUnderZmk +
//                "\nKey Scheme Under LMK: " + keySchemeUnderLmk +
//                "\nKey Under LMK: " + keyUnderLmk +
//                "\nCheck Digit: " + checkDigit;
    }

}
