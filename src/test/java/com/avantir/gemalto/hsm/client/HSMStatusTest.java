package com.avantir.gemalto.hsm.client;


import com.avantir.gemalto.hsm.client.connection.HSMConnection;
import com.avantir.gemalto.hsm.client.messages.GenerateRandomKey;
import com.avantir.gemalto.hsm.client.messages.HSMStatus;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by lekanomotayo on 20/04/2018.
 */
public class HSMStatusTest {

    @Test
    public void testHSMStatus() throws Exception{

        HSMStatus hsmStatus = new HSMStatus("0001");
        byte[] request = hsmStatus.pack();

        System.out.println(Arrays.toString(request));
        HSMConnection hsmConnection = new HSMConnection("34.241.226.196", 6060);
        byte[] recvd = hsmConnection.send_recv(request);
        System.out.println(Arrays.toString(recvd));

        hsmStatus.unpack(recvd);
        System.out.println(hsmStatus);
    }
}
