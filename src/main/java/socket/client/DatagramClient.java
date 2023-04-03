package socket.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class DatagramClient {

    public static DatagramSocket clientSocket;

    public static DatagramPacket receivedPacket;

    public static BufferedReader reader;

    public static InetAddress ip;

    public static byte[] data = new byte[1024];

    public static int serverPort = 2222;

    public static int clientPort = 3333;

    public static void main(String[] args) {

        try {

            clientSocket = new DatagramSocket(clientPort);

            receivedPacket = new DatagramPacket(data, data.length);

            reader = new BufferedReader(new InputStreamReader(System.in));

            ip = InetAddress.getLocalHost();

            System.out.println("\nClient Initiated...\n");

            String clientInput = "";

            while (true) {

                System.out.print("\nEnter Msg : ");

                clientInput = reader.readLine();

                data = clientInput.getBytes();

                if (clientInput.equals("stop")) {

                    clientSocket.send(new DatagramPacket(data, data.length, ip, serverPort));

                    System.out.println("\nTerminated!!!\n");

                    break;

                }

                clientSocket.send(new DatagramPacket(data, data.length, ip, serverPort));

                clientSocket.receive(receivedPacket);

                String serverMsg = new String(receivedPacket.getData(), 0, receivedPacket.getLength());

                System.out.println("Server : " + serverMsg);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
