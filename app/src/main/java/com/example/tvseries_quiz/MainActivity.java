package com.example.tvseries_quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private String selectedTopic = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        final LinearLayout generalErudition = findViewById(R.id.generalEruditionLayout);
        final LinearLayout film = findViewById(R.id.filmLayout);
        final LinearLayout music = findViewById(R.id.musicLayout);
        final LinearLayout geography = findViewById(R.id.geographyLayout);

        final Button startQuizBtn = findViewById(R.id.startQuizBtn);

        //НАЖАТИЕ НА ОБЩУЮ ЭРУДИЦИЮ
        generalErudition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedTopic = "generalErudition";
                generalErudition.setBackgroundResource(R.drawable.round_back_white_stroke);

                film.setBackgroundResource(R.drawable.round_back_white);
                music.setBackgroundResource(R.drawable.round_back_white);
                geography.setBackgroundResource(R.drawable.round_back_white);


            }
        });

        //НАЖАТИЕ НА ФИЛЬМ
        film.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedTopic = "film";
                film.setBackgroundResource(R.drawable.round_back_white_stroke);

                generalErudition.setBackgroundResource(R.drawable.round_back_white);
                music.setBackgroundResource(R.drawable.round_back_white);
                geography.setBackgroundResource(R.drawable.round_back_white);

            }
        });

        //НАЖАТИЕ НА МУЗЫКУ
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedTopic = "music";
                music.setBackgroundResource(R.drawable.round_back_white_stroke);

                generalErudition.setBackgroundResource(R.drawable.round_back_white);
                film.setBackgroundResource(R.drawable.round_back_white);
                geography.setBackgroundResource(R.drawable.round_back_white);

            }
        });

        //НАЖАТИЕ НА ГЕОГРАФИЮ
        geography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedTopic = "geography";
                geography.setBackgroundResource(R.drawable.round_back_white_stroke);

                generalErudition.setBackgroundResource(R.drawable.round_back_white);
                film.setBackgroundResource(R.drawable.round_back_white);
                music.setBackgroundResource(R.drawable.round_back_white);

            }
        });

        startQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (selectedTopic.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Выберите викторину", Toast.LENGTH_SHORT).show();
                } else {

                    Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                    intent.putExtra("selectedTopic", selectedTopic);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}