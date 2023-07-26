import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void runClient(String serverIpAddress, int serverPort) {
        Socket client = null;
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            client = new Socket(serverIpAddress, serverPort);
            System.out.println("[клиент: клиент подключен к серверу]");
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String msg = in.readLine();
            System.out.println("получено собщение от сервера - " + msg);
            out = new PrintWriter(
                    new OutputStreamWriter(
                            client.getOutputStream()
                    ), true
            );
            msg = "Ого, а Серёга с пятого, наркоман!";
            out.println(msg);
            System.out.println("[клиент: отправлено сообщение серверу]");

            msg = in.readLine();
            System.out.println("клиент: получено сообщение от сервера - " + msg);

            msg = "Ага, вот барбариски купила. Будешь?";
            out.println(msg);
            System.out.println("[клиент: отправлено сообщение серверу]");

            msg = in.readLine();
            System.out.println("клиент: получено сообщение от сервера - " + msg);

            msg = "Бб";
            out.println(msg);
            System.out.println("[клиент: отправлено сообщение серверу]");

            System.out.println("[клиент: завершение работы]");
        } catch (Exception ex) {
            System.out.println("[клиент: что-то пошло не так - " +ex.getMessage() +"]");
        } finally {
            try {
                if (client != null && !client.isClosed()) {
                    client.close();
                }
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }

            } catch (Exception ex) {
                System.out.println("[клиент: что-то пошло не так в finally]");
            }
        }


    }
}
