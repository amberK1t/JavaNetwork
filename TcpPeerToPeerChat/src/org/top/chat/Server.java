package org.top.chat;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// Server - класс, содержащий процедуру алгоритма работы сервера
public class Server {

    public static void runServer(String serverIpAddrStr, int serverPort, Scanner scanner) {
        ServerSocket server = null;     // сам сокет сервера
        Socket remoteClient = null;     // сокет для работы с клиентом
        Sender sender = null;           // объект для отправки данных через сокет
        Receiver receiver = null;       // объект для чтения данных через сокет
        try {
            String me = serverIpAddrStr + ":" + serverPort + "(me)> ";   // префикс
            // 1. создать сервер
            server = new ServerSocket(serverPort, 1, InetAddress.getByName(serverIpAddrStr));
            System.out.println(me + "сервер создан " + serverIpAddrStr + ":" + serverPort);

            // 2. ожидать подключение
            System.out.println(me + "ожидание входящего подключения ...");
            remoteClient = server.accept(); // подключение
            String remote = remoteClient.getInetAddress().toString() + ":" + remoteClient.getPort() + "> ";
            System.out.println(remote + "вошел в чат");

            // 3. создать объекты для общения
            sender = new Sender(remoteClient);
            receiver = new Receiver(remoteClient);

            // 4. алгоритм работы с клиентом
            while (true) {
                // 4.1) принять сообщение
                String msg = receiver.receive();    // считать сообщение
                System.out.println(remote + msg);   // красиво вывести сообщение
                // TODO: сделать "exit" именованной константой
                if (msg.equals("exit")) {
                    System.out.println(me + "завершение работы");
                    break;
                }
                // 4.2) отправить ответ
                System.out.print(me + "введите сообщение: ");
                msg = scanner.nextLine();
                sender.send(msg);   // отправить сообщение
                if (msg.equals("exit")) {
                    System.out.println(me + "завершение работы");
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println("сервер> что-то пошло не так: " + e.getMessage());
        } finally {
            try {
                if (server != null && !server.isClosed()) {
                    server.close();
                }
                if (remoteClient != null && !remoteClient.isClosed()) {
                    remoteClient.close();
                }
                if (sender != null) {
                    sender.close();
                }
                if (receiver != null) {
                    receiver.close();
                }
            }
            catch (Exception ex) {
                System.out.println("сервер> что-то пошло не так в finally: " + ex.getMessage());
            }
        }
    }
}
