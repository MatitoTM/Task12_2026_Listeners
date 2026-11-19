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

/**
 * מסך התוצאות של המשחק.
 * מציג את הניקוד הסופי של כל אחד מהשחקנים בשתי חלוניות נפרדות,
 * מכריז על המנצח (או על תיקו) ומאפשר חזרה למסך המשחק תוך איפוס הנתונים.
 */
public class EndGameActivity extends AppCompatActivity {

    TextView tvBlueScore, tvRedScore, tvWinner;

    int blueScore;
    int redScore;

    /**
     * מאתחלת את מסך התוצאות, שולפת את נתוני הניקוד מתוך ה-{@link Intent} שהתקבל,
     * מציגה אותם בחלוניות המתאימות וקובעת את הודעת המנצח וצבעה בהתאם לתוצאה.
     */
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

    /**
     * סוגרת את מסך התוצאות ומחזירה את המשתמש למסך המשחק הראשי,
     * פעולה המפעילה מחדש את {@code onResume()} ומאפסת את תוצאות השחקנים.
     */
    public void returnToGame(View view) {
        finish();
    }
}