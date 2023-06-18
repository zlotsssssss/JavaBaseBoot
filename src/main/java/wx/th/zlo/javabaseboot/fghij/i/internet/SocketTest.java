package wx.th.zlo.javabaseboot.fghij.i.internet;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTest {
    @Test
    public void Client() throws IOException {
        Socket socket = null;
        OutputStream os = null;
        try {
            socket = new Socket("127.0.0.1", 8080);
            os = socket.getOutputStream();
            os.write("服务器你好".getBytes());
            os.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(os != null){
                os.close();
            }
            if(socket != null){
                socket.close();
            }
        }
    }
    @Test
    public void Server() throws Exception{
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        ByteArrayOutputStream baos = null;
        try {
            serverSocket = new ServerSocket(8080);
            socket = serverSocket.accept();
            inputStream = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] buf = new byte[5];
            int len;
            while((len = inputStream.read(buf)) != -1){
                baos.write(buf,0,len);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            baos.close();
            inputStream.close();
            socket.close();
            serverSocket.close();
        }

    }

}
