package com.example.tvseries_quiz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class QuizResults extends AppCompatActivity {

    MediaPlayer mediaPlayerNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz_results);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mediaPlayerNext = MediaPlayer.create(this, R.raw.sound_next);

        final AppCompatButton startNewQuiz = findViewById(R.id.startNewQuizBtn);
        final TextView correctAnswers = findViewById(R.id.correctAnswers);
        final TextView inCorrectAnswers = findViewById(R.id.inCorrectAnswers);

        final int getCorrectAnswers = getIntent().getIntExtra("correct", 0);
        final int getInCorrectAnswers = getIntent().getIntExtra("incorrect", 0);

        correctAnswers.setText(getString(R.string.correct_answers_display, getCorrectAnswers));
        inCorrectAnswers.setText(getString(R.string.incorrect_answers_display, getInCorrectAnswers));

        startNewQuiz.setOnClickListener(v-> {
                mediaPlayerNext.start();
                startActivity(new Intent(QuizResults.this, MainActivity.class));
                finish();
        });

        AppCompatButton shareResultsBtn = findViewById(R.id.shareResultsBtn);
        shareResultsBtn.setOnClickListener(v -> {
            String shareText = "Я прошел квиз! Правильные ответы: " + getCorrectAnswers + ", Неправильные ответы: " + getInCorrectAnswers;
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);
            startActivity(Intent.createChooser(shareIntent, "Поделиться результатами"));
        });

        correctAnswers.setAlpha(0f);
        correctAnswers.animate().alpha(1f).setDuration(1000);

        inCorrectAnswers.setAlpha(0f);
        inCorrectAnswers.animate().alpha(1f).setDuration(1000);

    }
}