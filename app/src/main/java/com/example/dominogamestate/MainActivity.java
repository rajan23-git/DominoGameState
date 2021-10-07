package com.example.dominogamestate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
            e.setText(firstInstance.toString());
            //Making deep copy from player 1 perspective
            GameState secondInstance = new GameState(firstInstance);

            //Printing out gamestate to the text box
            e.setText(secondInstance.toString());

            //beginning of game

            //Goes through all player's hand and determines the highest double
            //and whoever does, they will go first.
            int[] firstMove = firstInstance.firstMove();

            e.append("Player 3 goes first and places down a domino[6|6]");
            firstInstance.placePiece(firstMove[0],firstMove[1],2,5);
            e.append(firstInstance.toString());

            e.append("player 2 goes second and places down");
            firstInstance.placePiece(1,0,0,0);
            e.append(firstInstance.toString());

            e.append("player 1 goes third and does not have valid placePiece");
            firstInstance.placePiece(0,0,0,0);
            e.append(firstInstance.toString());

            e.append("player 1 draws dominoes until they can make a valid move");
            firstInstance.drawPiece(0);
            e.append(firstInstance.toString());

            e.append("player 1 goes again and places down");
            firstInstance.placePiece(0,0,0,0);
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
                e.append("ThirdInstance and SecondInstance do not match.")
            }







        }
    }
}