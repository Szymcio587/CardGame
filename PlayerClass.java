package com.company;

import com.company.PlayerCommunicator;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

public class PlayerClass extends PlayerCommunicator {

    public int score;
    public int score_in_single_round;
    public ArrayList<Card> collected;
    public ArrayList<Card> inhand;
    public boolean is_bidding;
    public int how_much_is_bidding;
    public boolean is_on_turn;

    public PlayerClass(String ip, int host, int score, int score_in_single_round, boolean is_bidding, int how_much_is_bidding) {
        super(ip, host);
        this.score = score;
        this.score_in_single_round = score_in_single_round;
        this.is_bidding = is_bidding;
        this.how_much_is_bidding = how_much_is_bidding;
    }

    public void summation()
    {
        for(int i=0; i<collected.size(); i++)
        {
            if(Card.Value.getValue(i)== Card.Value.Nine)
                score_in_single_round+=2;
            else if(Card.Value.getValue(i)== Card.Value.Ten)
                score_in_single_round+=10;
            else if(Card.Value.getValue(i)== Card.Value.Jack)
                score_in_single_round+=2;
            else if(Card.Value.getValue(i)== Card.Value.Queen)
                score_in_single_round+=3;
            else if(Card.Value.getValue(i)== Card.Value.King)
                score_in_single_round+=4;
            else if(Card.Value.getValue(i)== Card.Value.Ase)
                score_in_single_round+=11;
        }
    }

    public void general_summation()
    {
        if(is_bidding==true && score_in_single_round>=how_much_is_bidding)
            score+=how_much_is_bidding;
        else if(is_bidding==true && score_in_single_round<how_much_is_bidding)
            score-=how_much_is_bidding;
        else
            score+=score_in_single_round;
        score_in_single_round=0;
    }


    public void add_points()
    {
        score+=score_in_single_round;
        score_in_single_round = 0;
    }




}