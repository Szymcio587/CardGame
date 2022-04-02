import javax.swing.*;

public class Error {
    private static final int WINDOW_WIDTH = 500, WINDOW_HEIGHT = 500;

    Error(String message) {
        JFrame f= new JFrame("Error message");
        JLabel l1;
        l1=new JLabel(message);
        l1.setBounds(150,100, 200,30);
        f.add(l1);
        f.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        f.setLayout(null);
        f.setVisible(true);
    }
}
