
import org.junit.Test;

/**
 * Created by lekanomotayo on 20/04/2018.
 */
public class GenerateMPKTest {


    @Test
    public void testGenerateMPK() throws Exception{
        System.out.println("--Generate Master Pin Key Test--");
        GenerateMPK generateMPK = new GenerateMPK("0001");
        byte[] request = generateMPK.pack();

        //System.out.println(Arrays.toString(request));
        HSMConnection hsmConnection = new HSMConnection();
        byte[] recvd = hsmConnection.send_recv(request);
        //System.out.println(Arrays.toString(recvd));

        generateMPK.unpack(recvd);
        System.out.println(generateMPK);


    }
}
