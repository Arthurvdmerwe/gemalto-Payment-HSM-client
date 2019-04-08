
import org.junit.Test;

/**
 * Created by lekanomotayo on 20/04/2018.
 */
public class DecryptTest {


    @Test
    public void testEncrypt() throws Exception{

        System.out.println("--Decrypt Test--");
        Decrypt decrypt = new Decrypt("0001", "0969B047265CD2D555296CE552878FFA", "11","6749AE56AA676EE8");
        byte[] request = decrypt.pack();

        //System.out.println(Arrays.toString(request));
        HSMConnection hsmConnection = new HSMConnection();
        byte[] recvd = hsmConnection.send_recv(request);
        //System.out.println(Arrays.toString(recvd));

        decrypt.unpack(recvd);
        System.out.println(decrypt);
    }
}
