
import org.junit.Test;



public class GenerateKTMTest {





    @Test
    public void testGenerateTMK() throws Exception{
        System.out.println("--Generate Master Terminal Key Test--");
        GenerateKTM generateTMK = new GenerateKTM("0001");
        byte[] request = generateTMK.pack();

        //System.out.println(Arrays.toString(request));
        HSMConnection hsmConnection = new HSMConnection();
        byte[] recvd = hsmConnection.send_recv(request);
        //System.out.println(Arrays.toString(recvd));

        generateTMK.unpack(recvd);
        System.out.println(generateTMK);


    }
}
