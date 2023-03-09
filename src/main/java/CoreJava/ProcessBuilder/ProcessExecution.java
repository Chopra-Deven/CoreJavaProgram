package CoreJava.ProcessBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProcessExecution
{

    public static void main(String[] args)
    {

        List<String> listOfCommands = new ArrayList<>();

        listOfCommands.add("/bin/sh");

        listOfCommands.add("-c");

        listOfCommands.add("vmstat ; pidstat ; mpstat");

        ProcessBuilder builder = new ProcessBuilder(listOfCommands);

        BufferedReader reader = null;

        BufferedWriter writer = null;

        try
        {

            reader = new BufferedReader(new InputStreamReader(builder.start().getInputStream()));

            writer = new BufferedWriter(new FileWriter("/home/deven/tempFiles/CommandOutput1.txt"));

            String output;

            while((output = reader.readLine()) != null)
            {
                System.out.println(output);

                writer.write(output);

                writer.write("\n");

            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                reader.close();

                writer.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

    }

}
