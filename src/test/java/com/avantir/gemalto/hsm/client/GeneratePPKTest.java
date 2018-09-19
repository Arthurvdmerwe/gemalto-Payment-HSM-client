package com.avantir.gemalto.hsm.client;


import com.avantir.gemalto.hsm.client.connection.HSMConnection;
import com.avantir.gemalto.hsm.client.messages.GenerateDPK;
import com.avantir.gemalto.hsm.client.messages.GeneratePPK;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by lekanomotayo on 20/04/2018.
 */
public class GeneratePPKTest {


    @Test
    public void testGeneratePPK() throws Exception{

        GeneratePPK generatePPK = new GeneratePPK("0001");
        byte[] request = generatePPK.pack();

        System.out.println(Arrays.toString(request));
        HSMConnection hsmConnection = new HSMConnection();
        byte[] recvd = hsmConnection.send_recv(request);
        System.out.println(Arrays.toString(recvd));

        generatePPK.unpack(recvd);
        System.out.println(generatePPK);
    }
}
