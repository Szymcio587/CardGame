import javax.swing.*;
import java.awt.event.*;

public class PlayerClass extends PlayerCommunicator {
    private int points, bid, bombs; //nie wiem jak inaczej przetłumaczyć bombki z tysiąca xD

    public PlayerClass(String ip, int host) {
        super(ip, host);
        points = 0;
        bid = 0;
        bombs = 2;
    }

    public int getBombs() {
        return bombs;
    }
}