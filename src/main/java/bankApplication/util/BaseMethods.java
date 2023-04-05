package bankApplication.util;

import java.util.HashSet;
import java.util.Random;


public class BaseMethods
{

    public static HashSet<Integer> CUSTOMERIDS = new HashSet<>();

    public int getCustomerId()
    {

        int newId = new Random().nextInt(8999) + 1000;

        while (true)
        {

            if (CUSTOMERIDS.add(newId))
            {
                break;
            }
            else
            {
                newId = new Random().nextInt(8999) + 1000;
            }

        }

        return newId;
    }

    public long getAccountNumber()
    {

        return new Random().nextInt(899999999) + 1000000000;
    }
    
}
