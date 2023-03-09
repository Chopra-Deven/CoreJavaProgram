package CoreJava.ProcessBuilder;

import java.io.*;
import java.util.List;

public class ListOfIPs {

    public static void main(String[] args) {

        String startIP = "10.20.40.";

        final String file = "/home/deven/tempFiles/IPs.txt";

        BufferedWriter bufferedWriter = null;

        try
        {

            bufferedWriter = new BufferedWriter(new FileWriter(file));

            for(int i=1 ; i<=255 ; i++)
            {

                String ip = startIP + i;

                bufferedWriter.write(ip + "\n");

            }

            System.out.println("Added!");

        }
        catch (IOException e)
        {

            e.printStackTrace();

        }
        finally
        {

            try
            {
                bufferedWriter.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}
