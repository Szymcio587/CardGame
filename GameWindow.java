package com.company;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class GameWindow extends Window implements ActionListener{

    public GameWindow(PlayerClass player) {
        f = new JFrame();
        l = new JLabel(player.getName());
        l.setBounds(50, 350, 90, 30);
        b = new JButton("Jakaś opcja");
        b.setBounds(130,350,60,30);
        b.addActionListener(this);
        f.add(l);f.add(b);
        View();
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Krzysztof Dzbanaś");
    } ;
}
