package com.company;
import javax.swing.*;
import java.util.Random;
import java.util.ArrayList;
public class Deck
{
    private Card[] cards;
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
        int n = cards.length;
        Random random = new Random();
        for(int i=0; i<cards.length; i++)
        {
            int randomvalue = i + random.nextInt(n-1);
            Card randomCard = cards[randomvalue] = cards[i];
            cards[i] = randomCard;
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
