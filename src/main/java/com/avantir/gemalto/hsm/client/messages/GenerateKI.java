package com.avantir.gemalto.hsm.client.messages;

import javax.xml.bind.DatatypeConverter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by lekanomotayo on 20/04/2018.
 * Generates Thales ZMK  (Zone Master Key) a.k.a MasterCard KEK, Visa's ZCMK
 *
 */
public class GenerateKI extends GenerateRandomKey {

    public GenerateKI(String sequenceNo){
        super(sequenceNo, KeyType.KI);
    }

}
