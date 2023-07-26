import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void runServer(String ipAddress, int port) {
        ServerSocket server = null;
        Socket client = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            server = new ServerSocket(port, 1, InetAddress.getByName(ipAddress));
            System.out.println("[сервер: сервер создан]");
            System.out.println("[сервер: ожидание входящего подключения]");
            client = server.accept();
            System.out.println("[сервер: подключен клиент - " + client.getInetAddress() + ":" + client.getPort() +"]");
            out = new PrintWriter(
                    new OutputStreamWriter(
                            client.getOutputStream()
                    ), true
            );
            String msg = "Привет, Петровна, а Танька со второго подъезда прости*утка";
            out.println(msg);
            System.out.println("[сервер: отправлено сообщение клиенту]");
            in = new BufferedReader(
                    new InputStreamReader(client.getInputStream())
            );
            msg = in.readLine();
            System.out.println("сервер: получено сообщение от клиента - " + msg);

            msg = "Ой, да я знаю. Тебе пенсия пришла?";
            out.println(msg);
            System.out.println("[сервер: отправлено сообщение клиенту]");

            msg = in.readLine();
            System.out.println("сервер: получено сообщение от клиента - " + msg);

            msg = "Нет. Бб";
            out.println(msg);
            System.out.println("[сервер: отправлено сообщение клиенту]");

            msg = in.readLine();
            System.out.println("сервер: получено сообщение от клиента - " + msg);

            System.out.println("[сервер: завершение работы]");

        } catch (Exception ex) {
            System.out.println("[сервер: что-то пошло не так - " + ex.getMessage() + "]");
        } finally {
            try {
                if (server != null && !server.isClosed()) {
                    server.close();
                }
                if (client != null && !client.isClosed()) {
                    client.close();
                }
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (Exception ex) {
                System.out.println("[сервер: что-то пошло не так в finally]");
            }

        }

    }
}
