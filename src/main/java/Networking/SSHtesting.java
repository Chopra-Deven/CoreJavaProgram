package Networking;

import com.jcraft.jsch.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class SSHtesting {
    private static final String SSH_HOST = "nikunj@10.20.40.197";
    private static final String SSH_LOGIN = "nikunj";
    private static final String SSH_PASSWORD = "Mind@123";

    public static void main(String[] args) throws JSchException, IOException {

        String command = "vmstat";

        JSch jsch = new JSch();
        Session session = jsch.getSession(SSH_LOGIN, SSH_HOST, 1267);
        session.setPassword(SSH_PASSWORD);
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect();

        System.out.println("Connection success!!!!!!!!");

        Channel channel = session.openChannel("exec");
        ((ChannelExec) channel).setCommand(command);

        InputStream inputStream = channel.getInputStream();
        channel.connect();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        channel.disconnect();
        session.disconnect();
    }

}


