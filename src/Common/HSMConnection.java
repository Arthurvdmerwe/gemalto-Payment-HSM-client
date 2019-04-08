package Common;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by lekanomotayo on 20/04/2018.
 */
public final class HSMConnection {

    final String host;
    final int port;
    final int connectTimeout;
    final int receiveTimeout;


    public HSMConnection(){
        this.host = "10.10.20.15";
        this.port = 5600;
        this.connectTimeout = 1000;
        this.receiveTimeout = 20000;
    }

    public HSMConnection(String host, int port, int connectTimeout){
        this.host = host;
        this.port = port;
        this.connectTimeout = connectTimeout;
        this.receiveTimeout = 20000;
    }

    public HSMConnection(String host, int port, int connectTimeout, int receiveTimeout){
        this.host = host;
        this.port = port;
        this.connectTimeout = connectTimeout;
        this.receiveTimeout = receiveTimeout;
    }

    public byte[] send_recv(byte[] request) throws IOException{
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(host, port), connectTimeout); // connect timeout
        socket.setSoTimeout(receiveTimeout); // read timeout
        OutputStream out = socket.getOutputStream();
        DataInputStream in = new DataInputStream(socket.getInputStream());
        ByteArrayOutputStream raw_data = new ByteArrayOutputStream();
        raw_data.write(request);
        raw_data.writeTo(out);
      //  int recvd_size = out.available();

        byte[] recvd = new byte[1024];
        int recvd_len = in.read(recvd);
        return recvd;
    }
}
