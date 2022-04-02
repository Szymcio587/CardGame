import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;

public class ServerClass extends ServerCommunicator{
    public static void main(String[] args) {
        ServerClass server = new ServerClass("localhost", 6666);
        server.Run();
    }

    public void Run() {
        if(LookForConnections()) {
            JFrame f= new JFrame("Label Example");
            JLabel l1;
            l1=new JLabel("Connection established.");
            l1.setBounds(50,50, 100,30);
            f.add(l1);
            f.setSize(300,300);
            f.setLayout(null);
            f.setVisible(true);
        }

    }

    public ServerClass(String ip, int host) {
        super(ip, host);
    }
}
