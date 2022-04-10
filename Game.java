import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    /*Nie ma potrzeby robienia takiej struktury jak w tutorialu bo nie będziemy dobierali kart w trakcie gry ani tasowali
    talii od nowa, wystarczy wylosować karty co każdą partię.*/

    private int[] points = new int[3];
    private int[] bombs = new int[3];
    private ArrayList<Card>[] hands = new ArrayList[4];


    private Deck deck;
    private int currentPlayerID, bid;
    private Card.Color validColor;
    private Card.Value validValue;
    private Card.Color atut;

    public Game() {
        for(int q=0; q<3; q++) {
            points[q] = 0;
            bombs[q] = 2;
        }
        currentPlayerID = 1;

        startRound();

    }

    public void startRound() {
        deck = new Deck();
        deck.shuffle();

        for(int i=0; i<3; i++)
        {
            hands[i] = new ArrayList<Card>(Arrays.asList(deck.drawCards(7)));
        }
        hands[3] = new ArrayList<Card>(Arrays.asList(deck.drawCards(3)));

    }

    public String getPath(int player, int index) {
        return hands[player].get(index).getPath();
    }

    public void start(Game game)
    {
        Card card = deck.drawCard();
    }

}
