package CoreJava.ProcessBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProcessBuilderExample {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("fping");
        list.add("google.com");

        ProcessBuilder pb = new ProcessBuilder(list);

        //   System.out.println("Command : " + pb.command());

        List<String> commands = new ArrayList<>();
        commands.add("/bin/sh");
        commands.add("-c");
        commands.add("pwd ; vmstat ; ls -l");
        //  commands.add("vmstat ;");


        ProcessBuilder processBuilder = new ProcessBuilder(commands);

        System.out.println(processBuilder.command());

//        processBuilder.redirectErrorStream(true);

        processBuilder.directory(new File("/home/deven/"));

        try {
//            processBuilder.start();/

            BufferedReader reader = new BufferedReader(new InputStreamReader(processBuilder.start().getInputStream()));

            String line = null;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            //  System.out.println("\n\ndirectory : " + processBuilder.directory());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
