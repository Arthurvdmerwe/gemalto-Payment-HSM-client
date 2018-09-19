package com.avantir.gemalto.hsm.client;


import com.avantir.gemalto.hsm.client.connection.HSMConnection;
import com.avantir.gemalto.hsm.client.messages.GenerateDPK;
import com.avantir.gemalto.hsm.client.messages.GenerateMPK;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by lekanomotayo on 20/04/2018.
 */
public class GenerateDPKTest {


    @Test
    public void testGenerateDPK() throws Exception{

        GenerateDPK generateDPK = new GenerateDPK("0001");
        byte[] request = generateDPK.pack();

        System.out.println(Arrays.toString(request));
        HSMConnection hsmConnection = new HSMConnection();
        byte[] recvd = hsmConnection.send_recv(request);
        System.out.println(Arrays.toString(recvd));

        generateDPK.unpack(recvd);
        System.out.println(generateDPK);
    }
}
