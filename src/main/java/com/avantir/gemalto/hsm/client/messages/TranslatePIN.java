package com.avantir.gemalto.hsm.client.messages;

import java.io.IOException;

import com.avantir.gemalto.hsm.client.utils.HSMUtil;
import com.avantir.gemalto.hsm.client.utils.HexBinaryConverter;

public class TranslatePIN extends HsmMsg {

	/**
	 * Translate PIN block coming from Device to Acquirer host PWK key.
	 * For sending in DE52 sale request to authorize the transaction.
	 */
	
	public static final String HSM_HEADER = "01013032";
	protected String pan = "4386123412341234";
	protected String keyIndex = "01";
	protected String wrappedKey = "";
	protected String encryptedPinBlock = "";
	protected String ksn = "";
	
	
	@Override
	public byte[] pack() throws IOException {
		//log.debug("translatePinBlockNonDukpt EE0602, calling HSM ");
		pan = HSMUtil.extractAccountNumberPart(pan);
		StringBuilder sb = new StringBuilder();
		String functionCodeTranslatePIN = "EE0602";
		String functionModifier = "00";
		String kiSpec = "0F200200" + keyIndex + ksn + "02";
		String pinBlockFormat = "10";
		String koSpec = "1111" + wrappedKey;
		sb.append(functionCodeTranslatePIN).append(functionModifier).append(encryptedPinBlock).append(kiSpec)
		.append(pinBlockFormat).append(pan).append(pinBlockFormat).append(koSpec);
		String hexLenghtToData = HSMUtil.getPrefixedHex2BytesLengthtoData(sb.toString());
		String fullDataForHSM = HSM_HEADER + hexLenghtToData;
		//log.debug("Data to HSM translatePinBlockNonDukpt():" + fullDataForHSM);
		return HSMUtil.hex2byte(fullDataForHSM);
	}
	
	public TranslatePIN(String sequenceNo){
        super(sequenceNo,"EE0602", 3,"00");
    }
	
	@Override
    public String toString(){
        return "\nRequest Data: " +  HexBinaryConverter.fromBinary2Hex(requestData) +
                "\nResponse Data: " +  HexBinaryConverter.fromBinary2Hex(responseData) +
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

}
