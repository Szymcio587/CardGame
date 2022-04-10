import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class GameWindow extends Window implements ActionListener{
    private ArrayList<PlayerClass> ar = new ArrayList<PlayerClass>();
    private JLabel l1, l2, l3;
    private JButton b1;
    private int y;
    private JPanel p1, p2;
    private JButton[] cards = new JButton[24];
    private Icon[] images = new ImageIcon[24];

    public GameWindow(PlayerClass player) {
        ar.add(player);
        if(player.getID() == 1) {
            y = 50;
        }
        if(player.getID() == 2) {
            y = 200;
        }
        if(player.getID() == 3) {
            y = 350;
        }
        for(int q=0; q<24; q++) {
            images[q] = new ImageIcon(player.getPath(q));
            cards[q] = new JButton(images[q]);
            if(q < 7) {
                cards[q].setBounds(100 + 40 * q, 50, 30, 30);
            }
            else if(q > 6 && q < 14) {
                cards[q].setBounds(100 + 40 * (q - 7), 200, 30, 30);
            }
            else if (q > 13 && q < 21) {
                cards[q].setBounds(100 + 40 * (q - 14), 350, 30, 30);
            }

            cards[q].setIcon(images[q]);
        }
        p1 = new JPanel();
        p2 = new JPanel();
        f = new JFrame();
        l = new JLabel(player.getName(0));
        l.setBounds(20, 50, 70, 30);
        l1 = new JLabel(player.getName(1));
        l1.setBounds(20, 200, 70, 30);
        l2 = new JLabel(player.getName(2));
        l2.setBounds(20, 350, 70, 30);
        l3 = new JLabel("Obecnie trwa tura gracza nr." + player.getCurrentID());
        l3.setBounds(400, y, 250, 30);
        b = new JButton("Pasuj");
        b.setBounds(500,y - 30,100,25);
        b1 = new JButton("Podbij");
        b1.setBounds(500,y + 15,100,25);
        b.addActionListener(this);
        f.add(l);f.add(l1);f.add(l2);p1.add(b);p1.add(b1);p2.add(l3);
        for(int q=0; q<21; q++) {
            f.add(cards[q]);
        }
        if(player.is_on_turn()) {
            p1.setVisible(true);
            p2.setVisible(false);
        }
        else {
            p2.setVisible(true);
            p1.setVisible(false);
        }
        View();
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b) {
            ar.get(0).setBidding(false);
        }
        if(e.getSource() == b1) {
            ar.get(0).setBid(ar.get(0).getCurrentBid() + 10);
            ar.get(0).setCurrentBid(ar.get(0).getCurrentBid() + 10);
        }
        ar.get(0).set_on_turn(false);
    } ;
}
