import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;


public class ServerCommunicator {
    private String ip;
    private int host;
    private Socket soc;

    public ServerCommunicator(String ip, int host) {
        this.ip = ip;
        this.host = host;
    }

    public boolean LookForConnections() {
        try {
            ServerSocket ss = new ServerSocket(6666);

            Socket soc = ss.accept();

            if(ss.isBound()) {
                return true;
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}