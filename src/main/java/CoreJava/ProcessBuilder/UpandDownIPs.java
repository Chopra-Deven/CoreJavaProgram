package CoreJava.ProcessBuilder;

import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class UpandDownIPs {

    public static List<String> readIP() {

        final String fileOfIPs = "/home/deven/tempFiles/IPs.txt";

        BufferedReader fileReader = null;

        List<String> listOfIps = null;

        try {

            fileReader = new BufferedReader(new FileReader(fileOfIPs));

            String ip = "";

            listOfIps = new ArrayList<>();

            while ((ip = fileReader.readLine()) != null) {

                listOfIps.add(ip);

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

        return listOfIps;
    }

    public static Map<String, String> ping(List<String> listOfIps) {

        int numberOfPings = 3;

//        ProcessBuilder builder = new ProcessBuilder("/bin/sh", "-c", command);

        List<String> list = new ArrayList<>();

        list.add("fping");

        list.add("-c");

        list.add(String.valueOf(numberOfPings));

        list.add("-q");

        list.addAll(listOfIps);

        ProcessBuilder builder = new ProcessBuilder(list);

//        System.out.println("Command : " + builder.command());

        BufferedReader processReader = null;

        Map<String, String> mapOfStatus = null;

        try {

            Process process = builder.start();

            int exitCode = process.waitFor();

            InputStream inputStream = null;

            if (exitCode == 0)

                inputStream = process.getInputStream();

            else

                inputStream = process.getErrorStream();


            processReader = new BufferedReader(new InputStreamReader(inputStream));

            String output;

            mapOfStatus = new TreeMap<>();

            while ((output = processReader.readLine()) != null) {

                mapOfStatus.put(output.split(" ", 2)[0], getStatus(output));

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                processReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return mapOfStatus;
    }


    public static String getStatus(String output) {

        String status = "";

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

        Instant start_time = Instant.now();

        List<String> listOfIps = readIP();

        Map<String, String> map = ping(listOfIps);

        for (Map.Entry<String, String> entry : map.entrySet()) {

            System.out.println(entry.getKey() + " is " + entry.getValue());

        }

        Instant stop_time = Instant.now();

        System.out.println("\n\nTime Taken : " + Duration.between(start_time, stop_time).toMillis());

    }

}
