import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice, port;
        String ipServer;
        boolean isEnd = false;

        while (!isEnd) {
            System.out.println("Client QuotaGen");
            System.out.println(
                    "1. Join to server\n" +
                    "2. Exit"
            );
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("enter server address: ");
                    ipServer = in.next();
                    System.out.print("enter server port: ");
                    port = Integer.parseInt(in.next());
                    Client.runClient(ipServer, port, in);
                    break;
                case 2:
                    System.out.println("bb");
                    isEnd = true;
                    break;
                default:
                    System.out.println("incorrect input");
            }

        }

    }
}