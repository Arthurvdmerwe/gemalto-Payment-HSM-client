import Common.HSMConnection;
import org.junit.Test;

/**
 * Created by lekanomotayo on 20/04/2018.
 */
public class EncryptTest {


    @Test
    public void testEncrypt() throws Exception{
        System.out.println("--Encrypt Test--");
        Encrypt encrypt = new Encrypt("0001", "0969B047265CD2D555296CE552878FFA", "11","0000000000000000");
        byte[] request = encrypt.pack();

        //System.out.println(Arrays.toString(request));
        HSMConnection hsmConnection = new HSMConnection();
        byte[] recvd = hsmConnection.send_recv(request);
        //System.out.println(Arrays.toString(recvd));

        encrypt.unpack(recvd);
        System.out.println(encrypt);
    }
}
