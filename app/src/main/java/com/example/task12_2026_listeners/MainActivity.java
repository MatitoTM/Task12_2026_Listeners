package com.example.task12_2026_listeners;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * מסך המשחק הראשי של האפליקציה.
 * מנהל את צבירת הנקודות של השחקן הכחול (לחיצה קצרה) ושל השחקן האדום (לחיצה ארוכה),
 * ומעביר את הנתונים למסך התוצאות בסיום המשחק.
 */

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {

    Button blueBtn;
    Button redBtn;

    int blueScore;
    int redScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blueBtn = findViewById(R.id.blueBtn);
        redBtn = findViewById(R.id.redBtn);

        blueScore = 0;
        redScore = 0;


        blueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                blueScore++;
            }
        });

        redBtn.setOnLongClickListener(this);
    }

    /**
     * מופעלת בכל פעם שמסך המשחק חוזר לקדמת התצוגה (למשל בעת חזרה ממסך התוצאות).
     * מאפסת את תוצאות שני השחקנים לקראת סבב משחק חדש.
     */
    @Override
    protected void onResume() {
        super.onResume();

        blueScore = 0;
        redScore = 0;
    }

    /**
     * מטפלת באירוע של לחיצה ארוכה על הלחצן האדום (מימוש ממשק {@link View.OnLongClickListener}).
     * מוסיפה נקודות לשחקן האדום בעת לחיצה ממושכת.
     */
    @Override
    public boolean onLongClick(View view) {
        redScore += 2;
        return false;
    }

    /**
     * מעבירה את המשתמש למסך התוצאות ({@link EndGameActivity})
     * ושולחת אליו את הניקוד הסופי של שני השחקנים באמצעות {@link Intent}.
     */
    public void endGame(View view) {
        Intent si = new Intent(this, EndGameActivity.class);
        si.putExtra("blueScore", blueScore);
        si.putExtra("redScore", redScore);
        startActivity(si);
    }
}