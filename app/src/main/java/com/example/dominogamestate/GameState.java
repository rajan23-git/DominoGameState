package com.example.dominogamestate;

import java.util.ArrayList;

public class GameState {
    private int playerOneScore;
    private int playerTwoScore;
    private int playerThreeScore;
    private int playerFourScore;
    private int playerCount;
    private int[] players = new int[playerCount];

    DominoSet dominoSet;
    Domino[][] board;
    ArrayList<Domino> boneyard;
    ArrayList<Domino> player1Hand, player2Hand, player3Hand, player4Hand;

    public GameState() {
        playerOneScore = 0;
        playerTwoScore = 0;
        playerThreeScore = 0;
        playerFourScore = 0;

        for(int i=0; i <playerCount;i++)
        {
            players[i]=i;
        }

        // First domino will be placed at [2][5]!!
        board = new Domino[5][11];
        boneyard = new ArrayList<>(28-playerCount*5);
        // Create a new set of dominoes and shuffle it!
        dominoSet = new DominoSet();
        dominoSet.shuffleSet();

        player1Hand = new ArrayList<>();
        player2Hand = new ArrayList<>();
        player3Hand = new ArrayList<>();
        player4Hand = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            //add to player's hands
            player1Hand.add(dominoSet.dominos.get(0));
            //remove from deck
            dominoSet.dominos.remove(0);

            player2Hand.add(dominoSet.dominos.get(0));
            dominoSet.dominos.remove(0);

            player3Hand.add(dominoSet.dominos.get(0));
            dominoSet.dominos.remove(0);

            player4Hand.add(dominoSet.dominos.get(0));
            dominoSet.dominos.remove(0);
        }

        for (int i = 0; i < dominoSet.dominos.size(); i++){
            // Fill each piece of boneyard with remaining dominoes in set. Then remove from dominoSet.
            boneyard.set(i, dominoSet.dominos.get(0));
            dominoSet.dominos.remove(0);
        }

    }
    @Override
    public String toString(){
        String s = new String();

        //Player scores
        s += "Player One Score: " + playerOneScore + ".";
        s += "\nPlayer Two Score: " + playerTwoScore + ".";
        if (playerCount >= 3){
            s += "\nPlayer Three Score: " + playerThreeScore + ".";
        }
        if (playerCount == 4){
            s += "\nPlayer Four Score: " + playerFourScore + ".";
        }

        //Player hands
        s += "Player One Hand: " + player1Hand.toString() + ".";
        s += "\nPlayer Two Hand: " + player2Hand.toString() + ".";
        if (playerCount >= 3){
            s += "\nPlayer Three Hand: " + player3Hand.toString() + ".";
        }
        if (playerCount == 4){
            s += "\nPlayer Four Hand: " + player4Hand.toString() + ".";
        }

        return s;
    }


    public GameState(GameState other) {
        playerOneScore = other.playerOneScore;
        playerTwoScore = other.playerTwoScore;
        playerThreeScore = other.playerThreeScore;
        playerFourScore = other.playerFourScore;
        playerCount = other.playerCount;

        board = new Domino[5][11];
        boneyard = new ArrayList<>(other.boneyard.size());
        dominoSet = new DominoSet();

        for (int i = 0; i < boneyard.size(); i++){
            boneyard.set(i, other.boneyard.get(i));
        }

        for (int i = 0; i < dominoSet.dominos.size(); i++){
            dominoSet.dominos.set(i, other.dominoSet.dominos.get(i));
        }

    }
    // Fill these in later!!!! Just putting these in to show what we need to do.
    public boolean placePiece(int playerID, Domino domino){

        return false;
    }

    public boolean drawPiece(int playerID){

        return false;
    }

    public boolean quitGame(int playerID){
        return false;
    }

    public boolean newGame(int playerID){
        return false;
    }

}
