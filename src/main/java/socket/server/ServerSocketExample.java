package socket.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketExample {

    public static void main(String[] args) {

        ServerSocket server = null;

        Socket socket = null;

        try {

            server = new ServerSocket(8787);

            System.out.println(server.getInetAddress());

            System.out.println("\nServer Started... \nWaiting fro Client...\n");

            socket = server.accept();

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());

            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String recievedMsg = "";

            String sendMsg = "";


            while (!recievedMsg.equals("stop")) {

                recievedMsg = inputStream.readUTF();

                System.out.println("From Client : " + recievedMsg);

                System.out.print("\n\nEnter your msg : ");

                sendMsg = bufferedReader.readLine();

                outputStream.writeUTF(sendMsg);

                outputStream.flush();

            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                server.close();

                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

}
