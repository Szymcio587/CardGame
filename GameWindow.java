import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class GameWindow extends Window implements ActionListener{
    private JLabel l1, l2;

    public GameWindow(PlayerClass player) {
        f = new JFrame();
        l = new JLabel(player.getName(0));
        l.setBounds(50, 50, 90, 30);
        l1 = new JLabel(player.getName(1));
        l1.setBounds(50, 150, 90, 30);
        l2 = new JLabel(player.getName(2));
        l2.setBounds(50, 250, 90, 30);
        b = new JButton("Jakaś opcja");
        b.setBounds(130,350,60,30);
        b.addActionListener(this);
        f.add(l);f.add(l1);f.add(l2);f.add(b);
        View();
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Krzysztof Dzbanaś");
    } ;
}
