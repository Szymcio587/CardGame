import java.util.ArrayList;

public class Engine {
    private int currentPlayer;
    private Deck deck;
    private ArrayList<Card[]> playersHands = new ArrayList<Card[]>();
    private Card.Color currentColor;

    private static PlayerClass player;

    public static void main(String[] args) {
        Engine e = new Engine();
    }

    public Engine() {
        player = new PlayerClass("localhost", 6666);
        while(!player.HasStarted()) {
            System.out.print("");
        }
        Run();
    }

    public void Run() {
        GameWindow window = new GameWindow(player);
    }
}
