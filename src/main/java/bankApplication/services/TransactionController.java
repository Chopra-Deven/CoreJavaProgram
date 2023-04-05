package bankApplication.services;

import bankApplication.bean.CustomerBean;
import bankApplication.database.CustomerDetails;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;


public class TransactionController
{

    public void mainMenu(PrintWriter outputStream, BufferedReader inputStream, int cId)
    {

        CustomerBean customerBean = new CustomerDetails().getCustomerById(cId);

        CustomerDetails customerDetails = new CustomerDetails();

        boolean shouldBreak = true;

        while (shouldBreak)
        {
            outputStream.println("\n############### Transaction ###############\n");


            outputStream.println("1 - Deposit");

            outputStream.println("2 - Withdraw");

            outputStream.println("3 - Check Balance");

            outputStream.println("4 - Exit");

            outputStream.println("\nEnter your choice : ");

            outputStream.flush();

            try
            {

                int choice = Integer.parseInt(inputStream.readLine().trim());

                switch (choice)
                {

                    case 1:

                        outputStream.println("Enter amount to Deposit : ");

                        outputStream.flush();

                        double depositAmount = Double.parseDouble(inputStream.readLine().trim());

                        System.out.println("Deposit : " + depositAmount);

                        double updatedBalance = customerBean.getBalance() + depositAmount;

                        customerBean.setBalance(updatedBalance);

                        customerDetails.addCustomer(cId, customerBean);

                        outputStream.println("\nDeposit Successfull\nUpdated Balance is : " + updatedBalance);

                        outputStream.flush();

                        break;

                    case 2:

                        outputStream.println("Enter amount to Withdraw : ");

                        outputStream.flush();

                        double withdrawAmount = Double.parseDouble(inputStream.readLine().trim());

                        System.out.println("Withdraw : " + withdrawAmount);

                        if (customerBean.getBalance() > withdrawAmount)
                        {
                            double newBalance = customerBean.getBalance() - withdrawAmount;

                            customerBean.setBalance(newBalance);

                            customerDetails.addCustomer(cId, customerBean);

                            outputStream.println("\nWithdraw Successfull\nUpdated Balance is : " + newBalance);

                            outputStream.flush();
                        }
                        else
                            outputStream.println("\nNot enough Balance");

                        break;

                    case 3:

                        outputStream.println("\nYour current Balance is : " + customerBean.getBalance() + "\n");

                        outputStream.flush();

                        break;

                    case 4:

                        shouldBreak = false;

                        break;

                    default:

                        outputStream.println("Invalid choice");

                        outputStream.flush();

                }   // end of switch

            }   // end of try catch
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }// end of while

    }

}
