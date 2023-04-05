package bankApplication.server;

import bankApplication.bean.CustomerBean;
import bankApplication.services.AuthenticationCustomer;
import bankApplication.services.TransactionController;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class BankServer
{

    private ServerSocket serverSocket;

    Socket client;

    int port;

    static int clientCount;

    BankServer(int port)
    {

        this.port = port;

    }

    public void startServer()
    {

        try
        {
            serverSocket = new ServerSocket(port);

            client = serverSocket.accept();

            BufferedReader inputStream = new BufferedReader(new InputStreamReader(client.getInputStream()));

            PrintWriter outputStream = new PrintWriter(client.getOutputStream());

            outputStream.println("\n----- Welcome to Apni Bank -----\n");

            outputStream.println("\n1 - Already user? Login");

            outputStream.println("\n2 - New User? SignUp");

            outputStream.flush();

            while (true)
            {

                String recievedMsg = inputStream.readLine();

                int choice = Integer.parseInt(recievedMsg.trim());

                System.out.println(recievedMsg);

                if (choice == 1)
                {

                    AuthenticationCustomer customerAuth = new AuthenticationCustomer();

                    int cId = customerAuth.login(outputStream, inputStream);

                    if (cId != -1)
                    {

                        new TransactionController().mainMenu(outputStream, inputStream, cId);

                    }

                }
                else if (choice == 2)
                {

                    AuthenticationCustomer customerAuth = new AuthenticationCustomer();

                    CustomerBean customerBean = customerAuth.registerCustomer(outputStream, inputStream);

                    int cId = customerAuth.login(outputStream, inputStream);

                    if (cId != -1)
                    {

                        new TransactionController().mainMenu(outputStream, inputStream, cId);

                    }

                }
                else
                {
                    outputStream.println("Invalid input!");
                }

                outputStream.flush();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public static void main(String[] args)
    {

        BankServer server = new BankServer(9999);

        server.startServer();

    }

}