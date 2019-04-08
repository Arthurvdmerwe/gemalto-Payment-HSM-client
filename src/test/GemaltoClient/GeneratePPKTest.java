
import org.junit.Test;

/**
 * Created by lekanomotayo on 20/04/2018.
 */
public class GeneratePPKTest {


    @Test
    public void testGeneratePPK() throws Exception{
        System.out.println("--Generate Pin Protection Key Test--");
        GeneratePPK generatePPK = new GeneratePPK("0001");
        byte[] request = generatePPK.pack();

        //System.out.println(Arrays.toString(request));
        HSMConnection hsmConnection = new HSMConnection();
        byte[] recvd = hsmConnection.send_recv(request);
        //System.out.println(Arrays.toString(recvd));

        generatePPK.unpack(recvd);
        System.out.println(generatePPK);
    }
}
