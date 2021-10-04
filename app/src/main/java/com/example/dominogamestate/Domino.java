package com.example.dominogamestate;

public class Domino {

    private final int leftPipsCount;
    private final int rightPipsCount;
    private int orientation;
    private final int weight;

    /*public Domino(){
        leftPipsCount = 0;
        rightPipsCount = 0;
        orientation = 0;
        weight = 0;
    }*/

    public Domino(int pipsLeft, int pipsRight, int paramOrientation, int weightParam){
        leftPipsCount = pipsLeft;
        rightPipsCount = pipsRight;
        orientation = paramOrientation;
        weight = weightParam;
    }

    public String toString(){
        String s = new String();
        s += "(" + leftPipsCount + "|" + rightPipsCount + ")";
        return s;
    }

}
