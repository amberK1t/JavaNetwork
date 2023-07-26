package org.top;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

public class Main {

    // метод запуска сервера (содержит весь алгоритм работы сервера)
    public static void runServer(String ipAddressStr, int port) {
        ServerSocket server = null; // сокет сервера
        Socket client = null;       // сокет подключенного клиента
        PrintWriter out = null;     // поток вывода (отправка сообщений клиенту)
        BufferedReader in = null;   // поток ввод (получение сообщений от клиента)
        try {
            // 1. создать сокет сервера
            InetAddress ipAddress = InetAddress.getByName(ipAddressStr); // преобразование строки адреса в объект адреса
            server = new ServerSocket(port, 1, ipAddress);
            System.out.println("сервер: успешно создан");
            // 2. ожидаем входящее подключение
            System.out.println("сервер: ожидание входящих подключений ...");
            client = server.accept();    // ожидание подключения клиента
            System.out.println("сервер: подключен клиент - " + client.getInetAddress() + ":" + client.getPort());
            // 3. отправка сообщения подключенному клиенту
            // 3.1) создать поток вывода (используется поток из сокета)
            out = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(client.getOutputStream())
                    ),
                    true
            );
            // 3.2) отправить сообщение через поток
            String msg = "привет от сервера, время подключения: " + LocalDateTime.now();
            out.println(msg);   // отправка сообщения клиенту
            System.out.println("сервер: отправлено сообщение '" + msg + "'");
            // 4. Получить сообщение от клиента
            // 4.1) создать поток чтения из сокета
            in = new BufferedReader(
                    new InputStreamReader(client.getInputStream(), StandardCharsets.UTF_8)
            );
            // 4.2) считать сообщение
            msg = in.readLine();
            System.out.println("сервер: получено сообщение '" + msg + "'");
            // 5. завершить работу
            System.out.println("сервер: завершение работы ...");
        } catch (Exception ex) {
            System.out.println("сервер: что-то пошло не так - " + ex.getMessage());
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
                System.out.println("сервер: что-то пошло не так в finally - " + ex.getMessage());
            }
        }
    }

    // метод запуска клиента (содержит весь алгоритм работы клиента)
    public static void runClient(String serverIpAddressStr, int serverPort) {
        Socket remoteServer = null; // сокет удаленного сервера
        BufferedReader in = null;   // поток ввода (получение сообщений от сервера)
        PrintWriter out = null;     // поток вывода (отправка сообщений серверу)
        try {
            // 1. создать сокет для подключения к серверу и подключится к серверу
            remoteServer = new Socket(serverIpAddressStr, serverPort);
            System.out.println("клиент: создан сокет для подключения к серверу, выполнено подключение");
            // 2. считать сообщение от сервера
            // 2.1) создать поток чтения из сокета
            in = new BufferedReader(
                    new InputStreamReader(remoteServer.getInputStream(), StandardCharsets.UTF_8)
            );
            // 2.2) считать сообщение
            String msg = in.readLine();
            System.out.println("клиент: получено сообщение '" + msg + "'");
            // 3. отправить сообщение серверу
            // 3.1) создать поток вывода (используется поток из сокета)
            out = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(remoteServer.getOutputStream())
                    ),
                    true
            );
            // 3.2) отправить сообщение через поток
            msg = "сообщение получил, но теперь отключаюсь";
            out.println(msg);   // отправка сообщения серверу
            System.out.println("клиент: отправлено сообщение '" + msg + "'");
            // 4.
            System.out.println("клиент: завершение работы ...");
        } catch (Exception ex) {
            System.out.println("клиент: что-то пошло не так - " + ex.getMessage());
        } finally {
            try {
                if (remoteServer != null && !remoteServer.isClosed()) {
                    remoteServer.close();
                }
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (Exception ex) {
                System.out.println("клиент: что-то пошло не так в finally - " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        try {
            String serverIpAddress = "127.0.0.1";
            int serverPort = 1024;
            // запустим процедуры клиента и сервера в разных потоках
            // 1) создать потоки
            Thread serverThread = new Thread(() -> runServer(serverIpAddress, serverPort));
            Thread clientThread = new Thread(() -> runClient(serverIpAddress, serverPort));
            // 2) запустить
            serverThread.start();
            clientThread.start();
            // 3) ожидание завершение потоков
            serverThread.join();
            clientThread.join();
            System.out.println("основной поток: работа завершена");
        } catch (Exception ex) {
            System.out.println("главный поток: что-то пошло не так - " + ex.getMessage());
        }
    }
}
