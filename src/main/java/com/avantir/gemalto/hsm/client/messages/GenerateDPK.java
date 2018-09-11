package com.avantir.gemalto.hsm.client.messages;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

/**
 * Created by lekanomotayo on 20/04/2018.
 * Generates Thales ZEK/DEK  (Zone Encryption Key/Data Encryption Key)
 */
public class GenerateDPK extends GenerateRandomKey {

    public GenerateDPK(String sequenceNo){
        super(sequenceNo, KeyType.DPK);
    }
}
