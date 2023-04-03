package socket;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLClassDemo {

    public static void main(String[] args) {

        try {

            URL url = new URL("https://www.javatpoint.com/java-dataoutputstream-class");

            URLConnection urlConnection = url.openConnection();

//            urlConnection.get

            /*BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line = "";

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }*/

            InputStream stream = urlConnection.getInputStream();
            int i;
            while ((i = stream.read()) != -1) {
                System.out.print((char) i);

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
