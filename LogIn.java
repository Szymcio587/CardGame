import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogIn implements ActionListener{
    private static final int WINDOW_WIDTH  = 500, WINDOW_HEIGHT = 500;
    private PlayerCommunicator player;
    private JTextField tf;
    private JButton b;
    private JLabel l;

    public LogIn(PlayerCommunicator player) {
        this.player = player;
        JFrame f= new JFrame();
        l = new JLabel("Podaj swój nick:");
        l.setBounds(50, 150, 100, 20);
        tf=new JTextField();
        tf.setBounds(150,150,150,20);
        b=new JButton("Dołącz do gry");
        b.setBounds(50,350,150,50);
        b.addActionListener(this);
        f.add(l);f.add(tf);f.add(b);
        f.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        f.setLayout(null);
        f.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        player.Connect();
    } ;
}
