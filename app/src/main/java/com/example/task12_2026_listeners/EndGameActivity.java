package com.example.task12_2026_listeners;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class EndGameActivity extends AppCompatActivity {

    TextView tvBlueScore, tvRedScore, tvWinner;

    int blueScore;
    int redScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        Intent gi = getIntent();
        blueScore = gi.getIntExtra("blueScore",-1);
        redScore = gi.getIntExtra("redScore",-1);

        tvBlueScore = findViewById(R.id.tvBlueScore);
        tvRedScore = findViewById(R.id.tvRedScore);
        tvWinner = findViewById(R.id.tvWinner);

        tvBlueScore.setText("Blue\n" + blueScore);
        tvRedScore.setText("Red\n" + redScore);

        if (blueScore > redScore) {
            tvWinner.setText("Blue is the Winner!");
            tvWinner.setTextColor(Color.parseColor("#1565C0"));
        }
        else if (blueScore < redScore){
            tvWinner.setText("Red is the Winner!");
            tvWinner.setTextColor(Color.parseColor("#C62828"));
        }
        else {
            tvWinner.setText("Its a Tie!");
        }


    }

    public void returnToGame(View view) {
        finish();
    }
}