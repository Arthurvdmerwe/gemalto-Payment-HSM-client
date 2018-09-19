package com.avantir.gemalto.hsm.client;


import com.avantir.gemalto.hsm.client.connection.HSMConnection;
import com.avantir.gemalto.hsm.client.messages.GenerateKTM;
import com.avantir.gemalto.hsm.client.messages.GenerateRandomKey;
import com.avantir.gemalto.hsm.client.messages.KeyType;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by lekanomotayo on 20/04/2018.
 */
public class GenerateRandomKeyTest {

    @Test
    public void testGenerateRandomKey() throws Exception{

        GenerateRandomKey generateRandomKey = new GenerateRandomKey("0002", KeyType.KTM);
        byte[] request = generateRandomKey.pack();

        System.out.println(Arrays.toString(request));
        HSMConnection hsmConnection = new HSMConnection();
        byte[] recvd = hsmConnection.send_recv(request);
        System.out.println(Arrays.toString(recvd));

        generateRandomKey.unpack(recvd);
        System.out.println(generateRandomKey);
    }
}
