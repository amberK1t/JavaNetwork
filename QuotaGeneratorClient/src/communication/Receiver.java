package communication;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Receiver implements Closeable {
    private BufferedReader in = null;

    public Receiver(Socket socket) throws IOException {
        in = new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream()
                )
        );
    }

    @Override
    public void close() throws IOException {
        if (in != null) {
            in.close();
            in = null;
        }
    }

    public String receiveMsg() throws IOException {
        String msg = "";
        if (in != null) {
            msg = in.readLine();
        }
        else
            throw new IOException("in is null");
        return msg;
    }
}
