package Networking;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class SSHConnect {

    private static final java.util.Properties config = new java.util.Properties();
    private static final String SSH_HOST = "10.20.40.197";
    private static final String SSH_LOGIN = "nikunj";
    private static final String SSH_PASSWORD = "Mind@123";


    public static void main(String[] args) {

        Session session = null;

        try {
            config.put("StrictHostKeyChecking", "no");
            JSch jSch = new JSch();

            session = jSch.getSession(SSH_LOGIN, SSH_HOST, 1267);
            if (session != null) {
                session.setPassword(SSH_PASSWORD);
                session.setConfig(config);
                session.connect();
                System.out.println("Connected");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (session != null) {
                session.disconnect();
            }
        }


    }

}
