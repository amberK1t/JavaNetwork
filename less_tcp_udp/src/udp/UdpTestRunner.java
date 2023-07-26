package udp;

// класс для запуска получателя и отправителя
public class UdpTestRunner {

    public static void testRun() {
        try {
            String receiverIpStr = "127.0.0.1";
            int port = 1024;

            Thread receiverThread = new Thread(() -> UdpReceiver.runReceiver(receiverIpStr, port));
            Thread senderThread = new Thread(() -> UdpSender.runSender(receiverIpStr, port));
            //
            receiverThread.start();
            senderThread.start();
            //
            receiverThread.join();
            senderThread.join();
        } catch (Exception e) {
            System.out.println("главный поток: что-то пошло не так - " + e.getMessage());
        }
    }
}
