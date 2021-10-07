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
            e.append(firstInstance.toString());
            //Making deep copy from player 1 perspective
            GameState secondInstance = new GameState(firstInstance);

            //Printing out gamestate to the text box
            e.setText(secondInstance.toString());

        }
    }
}