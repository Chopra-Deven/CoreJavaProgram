package socket.server;

import javax.xml.crypto.Data;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class SimultinousServer
{

    public static ServerSocket serverSocket;

    public static Socket socket;

    public static DataOutputStream outputStream;

    public static DataInputStream inputStream;

    public static BufferedReader reader;

    public static int port = 2222;

    public static void main(String[] args)
    {

        try
        {

            serverSocket = new ServerSocket(port);

            socket = serverSocket.accept();

            System.out.println("\nServer Started ... \n");

            outputStream = new DataOutputStream(socket.getOutputStream());

            inputStream = new DataInputStream(socket.getInputStream());

            reader = new BufferedReader(new InputStreamReader(System.in));


            String serverMsg = "";

            new Thread()
            {

                String clientMsg = "";

                @Override
                public void run()
                {

                    while (true)
                    {

                        try
                        {
                            clientMsg = inputStream.readUTF();

                            if (clientMsg.equals("stop"))
                            {

                                System.out.println("\nTerminated!!\n");

                                break;

                            }

                            System.out.println("Client : " + clientMsg);

                        }
                        catch (IOException e)
                        {
                            e.printStackTrace();
                        }


                    }

                }
            }.start();

            while (true)
            {

                System.out.print("\n->");

                serverMsg = reader.readLine();

                if (serverMsg.equals("stop"))
                {

                    System.out.println("\nTerminated!!!\n");

                    break;

                }

                outputStream.writeUTF(serverMsg);

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
