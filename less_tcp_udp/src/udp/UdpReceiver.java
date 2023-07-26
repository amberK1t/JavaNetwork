package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

// класс для получения сообщения по udp
public class UdpReceiver {

    // метод демонстрации получения сообщения через udp-сокет
    // принимает ip-адрес слушателя и его порт
    public static void runReceiver(String receiverIpStr, int port) {
        DatagramSocket receiver = null; // объект udp-сокета
        try {
            // 1. создать udp-сокет
            receiver = new DatagramSocket(port, InetAddress.getByName(receiverIpStr));
            System.out.println("получатель: создан udp-сокет");

            // 2. подготовить буфер и дейтаграмму, в которую будет записано полученное сообщение
            byte[] buffer = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buffer, buffer.length);

            // 3. получить сообщение
            receiver.receive(dp);   // ожидание сообщения
            String msg = new String(dp.getData(), 0, dp.getLength());
            System.out.println("получатель: получено сообщение от " + dp.getAddress() + ":" + dp.getPort());
            System.out.println("получатель: '" + msg + "'");
        } catch (Exception e) {
            System.out.println("получатель: что-то пошла не так - " + e.getMessage());
        } finally {
            if (receiver != null && !receiver.isClosed()) {
                receiver.close();
            }
        }
    }
}
