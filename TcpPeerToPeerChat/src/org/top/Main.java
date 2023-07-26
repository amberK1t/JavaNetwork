package org.top;

import org.top.chat.Client;
import org.top.chat.Server;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ipStr;
        int port;

        // галвный цикл
        boolean isEnd = false;
        while (!isEnd) {
            System.out.println("1. Ожидать подключение");
            System.out.println("2. Подключиться");
            System.out.println("3. Выход");
            System.out.print("Введите выбор: ");
            String choice = scanner.nextLine();
            //
            switch (choice) {
                case "1":
                    System.out.print("Введите ip-адрес своего сервера: ");
                    ipStr = scanner.nextLine();
                    System.out.print("Введите порт: ");
                    port = Integer.parseInt(scanner.nextLine());
                    Server.runServer(ipStr, port, scanner);
                    break;
                case "2":
                    System.out.print("Введите ip-адрес сервера для подключения: ");
                    ipStr = scanner.nextLine();
                    System.out.print("Введите порт сервера: ");
                    port = Integer.parseInt(scanner.nextLine());
                    Client.runClient(ipStr, port, scanner);
                    break;
                case "3":
                    System.out.println("До свидания");
                    isEnd = true;
                    break;
                default:
                    System.out.println("Некорректный ввод. Повторите еще раз");
            }
        }
    }
}
