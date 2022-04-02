import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;

public class PlayerOneCommunicator {
    private String ip;
    private int host;
    private Socket soc;

    public void Connect() {
        try {
            this.soc = new Socket(ip, host);
        }
        catch (Exception g) {
            System.out.println(g);
        }
    }

    public void Disconnect() {
        try {
            this.soc.close();
        }
        catch (Exception g) {
            System.out.println(g);
        }
    }

    public PlayerOneCommunicator(String ip, int host) {
        this.ip = ip;
        this.host = host;
    }

    public PlayerOneCommunicator() {
    }
}
