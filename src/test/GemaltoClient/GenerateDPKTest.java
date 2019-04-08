
import org.junit.Test;

/**
 * Created by lekanomotayo on 20/04/2018.
 */
public class GenerateDPKTest {


    @Test
    public void testGenerateDPK() throws Exception{

        System.out.println("--Generate Data Protection Key Test--");
        GenerateDPK generateDPK = new GenerateDPK("0001");
        byte[] request = generateDPK.pack();

        //System.out.println(Arrays.toString(request));
        HSMConnection hsmConnection = new HSMConnection();
        byte[] recvd = hsmConnection.send_recv(request);
        //System.out.println(Arrays.toString(recvd));

        generateDPK.unpack(recvd);
        System.out.println(generateDPK);
    }
}
