package com.example.dominogamestate;

import java.util.ArrayList;

public class Players {
    private int id;
    private int score;
    private ArrayList<Domino> playerHand;

    public Players(int id, int score)
    {
        this.id = id;
        playerHand = new ArrayList<>();
        this.score=score;
    }
    public Players(Players other)
    {
        this.id = other.id;
        this.playerHand= new ArrayList<Domino>(other.playerHand.size());
        for(int i=0; i< other.playerHand.size();i++)
        {
            //this.playerHand.set(i,
        }
        this.playerHand = other.playerHand;
        this.score= other.score;
    }

    public int getId()
    {
        return id;
    }
    public int getScore()
    {
        return score;
    }
    public ArrayList getHand()
    {
        return playerHand;
    }
    public void setScore(int score)
    {
        this.score = score;
    }

}
