package bankApplication.services;

import bankApplication.bean.CustomerBean;
import bankApplication.database.CustomerDetails;
import bankApplication.util.BaseMethods;

import java.io.*;


public class AuthenticationCustomer
{

    public int login(PrintWriter outputStream, BufferedReader inputStream)
    {

        int cId = 0;

        String password = "";

        try
        {

            outputStream.println("\nPlease Login first to continue\n");

            outputStream.println("Enter Customer Id : ");

            outputStream.flush();

            cId = Integer.parseInt(inputStream.readLine());

            outputStream.println("Enter Password : ");

            outputStream.flush();

            password = inputStream.readLine();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        if (new AuthenticationCustomer().authenticateCustomer(cId, password))
            return cId;
        else
            return -1;

    }

    public boolean authenticateCustomer(int cId, String password)
    {

        CustomerBean bean = new CustomerDetails().getCustomerById(cId);

        System.out.println("inside authenticateCustomer\nentered pwd : " + password + "\nbean pwd : " + bean.getPassword());

        if (bean != null)

            return password.equals(bean.getPassword());

        else

            return false;

    }

    public CustomerBean registerCustomer(PrintWriter outputStream, BufferedReader inputStream)
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CustomerBean bean = null;

        try
        {

            outputStream.println("\n---------- Enter Your Details ----------\n");

            outputStream.println("\nEnter First Name : ");

            outputStream.flush();

            String fName = inputStream.readLine();

            outputStream.println("\nEnter Last Name : ");

            outputStream.flush();

            String lName = inputStream.readLine();

            outputStream.println("\nEnter Email Name : ");

            outputStream.flush();

            String email = inputStream.readLine();

            outputStream.println("\nEnter Contact Number : ");

            outputStream.flush();

            String phone = inputStream.readLine();

            outputStream.println("\nEnter Address : ");

            outputStream.flush();

            String address = inputStream.readLine();


            outputStream.println("\n=============== Your Account has been created Successfully ===============\n");

            outputStream.flush();

            BaseMethods methods = new BaseMethods();

            int cid = methods.getCustomerId();

            long accountNumber = methods.getAccountNumber();

            outputStream.println("Your Customer ID is : " + cid);

            outputStream.println("Your Account Number is : " + accountNumber);

            outputStream.flush();

            outputStream.println("\nCreate Password : ");

            outputStream.flush();

            String password = inputStream.readLine();

            bean = new CustomerBean(fName, lName, email, Long.parseLong(phone), address, password);

            new CustomerDetails().addCustomer(cid, bean);

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return bean;
    }


}
