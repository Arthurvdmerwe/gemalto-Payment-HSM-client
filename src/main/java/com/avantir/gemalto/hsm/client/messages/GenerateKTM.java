package com.avantir.gemalto.hsm.client.messages;

import com.avantir.gemalto.hsm.client.utils.HexBinaryConverter;

import javax.xml.bind.DatatypeConverter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by lekanomotayo on 20/04/2018.
 * Generates Thales TMK  (Terminal Master Key)
 */
public class GenerateKTM extends GenerateRandomKey {


    public GenerateKTM(String sequenceNo){
        super(sequenceNo, KeyType.KTM);
    }


}
