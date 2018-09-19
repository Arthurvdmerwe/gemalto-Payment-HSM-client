package com.avantir.gemalto.hsm.client;


import com.avantir.gemalto.hsm.client.connection.HSMConnection;
import com.avantir.gemalto.hsm.client.messages.GenerateKTM;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by lekanomotayo on 20/04/2018.
 */
public class GenerateKTMTest {





    @Test
    public void testGenerateTMK() throws Exception{

        GenerateKTM generateTMK = new GenerateKTM("0001");
        byte[] request = generateTMK.pack();

        System.out.println(Arrays.toString(request));
        HSMConnection hsmConnection = new HSMConnection();
        byte[] recvd = hsmConnection.send_recv(request);
        System.out.println(Arrays.toString(recvd));

        generateTMK.unpack(recvd);
        System.out.println(generateTMK);


    }
}
