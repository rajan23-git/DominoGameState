package com.example.dominogamestate;

import android.app.Activity;

import java.util.ArrayList;

public class GameState {

    private int playerCount = 4;

    DominoSet dominoSet;
    Domino[][] board;
    ArrayList<Domino> boneyard;

    ArrayList<Players> user = new ArrayList<Players>(playerCount);
    public GameState() {
        //create player objects equal to the amount of players playing.
        for(int i=0; i <playerCount;i++)
        {
            Players x = new Players(i,0);
            user.add(x);
        }

        // First domino will be placed at [2][5]!!
        board = new Domino[5][11];
        boneyard = new ArrayList<>(28-playerCount*5);
        // Create a new set of dominoes and shuffle it!
        dominoSet = new DominoSet();
        //dominoSet.shuffleSet();

        //gives each player 5 dominoes and updates the dominoSet
        for(int i = 0; i < 5; i++){
            for (int j = 0; i < playerCount; i++) {

                user.get(j).getHand().add(dominoSet.dominos.get(0));
                dominoSet.dominos.remove(0);
            }

        }

        // Taking player 3 and removing their first domino. Then giving them the double six to
        // ensure that game says they go first!
        user.get(2).getHand().remove(0);
        user.get(2).getHand().add(dominoSet.dominos.get(dominoSet.dominos.size() - 1));
        dominoSet.dominos.remove(dominoSet.dominos.size() - 1);

        // Fill the boneyard with the leftover dominoes in set. Empty dominoSet after.
        for (int i = 0; i < dominoSet.dominos.size(); i++){
            // Fill each piece of boneyard with remaining dominoes in set. Then remove from dominoSet.
            boneyard.set(i, dominoSet.dominos.get(0));
            dominoSet.dominos.remove(0);
        }

    }

    public GameState(GameState other) {
        playerCount = other.playerCount;

        this.user = new ArrayList<Players>(this.playerCount);

        for(int i=0; i <playerCount;i++) {
            this.user.set(i, new Players(other.user.get(i)));

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
            this.boneyard.set(i, new Domino(other.boneyard.get(i)));
        }

        for (int i = 0; i < dominoSet.dominos.size(); i++){
            this.dominoSet.dominos.set(i, new Domino(other.dominoSet.dominos.get(i)));
        }
    }
    // Fill these in later!!!! Just putting these in to show what we need to do.
    public int[] firstMove() {
        int lowestMax = -1;
        int playerLowestMax = -1;
        int dominoHighestWeight = -1;

        for (int i = 0; i < playerCount; i++) {
            for (int j = 0; j < 5; j++) {
                if (user.get(i).getHand().get(j).getWeight() > lowestMax) {
                    lowestMax = user.get(i).getHand().get(j).getWeight();
                    playerLowestMax = i;
                    dominoHighestWeight = j;
                }

            }
        }
        int[] goesFirstInfo = new int[2];
        goesFirstInfo[0] = playerLowestMax;
        goesFirstInfo[1] = dominoHighestWeight;
        return goesFirstInfo;
    }

    public boolean hasValidMove(int playerID){
        ArrayList<Domino> playerDominos = user.get(playerID).getHand();
        for(int i = 0; i < user.get(playerID).getHand().size(); i++){
            if(playerDominos.get(i).getLeftPipCount() == board[0][0].getLeftPipCount()){

            }
        }


        return false;
    }


    public boolean placePiece(int playerID, int dominoIndex, int x, int y){


        return false;
    }




    public boolean drawPiece(int playerID){

        if (boneyard.isEmpty()){
            return false;
        }

        user.get(playerID).getHand().add(boneyard.get(0));
        boneyard.remove(0);

        return true;
    }

    public boolean quitGame(int playerID){


        return false;
    }

    public boolean newGame(int playerID){




        return false;
    }

    @Override
    public String toString(){
        String s = new String();

        for (int i = 0; i < user.size(); i++){
            s += user.get(i).toString();
        }

        return s;
    }

}
