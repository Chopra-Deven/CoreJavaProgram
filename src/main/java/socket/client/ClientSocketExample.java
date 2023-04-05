package socket.client;

import java.io.*;
import java.net.Socket;


public class ClientSocketExample
{

    public static void main(String[] args)
    {

        Socket clientSocket = null;

        DataInputStream inputStream = null;

        DataOutputStream outputStream = null;

        BufferedReader bufferedReader = null;

        try
        {

            clientSocket = new Socket("localhost", 9999);

            inputStream = new DataInputStream(clientSocket.getInputStream());

            outputStream = new DataOutputStream(clientSocket.getOutputStream());

            bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String recievedMsg = "";

            String sendMsg = "";

            //            System.out.println("\nServer Started...\n");

            while (!sendMsg.equals("stop"))
            {

                System.out.print("\n->");

                sendMsg = bufferedReader.readLine();

                outputStream.writeUTF(sendMsg);

                recievedMsg = inputStream.readUTF();

                System.out.println("From Server :  " + recievedMsg);

            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

}
