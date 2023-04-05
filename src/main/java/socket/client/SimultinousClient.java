package socket.client;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class SimultinousClient
{

    public static Socket clientSocket;

    public static DataOutputStream outputStream;

    public static DataInputStream inputStream;

    public static BufferedReader reader;

    public static int port = 2222;

    public static void main(String[] args)
    {

        try
        {
            clientSocket = new Socket("10.20.40.229", 9999);

            System.out.println("\nConnected!\n");

            outputStream = new DataOutputStream(clientSocket.getOutputStream());

            inputStream = new DataInputStream(clientSocket.getInputStream());

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

                            System.out.print("\n->");

                            clientMsg = reader.readLine();

                            outputStream.writeUTF(clientMsg);

                            if (clientMsg.equals("stop"))
                            {

                                System.out.println("Terminated!!");
                                break;

                            }

                            outputStream.flush();

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

                serverMsg = inputStream.readUTF();

                if (serverMsg.equals("stop"))
                {

                    System.out.println("\nTerminated!!!\n");

                    break;

                }

                System.out.println("Server : " + serverMsg);

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
                inputStream.close();

                outputStream.close();

                reader.close();

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }


    }

}
