package socket.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


class ServerThread extends Thread
{

    Socket socket;

    public DataOutputStream outputStream;

    public DataInputStream inputStream;

    public BufferedReader reader;

    ServerThread(Socket socket)
    {

        this.socket = socket;
    }

    @Override
    public void run()
    {

        try
        {
            inputStream = new DataInputStream(socket.getInputStream());

            outputStream = new DataOutputStream(socket.getOutputStream());

            reader = new BufferedReader(new InputStreamReader(System.in));

            String recievedMsg = "";

            String sendMsg = "";

            while (true)
            {

                recievedMsg = inputStream.readUTF();

                if (recievedMsg.equals("stop"))
                {
                    System.out.println("\nTerminated!!\n");
                    break;
                }

                System.out.println("Client : " + socket.getInetAddress() + " " + recievedMsg);

                System.out.print("\n->");

                sendMsg = reader.readLine();

                outputStream.writeUTF(sendMsg);

                outputStream.flush();

            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {

            try
            {
                outputStream.close();

                inputStream.close();

                reader.close();

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }


    }

}

public class ServerWithMultiClient
{

    public static ServerSocket serverSocket;

    public static Socket socket;

    public static int port = 8989;

    public static void main(String[] args)
    {

        try
        {

            serverSocket = new ServerSocket(port);

            while (true)
            {

                socket = serverSocket.accept();

                System.out.println("Connected with : " + socket.getInetAddress());

                ServerThread serverThread = new ServerThread(socket);

                serverThread.start();

            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }

}
