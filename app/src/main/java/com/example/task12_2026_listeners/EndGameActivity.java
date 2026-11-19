package com.example.task12_2026_listeners;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class EndGameActivity extends AppCompatActivity {

    TextView tvBlueScore, tvRedScore, tvWinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        tvBlueScore = findViewById(R.id.tvBlueScore);
        tvRedScore = findViewById(R.id.tvRedScore);
        tvWinner = findViewById(R.id.tvWinner);

    }
}