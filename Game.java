import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    private int currentPlayer;
    private String[] playerIds;

    public Deck deck;
    private ArrayList<ArrayList<Card>> stockpile;
    private ArrayList<Card> rest;

    private Card.Color validColor;
    private Card.Value validValue;
    public Arrays[] playerClass;

    public Game(String[] pids) {
        deck = new Deck();
        deck.shuffle();
        stockpile = new ArrayList<ArrayList<Card>>();

        playerIds = pids;
        currentPlayer = 0;



        for(int i=0; i<pids.length; i++)
        {
            ArrayList<Card> hand = new ArrayList<Card>(Arrays.asList(deck.drawCards(7)));
            playerClass.add(hand);
        }
    }

    public void start(Game game)
    {
        Card card = deck.drawCard();





    }
}
