package com.avantir.gemalto.hsm.client.utils;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;


public class HSMUtil {
	
	//private static final Logger logger = LoggerFactory.getLogger(HSMUtil.class);
	
	static Map<String,String> errorCodesMap = null;
	static {
		errorCodesMap = new HashMap<String, String>();
		errorCodesMap.put("00","Success");
		errorCodesMap.put("01"," DES Fault (system disabled)");
		errorCodesMap.put("02"," Illegal Function Code.Either, PIN mailing, or Log archiving is not enabled on console.Function is disabled in console.");
		errorCodesMap.put("03"," Incorrect message length");
		errorCodesMap.put("04"," Invalid data in message: Character not in range (0-9, A-F)");
		errorCodesMap.put("05"," Invalid key index: Index not defined, key with this Index not stored or incorrect key length");
		errorCodesMap.put("06"," Invalid PIN format specifier: only AS/ANSI = 1 & PIN/PAD = 3 specified");
		errorCodesMap.put("07"," PIN format error: PIN does not comply with the AS2805.3 1985 specification, is in an invalid PIN/PAD format, or is in an invalid Docutel format");
		errorCodesMap.put("08"," Verification failure");
		errorCodesMap.put("09"," Contents of key memory destroyed: e.g. the Luna EFT was tampered or all Keys deleted");
		errorCodesMap.put("0A"," Uninitiated key accessed. Key or decimalization table (DT) is not stored in the Luna EFT.");
		errorCodesMap.put("0B"," Checklength Error. Customer PIN length is less than the minimum PVK length or less than Checklen in function.");
		errorCodesMap.put("0C"," Inconsistent Request Fields: inconsistent field size.");
		errorCodesMap.put("0F"," Invalid VISA Index. Invalid VISA PIN verification key indicator.");
		errorCodesMap.put("10"," Internal Error");
		errorCodesMap.put("11"," Errlog file does not exist");
		errorCodesMap.put("12"," Errlog internal error");
		errorCodesMap.put("13"," Errlog request length invalid");
		errorCodesMap.put("14"," Errlog file number invalid");
		errorCodesMap.put("15"," Errlog index number invalid");
		errorCodesMap.put("16"," Errlog date time invalid");
		errorCodesMap.put("17"," Errlog before/after flag invalid");
		errorCodesMap.put("19"," Unsupported key type");
		errorCodesMap.put("1A","Duplicate key or record");
		errorCodesMap.put("20","Invalid key specifier length");
		errorCodesMap.put("21"," Unsupported key specifier");
		errorCodesMap.put("22"," Invalid key specifier content");
		errorCodesMap.put("23"," Invalid key specifier format");
		errorCodesMap.put("24"," Invalid Function Modifier. Invalid = 00");
		errorCodesMap.put("25"," Invalid key attributes");
		errorCodesMap.put("27"," Hash process failed");
		errorCodesMap.put("28"," Invalid Key Type");
		errorCodesMap.put("29"," Unsupported Triple Des Index");
		errorCodesMap.put("30"," Invalid administrator signature");
		errorCodesMap.put("32"," No administration session");
		errorCodesMap.put("33"," Invalid file type");
		errorCodesMap.put("34"," Invalid signature");
		errorCodesMap.put("35"," KKL disabled");
		errorCodesMap.put("36"," No PIN pad");
		errorCodesMap.put("37"," Pin pad timeout");
		errorCodesMap.put("39"," Public key pair not available");
		errorCodesMap.put("3A"," Public key pair generating");
		errorCodesMap.put("3B"," RSA cipher error");
		errorCodesMap.put("40"," Unsupported HSM stored SEED key");
		errorCodesMap.put("50"," Invalid Variant Scheme");
		errorCodesMap.put("50"," Invalid SDF");
		errorCodesMap.put("51"," Invalid hash indicator");
		errorCodesMap.put("52"," Invalid public key algorithm");
		errorCodesMap.put("53"," Public key pair incompatible");
		errorCodesMap.put("54"," RSA key length error");
		errorCodesMap.put("60"," Software already Loaded");
		errorCodesMap.put("61"," Software being loaded from CD ROM");
		errorCodesMap.put("62"," Software data segment too large");
		errorCodesMap.put("63"," Invalid offset value");
		errorCodesMap.put("64"," Software loading not initiated");
		errorCodesMap.put("65"," Unsupported file id");
		errorCodesMap.put("66"," Unsupported control id");
		errorCodesMap.put("67"," Software image is being verified");
		errorCodesMap.put("70"," Invalid PIN Block flag");
		errorCodesMap.put("71"," Invalid PIN Block random padding");
		errorCodesMap.put("72"," Invalid PIN Block delimiter");
		errorCodesMap.put("73"," Invalid PIN Block RB");
		errorCodesMap.put("74"," Invalid PIN Block. Random number invalid");
		errorCodesMap.put("75"," Invalid PIN Block RA");
		errorCodesMap.put("76"," Invalid PIN Block PIN");
		errorCodesMap.put("77"," Invalid PIN Block PIN length");
		errorCodesMap.put("78"," PIN Block format disabled or requested reformatting not allowed");
		errorCodesMap.put("79"," Validation data check failed");
		errorCodesMap.put("7F"," Invalid Print Token");
		errorCodesMap.put("80"," OAEP Decode Error");
		errorCodesMap.put("81"," OAEP Invalid Header Byte");
		errorCodesMap.put("82"," OAEP Invalid PIN Block");
		errorCodesMap.put("83"," OAEP Invalid Random Number");
		errorCodesMap.put("90"," General Printer Error");
		errorCodesMap.put("F0"," Zero length PIN");
		errorCodesMap.put("91"," Invalid Key Block version Id");
		errorCodesMap.put("92"," Key Block Key authentication failure");
		errorCodesMap.put("93"," Invalid Key Usage");
		errorCodesMap.put("94"," Invalid Algorithms");
		errorCodesMap.put("95"," Invalid Mode of use");
		errorCodesMap.put("96"," Invalid Version number");
		errorCodesMap.put("97"," Invalid Export Flag");
		errorCodesMap.put("98"," Invalid Key length");
		errorCodesMap.put("99"," Invalid Reserve Field");
		errorCodesMap.put("9A"," Invalid Number of optional block");
		errorCodesMap.put("9B"," Invalid Optional block header");
		errorCodesMap.put("9C"," Repeated Optional block");
		errorCodesMap.put("9D"," Invalid Key Block");
		errorCodesMap.put("9E"," Invalid Padding Indicator");
		errorCodesMap.put("9F"," Key Translation not permitted");
		errorCodesMap.put("0xA0"," PIN brute force attack detected");
	}
	
