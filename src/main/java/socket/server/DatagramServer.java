package socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class DatagramServer {

    public static DatagramSocket serverSocket;

    public static DatagramPacket receivedPacket;

    public static BufferedReader reader;

    public static InetAddress ip;

    public static byte[] data = new byte[1024];

    public static int serverPort = 2222;

    public static int clientPort = 3333;

    public static void main(String[] args) {

        try {

            serverSocket = new DatagramSocket(serverPort);

            receivedPacket = new DatagramPacket(data, data.length);

            reader = new BufferedReader(new InputStreamReader(System.in));

            ip = InetAddress.getLocalHost();

            System.out.println("\nServer Started...\n");

            while (true) {

                serverSocket.receive(receivedPacket);

                String receivedData = new String(receivedPacket.getData(), 0, receivedPacket.getLength());

                System.out.println("Client : " + receivedData);

                if (receivedData.equals("stop")) {
                    System.out.println("\nTerminated!!!\n");
                    break;
                }

                System.out.print("\nEnter msg : ");

                String serverInput = new String(reader.readLine());

                byte buffer[] = serverInput.getBytes();

                serverSocket.send(new DatagramPacket(buffer, serverInput.length(), ip, clientPort));

            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {

                reader.close();

                serverSocket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

}
