package com.avantir.gemalto.hsm.client.messages;


import com.avantir.gemalto.hsm.client.utils.HexBinaryConverter;

import java.io.IOException;

/**
 * Created by lekanomotayo on 20/04/2018.
 */
public abstract class HsmMsg {


//    Formats
    // 10 -14 - Key is stored on HSM host and encrypted under HSM KM at index 1
    // 1C, 17, 18 - Key is stored on HSM host and encrypted under KM specified in the request

    /*
    Key Specifier Formats for HSM-stored Keys
    00 - 03
    Key Specifier Formats for KM-encrypted Keys
    04 - 07
    Key Specifier Format for Explicit Key Type Identification
    08
    Key Specifier Formats for Host-stored Keys
    10 -20

     */

    protected static final HexBinaryConverter hexBinaryConverter = new HexBinaryConverter();

    protected int messageHeaderLen = 6;
    protected int responseHeaderSohCharacterByteLen = 1;
    protected int responseHeaderVersionByteLen = 1;
    protected int responseSequenceByteLen = 2;
    protected int functionCodeByteLen;
    protected int responseCodeByteLen = 1;



    protected static final String requestHeaderSohCharacter = "01";
    protected static final String requestHeaderVersion = "01";
    protected String requestSequenceNo;
    protected String functionCode;
    protected String functionModifier;

    protected String responseHeaderSohCharacter;
    protected String responseHeaderVersion;
    protected String responseSequenceNo;
    protected String responseHeader;
    protected String responseFunctionCode;
    protected String errorCode;

    protected byte[] requestData;
    protected byte[] responseData;



    public HsmMsg(String requestSequenceNo, String functionCode, int functionCodeByteLen, String functionModifier){
        this.requestSequenceNo = requestSequenceNo;
        this.functionCode = functionCode;
        this.functionCodeByteLen = functionCodeByteLen;
        this.functionModifier = functionModifier;
    }

    public abstract byte[] pack() throws IOException;

    public void unpack(byte[] data){
        String str_recvd = hexBinaryConverter.fromBinary2Hex(data);

        byte[] resp_hder_soh_byte = new byte[responseHeaderSohCharacterByteLen];
        System.arraycopy(data, 0, resp_hder_soh_byte, 0, responseHeaderSohCharacterByteLen);
        responseHeaderSohCharacter = hexBinaryConverter.fromBinary2Hex(resp_hder_soh_byte);

        byte[] resp_hder_version_byte = new byte[responseHeaderVersionByteLen];
        System.arraycopy(data, responseHeaderSohCharacterByteLen, resp_hder_version_byte, 0, responseHeaderVersionByteLen);
        responseHeaderVersion = hexBinaryConverter.fromBinary2Hex(resp_hder_version_byte);

        byte[] resp_sequence_byte = new byte[responseSequenceByteLen];
        System.arraycopy(data, responseHeaderSohCharacterByteLen + responseHeaderVersionByteLen, resp_sequence_byte, 0, responseSequenceByteLen);
        responseSequenceNo = hexBinaryConverter.fromBinary2Hex(resp_sequence_byte);

        byte[] response_code_byte = new byte[functionCodeByteLen];
        System.arraycopy(data, messageHeaderLen, response_code_byte, 0, functionCodeByteLen);
        responseFunctionCode = hexBinaryConverter.fromBinary2Hex(response_code_byte);

        byte[] error_code_byte = new byte[responseCodeByteLen];
        System.arraycopy(data, messageHeaderLen + functionCodeByteLen, error_code_byte, 0, responseCodeByteLen);
        errorCode = hexBinaryConverter.fromBinary2Hex(error_code_byte);
    }

    public int getMessageHeaderLen() {
        return messageHeaderLen;
    }


    public String getResponseHeader() {
        return responseHeader;
    }


    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String toString(){
        return "\nRequest Data: " +  hexBinaryConverter.fromBinary2Hex(requestData) +
                "\nResponse Data: " +  hexBinaryConverter.fromBinary2Hex(responseData) +
                "\nRequest Header SOH Character: " + requestHeaderSohCharacter +
                "\nRequest Header Version: " + requestHeaderVersion +
                "\nRequest Sequence: " + requestSequenceNo +
                "\nFunction Code: " + functionCode +
                "\nFunction Modifier: " + functionModifier +
                "\nResponse Header SOH Character: " + responseHeaderSohCharacter +
                "\nResponse Header Version: " + responseHeaderVersion +
                "\nResponse Sequence: " + responseSequenceNo +
                "\nResponse Function Code: " + responseFunctionCode +
                "\nError Code: " + errorCode;

    }


    public String padLeft(String str, int len, String pad){
        StringBuilder sb = new StringBuilder();
        int remainLen = len - str.length();
        for(int i=0; i<remainLen; i++){
            sb.append(pad);
        }
        sb.append(str);
        return sb.toString();
    }
}