	public static String hexToAscii(String s) {
		  int n = s.length();
		  StringBuilder sb = new StringBuilder(n / 2);
		  for (int i = 0; i < n; i += 2) {
		    char a = s.charAt(i);
		    char b = s.charAt(i + 1);
		    sb.append((char) ((hexToInt(a) << 4) | hexToInt(b)));
		  }
		  return sb.toString();
	}
	
	private static int hexToInt(char ch) {
		  if ('a' <= ch && ch <= 'f') { return ch - 'a' + 10; }
		  if ('A' <= ch && ch <= 'F') { return ch - 'A' + 10; }
		  if ('0' <= ch && ch <= '9') { return ch - '0'; }
		  throw new IllegalArgumentException(String.valueOf(ch));
		}
	
	public static int hex2decimal(String s) {
		int decimal = Integer.parseInt(s, 16);
		return decimal;
	}
	
	public static String extractAccountNumberPart(String accountNumber) {
        String accountNumberPart = null;
        try {
            accountNumberPart = takeLastN(accountNumber, 13);
            accountNumberPart = takeFirstN(accountNumberPart, 12);
        } catch(Exception ignored) {
        	
        }
        return  accountNumberPart;
    }
	
	public static String takeLastN(String s, int n) throws Exception {
		if (s.length() > n) {
			return s.substring(s.length() - n);
		} else {
			if (s.length() < n) {
				return zeropad(s, n);
			} else {
				return s;
			}
		}
	}
	 
	public static String takeFirstN(String s, int n) throws Exception {
		if (s.length() > n) {
			return s.substring(0, n);
		} else {
			if (s.length() < n) {
				return zeropad(s, n);
			} else {
				return s;
			}
		}
	}
	
	public static String zeropad(String s, int len) throws Exception {
        return padleft(s, len, '0');
    }
	
	public static String formatTrackData(String trackData,String format){
		if(format.equalsIgnoreCase("01")){
			// 0's padding conversion
			String track2Padded = null;
			int track2PaddeRemander = trackData.length() %16;
			int totalLengthToBePadded = trackData.length()+16 - track2PaddeRemander;
			track2Padded = padleft(trackData, totalLengthToBePadded, '0');
			return  track2Padded;
		} else if(format.equalsIgnoreCase("00")) {
			//ASCII conversion
			String track2Padded = padleft(trackData, 40, '0');
			String asciiData = hexString(getISO8859EncodedBytes(track2Padded));
			return asciiData;
		}
		return null;
	}
	
	public static String formatPANData(String panData,String format) {
		String cardNumberPadded = null;
		if(format.equalsIgnoreCase("01")){
				cardNumberPadded = padleft(panData, 32, '0');
		}
		else  if(format.equalsIgnoreCase("00")){
			if(panData.length()<=16){
				cardNumberPadded = padleft(panData, 16, '0');
				cardNumberPadded = hexString(getISO8859EncodedBytes(cardNumberPadded));
			}
			else{
				cardNumberPadded = padleft(panData, 24, '0');
				cardNumberPadded = hexString(getISO8859EncodedBytes(cardNumberPadded));
			}
		}
		return cardNumberPadded;
	}
	
