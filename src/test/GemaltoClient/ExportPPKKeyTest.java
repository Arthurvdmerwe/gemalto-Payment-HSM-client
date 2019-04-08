
import org.junit.Test;

/**
 * Created by lekanomotayo on 20/04/2018.
 */
public class ExportPPKKeyTest {



    @Test
    public void testExportKeyUnderHostKey() throws Exception{

        // Key types
        // 00 - DPK, 01 - PPK, 02 - MPK, 05 - KTM, 10 - KI
        System.out.println("--Export Key Under Pin Protection Key Test--");
        ExportPPKKey exportKey = new ExportPPKKey("0001", "8E4EF08465D83628DD807F5F88B2F181", "4885D70183248097F9E4B640011EDECF");
        byte[] request = exportKey.pack();

        //System.out.println(Arrays.toString(request));
        HSMConnection hsmConnection = new HSMConnection();
        byte[] recvd = hsmConnection.send_recv(request);
        //System.out.println(Arrays.toString(recvd));

        exportKey.unpack(recvd);
        System.out.println(exportKey);
    }

}
