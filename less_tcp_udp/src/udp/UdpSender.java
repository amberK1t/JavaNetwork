package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

// класс, содержащий отправку сообщение по udp
public class UdpSender {

    // метод демонстрации отправки сообщения через udp-сокет
    // принимает ip-адрес слушателя и его порт
    public static void runSender(String receiverIpStr, int receiverPort) {
        DatagramSocket sender = null;   // udp-сокет для отправки данных
        try {
            // 1. создать сокет для отправки сообщения
            sender = new DatagramSocket();
            System.out.println("отправитель: создан udp-сокет");

            // 2. подготовить сообщение
            String msg = "привет мир!";
            byte[] data = msg.getBytes();

            // 3. подготовить и отправить дейтаграмму
            InetAddress receiverIp = InetAddress.getByName(receiverIpStr);
            DatagramPacket dp = new DatagramPacket(data, data.length, receiverIp, receiverPort);
            sender.send(dp);
            System.out.println("отправитель: отправлено сообщение '" + msg + "'");
        } catch (Exception e) {
            System.out.println("отправитель: что-то пошла не так - " + e.getMessage());
        } finally {
            if (sender != null && !sender.isClosed()) {
                sender.close();
            }
        }
    }
}
