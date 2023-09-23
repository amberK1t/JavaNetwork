import communication.Receiver;
import communication.Sender;

import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void runClient(String ipServer, int port, Scanner scanner) {
        Socket client = null;
        Sender sender = null;
        Receiver receiver = null;
        boolean isBack = false;
        int choice;

        try {
            client = new Socket(InetAddress.getByName(ipServer), port);
            System.out.println("client connected");
            sender = new Sender(client);
            receiver = new Receiver(client);
            System.out.println("chat ready");

            while (!isBack) {
                System.out.println(
                        "1. Get quota\n" +
                        "2. Back");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        sender.sendMsg("quota");
                        System.out.println(receiver.receiveMsg());
                        break;
                    case 2:
                        sender.sendMsg("exit");
                        isBack = true;
                        break;
                    default:
                        System.out.println("incorrect input");
                }
            }

        } catch (Exception e) {
            System.out.println("client exception - " + e.getMessage());
        } finally {
            try {
                if (client != null && !client.isClosed()) {
                    client.close();
                }

                if (sender != null) {
                    sender.close();
                }

                if (receiver != null) {
                    receiver.close();
                }

            } catch (Exception e) {
                System.out.println("finally exception - " + e.getMessage());
            }
        }
    }
}
