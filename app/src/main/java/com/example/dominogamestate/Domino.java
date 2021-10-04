package com.example.dominogamestate;

public class Domino {

    private int leftPipsCount;
    private int rightPipsCount;
    private int orientation;

    public Domino(){
        leftPipsCount = 0;
        rightPipsCount = 0;
        orientation = 0;
    }

    public Domino(int pipsLeft, int pipsRight, int paramOrientation){
        leftPipsCount = pipsLeft;
        rightPipsCount = pipsRight;
        orientation = paramOrientation;
    }

    public String toString(){
        String s = new String();
        s += "(" + leftPipsCount + "|" + rightPipsCount + ")";
        return s;
    }

}
