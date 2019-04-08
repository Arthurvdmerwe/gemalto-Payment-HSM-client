

/**
 * Created by lekanomotayo on 20/04/2018.
 * Exports MPK (MAC Protection Key) Key under given KI (Interchange Key)
 *
 */
public class ExportMPKKey extends ExportKey {

    public ExportMPKKey(String sequenceNo, String parentKey, String key){
        super(sequenceNo, parentKey, key, KeyType.MPK);
    }

}
