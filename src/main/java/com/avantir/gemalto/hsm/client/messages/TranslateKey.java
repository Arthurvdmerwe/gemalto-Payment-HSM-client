package com.avantir.gemalto.hsm.client.messages;

import java.io.IOException;

import com.avantir.gemalto.hsm.client.utils.HSMCipherMode;
import com.avantir.gemalto.hsm.client.utils.HSMUtil;
import com.avantir.gemalto.hsm.client.utils.HexBinaryConverter;

public class TranslateKey extends HsmMsg {

	/**
	 * Translate KEY from Wrapped key to wrapper key(under LMK) for host storing the terminal keys.
	 */
	
	public static final String HSM_HEADER = "01013032";
	protected String wrappedKey = "";
	protected String ecncryptedMasterKey = "";
	
	@Override
	public byte[] pack() throws IOException {
		//log.debug("translateTMKForTLE EE0200, callling HSM");
		StringBuilder sb = new StringBuilder();
		String commandKeyImport = "EE0200";
		String functionModifier = "00";
		String kiSpec = "1111" + wrappedKey;
		String keyType = "04";
		sb.append(commandKeyImport).append(functionModifier).append(kiSpec).append(keyType)
		.append(HSMCipherMode.ECB.getValue()).append("10").append(ecncryptedMasterKey);
		String hexLenghtToData = HSMUtil.getPrefixedHex2BytesLengthtoData(sb.toString());
		String fullDataForHSM = HSM_HEADER + hexLenghtToData;
		//log.debug("Data to HSM translateTMKForTLE():" + fullDataForHSM);
		return HSMUtil.hex2byte(fullDataForHSM);
	}
	
	public TranslateKey(String sequenceNo){
        super(sequenceNo,"EE0200", 3,"00");
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
