package bankApplication.database;

import bankApplication.bean.CustomerBean;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class CustomerDetails
{

    private static final HashMap<Integer, CustomerBean> allCustomers = new HashMap<>();

    public CustomerBean getCustomerById(int cId)
    {

        System.out.println("\nItereting list\n\n");

        for (Map.Entry<Integer, CustomerBean> map : allCustomers.entrySet())
        {
            System.out.println(map.getKey() + " : " + map.getValue().getPassword());
        }

        return allCustomers.get(cId);

    }
    

    public void addCustomer(int cId, CustomerBean bean)
    {

        allCustomers.put(cId, bean);
        System.out.println("Account created");

    }


}
