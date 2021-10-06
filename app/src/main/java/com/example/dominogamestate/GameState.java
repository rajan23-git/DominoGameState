package com.example.dominogamestate;

import android.app.Activity;

import java.util.ArrayList;

public class GameState {
    private int playerCount;
    //private int[] playerScore = new int[playerCount];
    //private int[] players = new int[playerCount];

    DominoSet dominoSet;
    Domino[][] board;
    ArrayList<Domino> boneyard;

    //ArrayList<Domino> player1Hand, player2Hand, player3Hand, player4Hand;
    //ArrayList<Domino> playerHand;
    ArrayList<Players> user = new ArrayList<Players>(playerCount);
    public GameState() {



        for(int i=0; i <playerCount;i++)
        {
            //playerScore[i] = 0;
            //players[i]=i;

            Players x = new Players(i,0);
            user.add(x);
        }
        user.get(0);



        // First domino will be placed at [2][5]!!
        board = new Domino[5][11];
        boneyard = new ArrayList<>(28-playerCount*5);
        // Create a new set of dominoes and shuffle it!
        dominoSet = new DominoSet();
        dominoSet.shuffleSet();

        //player1Hand = new ArrayList<>();
        //player2Hand = new ArrayList<>();
        //player3Hand = new ArrayList<>();
        //player4Hand = new ArrayList<>();




        for(int i = 0; i < 5; i++){
            //add to player's hands
            /*
            player1Hand.add(dominoSet.dominos.get(0));
            //remove from deck
            dominoSet.dominos.remove(0);

            player2Hand.add(dominoSet.dominos.get(0));
            dominoSet.dominos.remove(0);

            player3Hand.add(dominoSet.dominos.get(0));
            dominoSet.dominos.remove(0);

            player4Hand.add(dominoSet.dominos.get(0));
            dominoSet.dominos.remove(0);
            */
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
       /* //Player scores
        s += "Player One Score: " + playerScore[0] + ".";
        s += "\nPlayer Two Score: " + playerScore[1] + ".";
        if (playerCount >= 3){
            s += "\nPlayer Three Score: " + playerScore[2] + ".";
        }
        if (playerCount == 4){
            s += "\nPlayer Four Score: " + playerScore[3] + ".";
        }
*/
        for (int i = 0; i < user.size(); i++){
            s += user.get(i).toString();
        }
        /*
        //Player hands

        s += "Player One Hand: " + player1Hand.toString() + ".";
        s += "\nPlayer Two Hand: " + player2Hand.toString() + ".";
        if (playerCount >= 3){
            s += "\nPlayer Three Hand: " + player3Hand.toString() + ".";
        }
        if (playerCount == 4){
            s += "\nPlayer Four Hand: " + player4Hand.toString() + ".";
        }
        */
        return s;
    }


    public GameState(GameState other) {
        playerCount = other.playerCount;

        //this.players = new int[playerCount];
        //this.playerScore = new int[playerCount];

        for(int i=0; i <playerCount;i++) {
            //this.playerScore[i] = other.playerScore[i];
            //this.players[i]= other.players[i];

        }

        this.board = new Domino[5][11];
        this.boneyard = new ArrayList<>(other.boneyard.size());
        this.dominoSet = new DominoSet();

        for (int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                this.board[i][j] = other.board[i][j];
            }
        }

        for (int i = 0; i < boneyard.size(); i++){
            //this.boneyard.set(i, other.boneyard.get(i));
            this.boneyard.set(i, new Domino(other.boneyard.get(i)));
        }

        for (int i = 0; i < dominoSet.dominos.size(); i++){
            this.dominoSet.dominos.set(i, new Domino(other.dominoSet.dominos.get(i)));
        }
        /*
        this.player1Hand = new ArrayList<>();
        this.player2Hand = new ArrayList<>();
        this.player3Hand = new ArrayList<>();
        this.player4Hand = new ArrayList<>();

        this.player1Hand = other.player1Hand;
        this.player2Hand = other.player2Hand;
        this.player3Hand = other.player3Hand;
        this.player4Hand = other.player4Hand;
         */

    }
    // Fill these in later!!!! Just putting these in to show what we need to do.
    public int firstMove()
    {

        return 0;
    }

    public boolean placePiece(int playerID, Domino domino, int x, int y){
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
