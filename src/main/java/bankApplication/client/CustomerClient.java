package bankApplication.client;

import java.io.*;
import java.net.Socket;


public class CustomerClient
{

    public static Socket clientSocket;

    public static PrintWriter outputStream;

    public static BufferedReader inputStream;

    public static BufferedReader reader;

    public static int port = 9999;

    public static void main(String[] args)
    {

        try
        {
            clientSocket = new Socket("localhost", port);

            //            System.out.println("\nConnected!\n");

            outputStream = new PrintWriter(clientSocket.getOutputStream());

            inputStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            reader = new BufferedReader(new InputStreamReader(System.in));


            new Thread(() -> {

                while (true)
                {

                    String serverMsg = null;

                    try
                    {
                        serverMsg = inputStream.readLine();

                        System.out.println(serverMsg);

                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }


                }


            }).start();


            //            System.out.println(reader.readLine());
            while (true)
            {

                try
                {

                    String clientMsg = reader.readLine();

                    outputStream.println(clientMsg);

                    outputStream.flush();

                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }

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


