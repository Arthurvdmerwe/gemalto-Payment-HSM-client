package com.avantir.gemalto.hsm.client.messages;

import javax.xml.bind.DatatypeConverter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by lekanomotayo on 20/04/2018.
 * Generates Thales ZPK/TPK (Zone PIN Key/Terminal PIN Key), a.k.a Mastercard KPE, Visa's IWK,AWK
 */
public class GeneratePPK extends GenerateRandomKey {

    public GeneratePPK(String sequenceNo){
        super(sequenceNo, KeyType.PPK);
    }
}
