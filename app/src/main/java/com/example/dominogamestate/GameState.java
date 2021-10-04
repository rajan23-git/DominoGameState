package com.example.dominogamestate;

import java.util.ArrayList;

public class GameState {
    private int playerCount;
    private int playerOneScore;
    private int playerTwoScore;
    private int playerThreeScore;
    private int playerFourScore;
    private int playerTurn;



    private ArrayList<Domino> boneyard;
    private ArrayList<Domino> DominoSet;

    private Domino[][] board;

    public GameState() {
        playerCount = 2;
        playerOneScore=0;
        playerTwoScore=0;
        playerThreeScore = 0;
        playerFourScore = 0;

        board = new Domino[6][11];
        DominoSet= new ArrayList<Domino>(28);
        boneyard= new ArrayList<>(28-5*playerCount);
        boneyard.set(0, new Domino(0,0,0));





    }


    public GameState(GameState other) {
        playerOneScore = other.playerOneScore;
        playerTwoScore = other.playerTwoScore;
        playerThreeScore = other.playerThreeScore;
        playerFourScore = other.playerFourScore;
        board = new Domino[6][11];
        board = other.board;
    }


}