	public static String formatExpData(String expData,String format){
		String expPadded = null;
		if(format.equalsIgnoreCase("01")){
				expPadded = padleft(expData, 16, '0');
		}
		else  if(format.equalsIgnoreCase("00")){
				expPadded = padleft(expData, 8, '0');
				expPadded = hexString(getISO8859EncodedBytes(expPadded));
		}
		return expPadded;
	}	
	
	public static String padright(String s, int len, char c){
		s = s.trim();

		StringBuilder d = new StringBuilder(len);
		int fill = len - s.length();
		d.append(s);
		while (fill-- > 0)
			d.append(c);
		return d.toString();
	}
	
	private static byte[] getISO8859EncodedBytes(String data)
	{
		try
		{
			return data.getBytes("ISO_8859_1");
		}
		catch(UnsupportedEncodingException e)
		{
			return data.getBytes();
		}
	}
	
	public static String padleft(String s, int len, char c){
		s = s.trim();
		//if (s.length() > len)
		//  throw new Exception("invalid len " +s.length() + "/" +len);
		StringBuilder d = new StringBuilder (len);
		int fill = len - s.length();
		while (fill-- > 0)
			d.append (c);
		d.append(s);
		return d.toString();
	}
	
	public static String getLHex(String asc)
	{
		byte bytes[] = hex2byte(asc);
		int len = bytes.length;
		String hex = hexString(bytes);
		String hl = Integer.toHexString(len);
		if(hl.length() < 2)
			hl = (new StringBuilder()).append("0").append(hl).toString();
		return (new StringBuilder()).append(hl).append(hex).toString();
	}
	
	public static int byteToInt(byte b[])
	{
		int val = 0;
		int i = b.length - 1;
		for(int j = 0; i >= 0; j++)
		{
			val += (b[i] & 0xff) << 8 * j;
			i--;
		}

		return val;
	}
	
	public static String hexString(byte[] b)
	{
		StringBuffer d = new StringBuffer(b.length * 2);
		for (int i = 0; i < b.length; ++i) {
			char hi = Character.forDigit(b[i] >> 4 & 0xF, 16);
			char lo = Character.forDigit(b[i] & 0xF, 16);
			d.append(Character.toUpperCase(hi));
			d.append(Character.toUpperCase(lo));
		}
		return d.toString();
	}
	
	public static String getPrefixedHex2BytesLengthtoData(String hex){
		byte bytes[] = hex2byte(hex);
		int len = bytes.length;
		String hl = Integer.toHexString(len);
		if(hl.length()==1){
			hl = (new StringBuilder()).append("000").append(hl).toString();
		}
		else if(hl.length()==2){
			hl = (new StringBuilder()).append("00").append(hl).toString();	
		}
		else if(hl.length()==3){
			hl = (new StringBuilder()).append("0").append(hl).toString();	
		}
		return (new StringBuilder()).append(hl).append(hex).toString();
	}
	
	public static byte[] hex2byte(String s)
	{
		if (s.length() % 2 == 0) {
			return hex2byte(s.getBytes(), 0, s.length() >> 1);
		}

		return hex2byte("0" + s);
	}
	
	public static byte[] hex2byte(byte[] b, int offset, int len)
	{
		byte[] d = new byte[len];
		for (int i = 0; i < len * 2; ++i) {
			int shift = (i % 2 == 1) ? 0 : 4;
			int tmp35_34 = (i >> 1);
			byte[] tmp35_30 = d; tmp35_30[tmp35_34] = (byte)(tmp35_30[tmp35_34] | Character.digit((char)b[(offset + i)], 16) << shift);
		}
		return d;
	}
	
	public static String asciiToHex(String asciiValue)
	{
	    char[] chars = asciiValue.toCharArray();
	    StringBuffer hex = new StringBuffer();
	    for (int i = 0; i < chars.length; i++)
	    {
	        hex.append(Integer.toHexString((int) chars[i]));
	    }
	    return hex.toString();
	}
	
	public static String toHexString(byte[] ba) {
	    StringBuilder str = new StringBuilder();
	    for(int i = 0; i < ba.length; i++)
	        str.append(String.format("%x", ba[i]));
	    return str.toString();
	}

	public static String fromHexString(String hex) {
	    StringBuilder str = new StringBuilder();
	    for (int i = 0; i < hex.length(); i+=2) {
	        str.append((char) Integer.parseInt(hex.substring(i, i + 2), 16));
	    }
	    return str.toString();
	}
	
}
