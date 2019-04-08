import org.junit.Test;

/**
 * Created by lekanomotayo on 20/04/2018.
 */
public class ExportMPKKeyTest {



    @Test
    public void testExportKeyUnderHostKey() throws Exception{

        // Key types
        // 00 - DPK, 01 - PPK, 02 - MPK, 05 - KTM, 10 - KI
        System.out.println("--Export Key Under Master Pin Key Key Test--");
        ExportMPKKey exportKey = new ExportMPKKey("0001", "8E4EF08465D83628DD807F5F88B2F181", "F1FD7C7581E7F5AEBE1997A47F047568");
        byte[] request = exportKey.pack();

        //System.out.println(Arrays.toString(request));
        HSMConnection hsmConnection = new HSMConnection();
        byte[] recvd = hsmConnection.send_recv(request);
        // System.out.println(Arrays.toString(recvd));

        exportKey.unpack(recvd);
        System.out.println(exportKey);
    }

}
