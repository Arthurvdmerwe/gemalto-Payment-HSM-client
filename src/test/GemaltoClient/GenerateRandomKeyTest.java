
import org.junit.Test;

/**
 * Created by lekanomotayo on 20/04/2018.
 */
public class GenerateRandomKeyTest {

    @Test
    public void testGenerateRandomKey() throws Exception{
        System.out.println("--Generate Random Key Test--");
        GenerateRandomKey generateRandomKey = new GenerateRandomKey("0002", KeyType.KTM);
        byte[] request = generateRandomKey.pack();

        //System.out.println(Arrays.toString(request));
        HSMConnection hsmConnection = new HSMConnection();
        byte[] recvd = hsmConnection.send_recv(request);
        //System.out.println(Arrays.toString(recvd));

        generateRandomKey.unpack(recvd);
        System.out.println(generateRandomKey);
    }
}
