package communication;

import java.io.*;
import java.net.Socket;

public class Sender implements Closeable {
    private PrintWriter out = null;

    public Sender(Socket socket) throws IOException {
        out = new PrintWriter(
                new BufferedWriter(
                        new OutputStreamWriter(
                                socket.getOutputStream()
                        )
                ), true
        );
    }

    @Override
    public void close() throws IOException {
        if (out != null) {
            out.close();
            out = null;
        }
    }

    public void sendMsg(String msg) throws IOException {
        if (out != null) {
            out.println(msg);
        }
        else
            throw new IOException("out is null");

    }
}
