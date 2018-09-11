package com.avantir.gemalto.hsm.client.messages;

/**
 * Created by lekanomotayo on 20/04/2018.
 * Exports PPK (PIN Protection Key) Key under given KI (Interchange Key)
 *
 */
public class ExportPPKKey extends ExportKey {

    public ExportPPKKey(String sequenceNo, String parentKey, String key){
        super(sequenceNo, parentKey, key, KeyType.PPK);
    }

}
