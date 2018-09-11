package com.avantir.gemalto.hsm.client;


import com.avantir.gemalto.hsm.client.connection.HSMConnection;
import com.avantir.gemalto.hsm.client.messages.Encrypt;
import com.avantir.gemalto.hsm.client.messages.GenerateDPK;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by lekanomotayo on 20/04/2018.
 */
public class EncryptTest {


    @Test
    public void testEncrypt() throws Exception{

        Encrypt encrypt = new Encrypt("0001", "0969B047265CD2D555296CE552878FFA", "11","0000000000000000");
        byte[] request = encrypt.pack();

        System.out.println(Arrays.toString(request));
        HSMConnection hsmConnection = new HSMConnection("34.241.226.196", 6060);
        byte[] recvd = hsmConnection.send_recv(request);
        System.out.println(Arrays.toString(recvd));

        encrypt.unpack(recvd);
        System.out.println(encrypt);
    }
}
