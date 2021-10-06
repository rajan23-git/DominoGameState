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
    public String toString(){
        String s = new String();
        s += "Player " + (id + 1) + " Score: " + score + "\nHand: ";
        for (Domino d:playerHand) {
            s += d.toString() + ", ";
        }
        return s;
    }
}
