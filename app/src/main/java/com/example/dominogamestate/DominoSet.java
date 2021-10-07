package com.example.dominogamestate;

import static java.lang.Integer.parseInt;

import java.util.ArrayList;
import java.util.Collections;
/*
    External Citation:
    10/4/2021
    Took some code from here and ported it from C# to Java because I liked the way they did it.
    https://codereview.stackexchange.com/questions/58464/basic-domino-game-architecture
 */
public class DominoSet {
    public ArrayList<Domino> dominos;
    // Doubles have more weight than non-doubles!
    private final String[] tiles = {"0,1", "0,2", "0,3", "0,4", "0,5", "0,6",
                                           "1,2", "1,3", "1,4", "1,5", "1,6",
                                                  "2,3", "2,4", "2,5", "2,6",
                                                         "3,4", "3,5", "3,6",
                                                                "4,5", "4,6",
                                                                       "5,6",
                                    "0,0","1,1","2,2","3,3","4,4","5,5","6,6"};

    public DominoSet() {
        dominos = new ArrayList<>(28);

        for(int i = 0; i < 28; i++){
            String[] word = tiles[i].split(",");
            dominos.set(i,new Domino(parseInt(word[0]), parseInt(word[1]),0, i));

        }
    }

    public void shuffleSet(){
        Collections.shuffle(this.dominos);
    }
}
