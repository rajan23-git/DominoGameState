package com.example.dominogamestate;

public class Domino {

    private int leftPips;
    private int rightPips;
    private int orientation;

    public Domino(){
        leftPips = 0;
        rightPips = 0;
        orientation = 0;
    }

    public Domino(int pipsLeft, int pipsRight, int dOrientation){
        leftPips = pipsLeft;
        rightPips = pipsRight;
        orientation = dOrientation;
    }

}
