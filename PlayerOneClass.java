import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;

public class PlayerOneClass extends PlayerOneCommunicator implements PlayerInterface{
    private boolean isConnected;

    public static void main(String[] args) {
        PlayerOneClass pl = new PlayerOneClass("localhost", 6666);
        pl.Run();
    }

    public void Run() {
        JFrame f=new JFrame("SuperCardGame!");
        JButton b=new JButton("Start game");
        b.setBounds(50,100,95,30);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(!isConnected)
                    Connect();
                else
                    Disconnect();
            }
        });
        f.add(b);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
    }

    public PlayerOneClass(String ip, int host) {
        super(ip, host);
        isConnected = false;
    }
}