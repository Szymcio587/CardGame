import javax.swing.*;

public class Window {
    protected static final int WINDOW_WIDTH = 500, WINDOW_HEIGHT = 500;
    protected JFrame f;
    protected JLabel l;
    protected JButton b;

    public void View() {
        f.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        f.setLayout(null);
        f.setVisible(true);
    }
}
