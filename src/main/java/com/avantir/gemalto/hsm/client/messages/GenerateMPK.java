package com.avantir.gemalto.hsm.client.messages;

import javax.xml.bind.DatatypeConverter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by lekanomotayo on 20/04/2018.
 * Generates Thales TAK/TSK/ZAK  (Terminal Authentication Key, Terminal Session key, Zone Authentication Key)
 * Basically, a MAC Protection Key.
 */
public class GenerateMPK extends GenerateRandomKey {

    public GenerateMPK(String sequenceNo){
        super(sequenceNo, KeyType.MPK);
    }
}
