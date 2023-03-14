package CoreJava.ProcessBuilder;

import CoreJava.StaticKeywordExample;

import java.io.*;
import java.time.Duration;
import java.time.Instant;

class ReadIpFromFile {

    public static String readIP() {

        final String fileOfIPs = "/home/deven/tempFiles/IPs.txt";

        BufferedReader fileReader = null;

        String allIPs = "";

        try {

            fileReader = new BufferedReader(new FileReader(fileOfIPs));

            String ip = "";

            while ((ip = fileReader.readLine()) != null) {

                allIPs = allIPs.concat(ip + " ");

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return allIPs;
    }

}

public class UpandDownIPs {

    public static String getStatus(String output) {

        String status = "DOWN";

        try {

            String[] splitedOutput = output.split("\\s+");

            String[] packetInfo = splitedOutput[4].split("/");

            int sentPackets = Integer.parseInt(packetInfo[0]);

            int recievedPackets = Integer.parseInt(packetInfo[1]);

            if (sentPackets == recievedPackets && packetInfo[2].equals("0%,")) {

                status = "UP";

                return status;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;

    }

    public static void main(String[] args) {

        String command = "fping -c 3 -q " + ReadIpFromFile.readIP();

        String command2 = "fping -c 1 -g 10.20.40.1 10.20.40.11";

        ProcessBuilder builder = new ProcessBuilder("/bin/sh", "-c", command);

        System.out.println("Command : " + builder.command());

        BufferedReader processReader = null;

        Instant start_time = Instant.now();

        try {

            Process process = builder.start();

            int exitCode = process.waitFor();

            InputStream inputStream = null;

            if (exitCode == 0) {
                // Command executed successfully
                // You can read the output of the command from the process input stream
//                System.out.println("InputStream Called!!");

                inputStream = process.getInputStream();
                // Process the output as needed
            } else {
                // Command execution failed
                // You can read the error output of the command from the process error stream
//                System.out.println("ErrorStream Called!!");
                inputStream = process.getErrorStream();
                // Process the error output as needed
            }

            processReader = new BufferedReader(new InputStreamReader(inputStream));

            String output;

            while ((output = processReader.readLine()) != null) {

                System.out.println(output.split(" ", 2)[0] + " is " + UpandDownIPs.getStatus(output));

            }

            Instant stop_time = Instant.now();

            System.out.println("\n\nTime Taken : " + Duration.between(start_time, stop_time).toMillis());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                processReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
