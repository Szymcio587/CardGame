import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

public class PlayerClass extends PlayerCommunicator {

    private int points, bombs; //nie wiem jak inaczej przetłumaczyć bombki z tysiąca xD
    private int score_in_single_round; // dublowałeś zmienną do wyniku i licytacji
    private ArrayList<Card> collected;
    private ArrayList<Card> inhand;
    private boolean is_bidding;
    private int how_much_is_bidding;
    private boolean is_on_turn;

    public PlayerClass(String ip, int host) { //Reszty zmiennych nie ma sensu podawać w konstruktorze
        super(ip, host);
        this.points = 0;
        this.is_bidding = false;
        this.is_on_turn = false;
        this.score_in_single_round = 0;
    }

    /* punkty chyba lepiej żeby były dodawane w silniku gry, a nie w klasie każdego gracza imo
>>>>>>> 8b1583c (Przekazywanie podstawowych danych gracz-serwer, naprawa błędów)
    public void summation()
    {
        for(int i=0; i<collected.size(); i++)
        {
            if(Card.Value.getValue(i)== Card.Value.NINE)
                score_in_single_round+=2;
            else if(Card.Value.getValue(i)== Card.Value.TEN)
                score_in_single_round+=10;
            else if(Card.Value.getValue(i)== Card.Value.JACK)
                score_in_single_round+=2;
            else if(Card.Value.getValue(i)== Card.Value.QUEEN)
                score_in_single_round+=3;
            else if(Card.Value.getValue(i)== Card.Value.KING)
                score_in_single_round+=4;
            else if(Card.Value.getValue(i)== Card.Value.ACE)
                score_in_single_round+=11;
        }
    }

    public void general_summation()
    {
        if(is_bidding==true && score_in_single_round>=how_much_is_bidding)
            points+=how_much_is_bidding;
        else if(is_bidding==true && score_in_single_round<how_much_is_bidding)
            points-=how_much_is_bidding;
        else
            points+=score_in_single_round;
        score_in_single_round=0;
    }


    public void add_points()
    {
        points+=score_in_single_round;
        score_in_single_round = 0;
    }
    */
    public int getBombs() {
        return bombs;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setBombs(int bombs) {
        this.bombs = bombs;
    }

    public int getScore_in_single_round() {
        return score_in_single_round;
    }

    public void setScore_in_single_round(int score_in_single_round) {
        this.score_in_single_round = score_in_single_round;
    }

    public ArrayList<Card> getCollected() {
        return collected;
    }

    public void setCollected(ArrayList<Card> collected) {
        this.collected = collected;
    }

    public ArrayList<Card> getInhand() {
        return inhand;
    }

    public void setInhand(ArrayList<Card> inhand) {
        this.inhand = inhand;
    }

    public boolean isIs_bidding() {
        return is_bidding;
    }

    public void setIs_bidding(boolean is_bidding) {
        this.is_bidding = is_bidding;
    }

    public int getHow_much_is_bidding() {
        return how_much_is_bidding;
    }

    public void setHow_much_is_bidding(int how_much_is_bidding) {
        this.how_much_is_bidding = how_much_is_bidding;
    }

    public boolean isIs_on_turn() {
        return is_on_turn;
    }

    public void setIs_on_turn(boolean is_on_turn) {
        this.is_on_turn = is_on_turn;
    }
}