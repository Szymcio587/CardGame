package com.company;
import javax.swing.*;
import java.security.PublicKey;
import java.util.Random;
import java.util.ArrayList;
public class Deck
{
    public Card[] cards;
    private int cardsindeck;

    public Deck()
    {
        cards = new Card[24];
    }

    public void reset()
    {
        Card.Color[] colors = Card.Color.values();
        cardsindeck=0;

        for(int i=0; i<4; i++)
        {
            Card.Color color = colors[i];
            for(int j=0; j<6; j++)
            {
                cards[cardsindeck++] = new Card(color, Card.Value.getValue(j));
            }
        }

    }

    public void replaceDeckWith(ArrayList<Card> cards){
        this.cards=cards.toArray(new Card[cards.size()]);
        this.cardsindeck = this.cards.length;
    }

    public boolean isEmpty() {
        return cardsindeck== 0;
    }

    public void shuffle()
    {
        Random random = new Random();
        int drawed;
        Card bufor;
        for(int i=0; i<cards.length; i++)
        {
            drawed = random.nextInt(cards.length-i);
            bufor = cards[drawed];
            cards[drawed] = cards[cards.length-i-1];
            cards[cards.length-i-1] = bufor;
        }
    }

    public Card drawCard() throws IllegalArgumentException{
        if(isEmpty()){
            throw new IllegalArgumentException("No more cards");
        }
        return cards[--cardsindeck];
    }
    public ImageIcon drawCardImage() throws IllegalArgumentException{
        if(isEmpty()){
            throw new IllegalArgumentException("No more cards");

        }
        return new ImageIcon((cards[--cardsindeck].toString()+".png"));
    }

    public Card[] drawCards(int n){
        Card[] ret = new Card[n];

        for(int i=0; i<n; i++){
            ret[i] = cards[--cardsindeck];
        }
        return ret;
    }
}
