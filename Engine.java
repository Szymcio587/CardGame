import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Engine {
    private int currentPlayer;
    private Deck deck;
    private ArrayList<Card[]> playersHands = new ArrayList<Card[]>();
    private Card.Color currentColor;
    private static PlayerClass player;

    public static void main(String[] args) {
        player = new PlayerClass("localhost", 6666);
    }

    public Engine() {
        Run();
    }

    public void Run() {
        System.out.println("Teraz powinna zacząć się gra");
    }
}
