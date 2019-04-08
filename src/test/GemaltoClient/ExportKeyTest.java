
import org.junit.Test;

/**
 * Created by lekanomotayo on 20/04/2018.
 */
public class ExportKeyTest {


    /**
     *
     * Random Test Key:
     * Clear Key Component 1: 0723CD4CDDF25A1F8F3517EEABE482C9
     * Clear Key Component 1 Check Digit: E2AC18
     * Clear Key Component 2: 227A6A90957517C2E22CBC934EC55187
     * Clear Key Component 2 Check Digit: 1E656F
     * Clear Key (KI): 2559A7DC48874DDD6D19AB7DE521D34E
     * Encrypted under Gemalto HSM KM: 8E4EF08465D83628DD807F5F88B2F181
     * Check Digit: 7FF5B8
     *
     * NIBSS Test Key:
     * Clear Key Component 1: 5D25072F04832A2329D93E4F91BA23A2
     * Clear Key Component 1 Check Digit: DF384F3A5CC775EA
     * Clear Key Component 2: 86CBCDE3B0A22354853E04521686863D
     * Clear Key Component 2 Check Digit: 81D6DBC62DA48DE2
     * Clear Key (KI): DBEECACCB4210977ACE73A1D873CA59F
     * Encrypted under Gemalto HSM KM:
     * Check Digit: 1DDD47BD92AFD310
     *
     */

    @Test
    public void testExportKeyUnderHostKey() throws Exception{

        // Key types
        // 00 - DPK, 01 - PPK, 02 - MPK, 05 - KTM, 10 - KI
        System.out.println("--Export Key Under Data Protection Key Test--");
        ExportKey exportKey = new ExportKey("0001", "8E4EF08465D83628DD807F5F88B2F181", "0969B047265CD2D555296CE552878FFA", KeyType.DPK);
        byte[] request = exportKey.pack();

        //System.out.println(Arrays.toString(request));
        HSMConnection hsmConnection = new HSMConnection();
        byte[] recvd = hsmConnection.send_recv(request);
        //System.out.println(Arrays.toString(recvd));

        exportKey.unpack(recvd);
        System.out.println(exportKey);
    }
//
//    @Test
//    public void testExportKeyUnderHSMHostedKey() throws Exception{
//
//        // Key types
//        // 00 - DPK, 01 - PPK, 02 - MPK, 05 - KTM, 10 - KI
//
//        ExportKey exportKey = new ExportKey("0001", "0969B047265CD2D555296CE552878FFA", "11", KeyType.DPK);
//        byte[] request = exportKey.pack();
//
//        System.out.println(Arrays.toString(request));
//        Common.HSMConnection hsmConnection = new Common.HSMConnection("34.241.226.196", 6060);
//        byte[] recvd = hsmConnection.send_recv(request);
//        System.out.println(Arrays.toString(recvd));
//
//        exportKey.unpack(recvd);
//        System.out.println(exportKey);
//    }
}
