package org.top.chat;

import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

// Client - класс, содержащий алгоритм работы клиента
public class Client {
    public static void runClient(String serverIpAddressStr, int serverPort, Scanner scanner) {
        Socket client = null;
        Sender sender = null;
        Receiver receiver = null;

        try {
            client = new Socket(InetAddress.getByName(serverIpAddressStr), serverPort);
            String user = client.getInetAddress() + ":" + client.getPort() + "(user)> ";
            String serv = serverIpAddressStr + ":" + serverPort + "(server)>";

            sender = new Sender(client);
            receiver = new Receiver(client);

            while (true) {
                System.out.println(user + "введите сообщение: ");
                String msg = scanner.nextLine();
                sender.send(msg);
                if (msg.equals("exit")) {
                    System.out.println(user + "завершение работы");
                    break;
                }

                msg = receiver.receive();
                System.out.println(serv + msg);
                if (msg.equals("exit")) {
                    System.out.println(user + "завершение работы");
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println("клиент: что-то пошло не так - " + e.getMessage());
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
                System.out.println("клиент: что-то пошло не так в finally - " + e.getMessage());
            }
        }
    }
}
