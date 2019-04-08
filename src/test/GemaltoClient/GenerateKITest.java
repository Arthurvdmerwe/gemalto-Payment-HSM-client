

import org.junit.Test;

/**
 * Created by lekanomotayo on 20/04/2018.
 */
public class GenerateKITest {





    @Test
    public void testGenerateKI() throws Exception{
        System.out.println("--Generate Issuer Key Test--");
        GenerateKI generateKI = new GenerateKI("0001");
        byte[] request = generateKI.pack();

        //System.out.println(Arrays.toString(request));
        HSMConnection hsmConnection = new HSMConnection();
        byte[] recvd = hsmConnection.send_recv(request);
        //System.out.println(Arrays.toString(recvd));

        generateKI.unpack(recvd);
        System.out.println(generateKI);


    }
}
