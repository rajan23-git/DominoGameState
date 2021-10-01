package com.example.dominogamestate;

public class GameState {
    private int playerOneScore;
    private int playerTwoScore;
    private int playerThreeScore;
    private int playerFourScore;
    private int playerCount;

    public GameState() {
        playerOneScore = 0;
        playerTwoScore = 0;
        playerThreeScore = 0;
        playerFourScore = 0;
    }
    public String toString(){
        String s = "Player One Score: " + playerOneScore + ".\nPlayer Two Score: " + playerTwoScore + ".";
        if (playerCount <= 3){
            s += "\nPlayer Three Score: " + playerThreeScore + ".";
        }
        if (playerCount == 4){
            s += "\nPlayer Four Score: " + playerFourScore + ".";
        }

        return s;
    }









    public GameState(GameState other) {



    }


}
