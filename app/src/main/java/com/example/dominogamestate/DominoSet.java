package com.example.dominogamestate;

import static java.lang.Integer.parseInt;

import java.util.ArrayList;
import java.util.Collections;

public class DominoSet {
    public ArrayList<Domino> dominos;
    private final String[] tiles = {"0,0","0,1", "0,2", "0,3", "0,4", "0,5", "0,6",
                                    "1,1", "1,2", "1,3", "1,4", "1,5", "1,6",
                                           "2,2", "2,3", "2,4", "2,5", "2,6",
                                                  "3,3", "3,4", "3,5", "3,6",
                                                         "4,4", "4,5", "4,6",
                                                                "5,5", "5,6",
                                                                       "6,6"};

    public DominoSet() {
        dominos = new ArrayList<>(28);

        for(int i = 0; i < 28; i++){
            String[] word = tiles[i].split(",");
            dominos.set(i,new Domino(parseInt(word[0]), parseInt(word[1]), 0));

        }
    }

    public void shuffleSet(){
        Collections.shuffle(this.dominos);
    }
}
