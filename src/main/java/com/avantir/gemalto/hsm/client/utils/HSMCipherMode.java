package com.avantir.gemalto.hsm.client.utils;

public enum HSMCipherMode {
	ECB("00"),
	CBC("01");
	
	private String value;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	HSMCipherMode(String value){
		this.value = value;
	}
}
