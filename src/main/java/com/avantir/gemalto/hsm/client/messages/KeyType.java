package com.avantir.gemalto.hsm.client.messages;

public enum KeyType {

    DPK("00"),
    PPK("01"),
    MPK("02"),
    KTM("05"),
    KI("10");

    private final String name;

    private KeyType(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
