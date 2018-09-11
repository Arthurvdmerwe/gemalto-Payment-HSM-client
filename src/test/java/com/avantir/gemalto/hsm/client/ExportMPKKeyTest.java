package com.avantir.gemalto.hsm.client;


import com.avantir.gemalto.hsm.client.connection.HSMConnection;
import com.avantir.gemalto.hsm.client.messages.ExportKTMKey;
import com.avantir.gemalto.hsm.client.messages.ExportMPKKey;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by lekanomotayo on 20/04/2018.
 */
public class ExportMPKKeyTest {



    @Test
    public void testExportKeyUnderHostKey() throws Exception{

        // Key types
        // 00 - DPK, 01 - PPK, 02 - MPK, 05 - KTM, 10 - KI

        ExportMPKKey exportKey = new ExportMPKKey("0001", "8E4EF08465D83628DD807F5F88B2F181", "F1FD7C7581E7F5AEBE1997A47F047568");
        byte[] request = exportKey.pack();

        System.out.println(Arrays.toString(request));
        HSMConnection hsmConnection = new HSMConnection("34.241.226.196", 6060);
        byte[] recvd = hsmConnection.send_recv(request);
        System.out.println(Arrays.toString(recvd));

        exportKey.unpack(recvd);
        System.out.println(exportKey);
    }

}
