/**
 * Created by lekanomotayo on 20/04/2018.
 * Generates Thales ZPK/TPK (Zone PIN Key/Terminal PIN Key), a.k.a Mastercard KPE, Visa's IWK,AWK
 */
public class GeneratePPK extends GenerateRandomKey {

    public GeneratePPK(String sequenceNo){
        super(sequenceNo, KeyType.PPK);
    }
}
