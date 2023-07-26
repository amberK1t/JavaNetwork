public class Main {
    public static void main(String[] args) {
        Thread serverThread = new Thread(() ->Server.runServer("127.0.0.1", 1024));
        Thread clientThread = new Thread(() ->Client.runClient("127.0.0.1", 1024));
        serverThread.start();
        clientThread.start();
        try {
            serverThread.join();
            clientThread.join();
            System.out.println("[Завершение программмы]");
        } catch (Exception ex) {
            System.out.println("Ошибка в main");
        }
    }
}