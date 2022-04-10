import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class LogIn extends Window implements ActionListener{
    private ArrayList<PlayerCommunicator> ar = new ArrayList<PlayerCommunicator>();
    private JTextField tf;

    public LogIn(PlayerCommunicator player) {
        ar.add(player);
        f = new JFrame();
        l = new JLabel("Podaj swój nick:");
        l.setBounds(50, 150, 100, 20);
        tf = new JTextField();
        tf.setBounds(200,150,150,20);
        b = new JButton("Dołącz do gry");
        b.setBounds(175,350,150,50);
        b.addActionListener(this);
        f.add(tf);f.add(l);f.add(b);
        View();
    }

    public void actionPerformed(ActionEvent e) {
        String name = tf.getText();
        ar.get(0).setName(name, 0);
        ar.get(0).Connect();
        f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
    } ;
}
