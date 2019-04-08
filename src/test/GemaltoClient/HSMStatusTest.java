
import org.junit.Test;

/**
 * Created by lekanomotayo on 20/04/2018.
 */
public class HSMStatusTest {

    @Test
    public void testHSMStatus() throws Exception{
        System.out.println("--HSM Status Test--");
        HSMStatus hsmStatus = new HSMStatus("0001");
        byte[] request = hsmStatus.pack();

        //System.out.println(Arrays.toString(request));
        HSMConnection hsmConnection = new HSMConnection();
        byte[] recvd = hsmConnection.send_recv(request);
        //System.out.println(Arrays.toString(recvd));

        hsmStatus.unpack(recvd);
        System.out.println(hsmStatus);
    }
}
