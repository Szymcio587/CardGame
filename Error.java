import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;

public class Error extends Window implements ActionListener{

    public Error(String message) {
        f= new JFrame("Error message");
        l=new JLabel(message);
        l.setBounds(50,100, 400,30);
        b=new JButton("Wyjście");
        b.setBounds(50,350,150,50);
        b.addActionListener(this);
        f.add(l);f.add(b);
        View();
    }

    public void actionPerformed(ActionEvent e) {
        f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
    } ;
}
