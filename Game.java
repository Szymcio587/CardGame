import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    /*Nie ma potrzeby robienia takiej struktury jak w tutorialu bo nie będziemy dobierali kart w trakcie gry ani tasowali
    talii od nowa, wystarczy wylosować karty co każdą partię.*/

    private int currentPlayer;
    private Deck deck;
    private ArrayList<Card> rest;
    private static ArrayList<PlayerClass> players = new ArrayList<PlayerClass>();

    private Card.Color validColor;
    private Card.Value validValue;
    private Card.Color atut;

    private class ReadFromServer implements Runnable {
        private DataInputStream input;

        public ReadFromServer(DataInputStream in) {
            input = in;
            System.out.println("Sending message to server...");
        }

        public void run() {

        }
    }


    public Game(ArrayList<PlayerClass> players) {
        for(int i=0; i<3; i++)
        {
            System.out.println(players.get(i).getName(i));
        }
        deck = new Deck();
        deck.shuffle();

        currentPlayer = 0;

        for(int i=0; i<3; i++)
        {
            ArrayList<Card> hand = new ArrayList<Card>(Arrays.asList(deck.drawCards(7)));
        }
        ArrayList<Card> rest = new ArrayList<Card>(Arrays.asList(deck.drawCards(7)));
    }

    public void start(Game game)
    {
        Card card = deck.drawCard();
    }

    public static void AddPlayer(PlayerClass player) {
        players.add(player);
    }

    public static int GetPlayersNumber() {
        return players.size();
    }

}
