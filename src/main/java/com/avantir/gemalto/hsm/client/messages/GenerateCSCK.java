package com.avantir.gemalto.hsm.client.messages;

import javax.xml.bind.DatatypeConverter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by lekanomotayo on 20/04/2018.
 * Generates Thales CSCK (Card Security Code Key), a.k.a Visa's CVK-A, CVK-B
 */
public class GenerateCSCK extends HsmMsg {

    // ADVANCED-RANDOM-KEY-GENERATION (EE0619)


    // Key Specifier
    protected String keySpecifierLength = "17"; // 00 (1 byte)
    protected String keySpecifierFormat = "11"; // (Allowable Formats: 10,11,12,13,14,17,18,1C) (1 byte)
    protected String keySpecifierIndex = "8E4EF08465D83628DD807F5F88B2F181"; // Encrypted KI under HSM (2 - 17 byte)


    //010100000018
    // EE0628
    // 00
    // 03
    // 030001
    // 01008005010101004B30000000000000
    protected String checkDigit;


    public GenerateCSCK(String sequenceNo){
        //super("EE0628", "00");
        super(sequenceNo,"EE0619", 3,"00");
    }


    public byte[] pack()throws IOException{
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        byte[] s = DatatypeConverter.parseHexBinary("010100000018");
//        HexBinaryConverter hexBinaryConverter = new HexBinaryConverter();
        baos.write(DatatypeConverter.parseHexBinary("010100000018"));
        baos.write(DatatypeConverter.parseHexBinary(functionCode));
        baos.write(DatatypeConverter.parseHexBinary(functionModifier));
        baos.write(DatatypeConverter.parseHexBinary(keySpecifierLength));
        baos.write(DatatypeConverter.parseHexBinary(keySpecifierFormat));
        baos.write(DatatypeConverter.parseHexBinary(keySpecifierIndex));

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
