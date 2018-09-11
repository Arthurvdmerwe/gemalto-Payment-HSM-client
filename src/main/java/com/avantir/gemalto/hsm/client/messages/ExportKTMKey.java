package com.avantir.gemalto.hsm.client.messages;

/**
 * Created by lekanomotayo on 20/04/2018.
 * Exports KTM (Terminal Master Key) Key under given KI (Interchange Key)
 *
 */
public class ExportKTMKey extends ExportKey {

    public ExportKTMKey(String sequenceNo, String parentKey, String key){
        super(sequenceNo, parentKey, key, KeyType.KTM);
    }

}
