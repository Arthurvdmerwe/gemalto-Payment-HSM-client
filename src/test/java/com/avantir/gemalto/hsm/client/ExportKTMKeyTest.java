package com.avantir.gemalto.hsm.client;


import com.avantir.gemalto.hsm.client.connection.HSMConnection;
import com.avantir.gemalto.hsm.client.messages.ExportKTMKey;
import com.avantir.gemalto.hsm.client.messages.ExportKey;
import com.avantir.gemalto.hsm.client.messages.KeyType;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by lekanomotayo on 20/04/2018.
 */
public class ExportKTMKeyTest {



    @Test
    public void testExportKeyUnderHostKey() throws Exception{

        // Key types
        // 00 - DPK, 01 - PPK, 02 - MPK, 05 - KTM, 10 - KI

        ExportKTMKey exportKey = new ExportKTMKey("0001", "8E4EF08465D83628DD807F5F88B2F181", "10FEDBB40FBBDE16FF2153F440593709");
        byte[] request = exportKey.pack();

        System.out.println(Arrays.toString(request));
        HSMConnection hsmConnection = new HSMConnection("34.241.226.196", 6060);
        byte[] recvd = hsmConnection.send_recv(request);
        System.out.println(Arrays.toString(recvd));

        exportKey.unpack(recvd);
        System.out.println(exportKey);
    }

}
