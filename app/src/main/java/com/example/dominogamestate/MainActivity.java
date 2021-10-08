package com.example.dominogamestate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
/**
 * @author Connor Burk
 * @author David Le
 * @author Paul Kenstler
 * @author Pranav Rajan
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = (Button) findViewById(R.id.runTest);
        b.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.runTest){
            EditText e = findViewById(R.id.outputText);
            e.getText().clear();
            Log.d("d", "runTest pressed");

            //creating a new gamestate
            GameState firstInstance = new GameState();
            e.append(firstInstance.toString());
            //Making deep copy from player 1 perspective
            GameState secondInstance = new GameState(firstInstance);

            //Printing out gamestate to the text box
            e.setText(secondInstance.toString());

            //beginning of game

            //Goes through all player's hand and determines the highest double
            //and whoever does, they will go first.
            int[] firstMove = firstInstance.firstMove();

            e.append("\nPlayer 3 goes first and places down a domino[6|6]");
            firstInstance.placeFirstPiece(firstMove[0],firstMove[1]);
            e.append(firstInstance.toString());

            e.append("\nPlayer 2 goes second and places down domino[0|6]. Player 2 gets 6 points.");
            firstInstance.placePiece(1,4,0,1);
            e.append(firstInstance.toString());

            e.append("\nPlayer 1 goes third and does not have valid placePiece. They draw" +
                    " domino[0|3].");
            firstInstance.drawPiece(0);
            e.append(firstInstance.toString());

            e.append("\nPlayer 1 places domino[0|3]. Player 1 gains 9 points.");
            firstInstance.placePiece(0,5,0,2);
            e.append(firstInstance.toString());

            e.append("\n Player 3 presses 'Quit Game' and forfeits.");
            firstInstance.quitGame(2);
            e.append("\n Player 3's score being set to -1 indicates they have forfeited by" +
                    " pressing 'Quit Game'.");
            e.append(firstInstance.toString());

            e.append("\n Player 2 presses New Game. Their score is set to -2 to indicate they" +
                    " have forfeited by pressing New Game." +
                    " In the complete app, it will go back to start screen.");
            firstInstance.newGame(1);
            e.append(firstInstance.toString());

            //creates a third instance of the game and sets it to secondInstance
            GameState thirdInstance = new GameState(secondInstance);

            //checks if third=second and if our copy constructor works
            if (thirdInstance.toString().equals(secondInstance.toString()))
            {
                e.append(thirdInstance.toString());
                e.append(secondInstance.toString());
            }
            else
            {
                e.append("\nThirdInstance and SecondInstance do not match.");
            }
        }
    }
}