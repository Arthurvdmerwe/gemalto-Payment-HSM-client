package com.avantir.gemalto.hsm.client;


import com.avantir.gemalto.hsm.client.connection.HSMConnection;
import com.avantir.gemalto.hsm.client.messages.GenerateKI;
import com.avantir.gemalto.hsm.client.messages.GenerateKTM;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by lekanomotayo on 20/04/2018.
 */
public class GenerateKITest {





    @Test
    public void testGenerateKI() throws Exception{

        GenerateKI generateKI = new GenerateKI("0001");
        byte[] request = generateKI.pack();

        System.out.println(Arrays.toString(request));
        HSMConnection hsmConnection = new HSMConnection("34.241.226.196", 6060);
        byte[] recvd = hsmConnection.send_recv(request);
        System.out.println(Arrays.toString(recvd));

        generateKI.unpack(recvd);
        System.out.println(generateKI);


    }
}
