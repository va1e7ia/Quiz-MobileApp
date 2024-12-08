package com.example.tvseries_quiz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import android.widget.Button;
import android.widget.LinearLayout;

import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
//import androidx.annotation.NonNull;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//import android.widget.TextView;
//import android.util.Log;
//import android.view.View;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayerChoose, mediaPlayerFail, mediaPlayerNext;

    private String selectedTopic = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        FirebaseApp.initializeApp(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //ПЕРЕХОД НА ЭКРАН ЛОГИНА ЕСЛИ ПОЛЬЗОВАТЕЛЬ НЕ АВТОРИЗОВАН
        if(FirebaseAuth.getInstance().getCurrentUser()==null){
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }


        // КНОПКА ВЫХОДА ИЗ АККАУНТА
        Button logoutBtn = findViewById(R.id.logoutBtn);

        logoutBtn.setOnClickListener(v -> {
                FirebaseAuth.getInstance().signOut(); // Выход из текущей сессии
                startActivity(new Intent(MainActivity.this, LoginActivity.class)); // Переход на экран логина
                finish(); // Закрытие MainActivity
        });

        mediaPlayerChoose = MediaPlayer.create(this, R.raw.sound_choose);
        mediaPlayerFail=MediaPlayer.create(this, R.raw.sound_fail);
        mediaPlayerNext=MediaPlayer.create(this, R.raw.sound_next);

        final LinearLayout generalErudition = findViewById(R.id.generalEruditionLayout);
        final LinearLayout film = findViewById(R.id.filmLayout);
        final LinearLayout music = findViewById(R.id.musicLayout);
        final LinearLayout geography = findViewById(R.id.geographyLayout);

        final Button startQuizBtn = findViewById(R.id.startQuizBtn);

        //НАЖАТИЕ НА ОБЩУЮ ЭРУДИЦИЮ
        generalErudition.setOnClickListener(v -> {
                selectedTopic = "Общая эрудиция";
                generalErudition.setBackgroundResource(R.drawable.round_back_white_stroke);

                film.setBackgroundResource(R.drawable.round_back_white);
                music.setBackgroundResource(R.drawable.round_back_white);
                geography.setBackgroundResource(R.drawable.round_back_white);

                mediaPlayerChoose.start();
        });

        //НАЖАТИЕ НА ФИЛЬМ
        film.setOnClickListener(v -> {
                selectedTopic = "Кино и телевидение";
                film.setBackgroundResource(R.drawable.round_back_white_stroke);

                generalErudition.setBackgroundResource(R.drawable.round_back_white);
                music.setBackgroundResource(R.drawable.round_back_white);
                geography.setBackgroundResource(R.drawable.round_back_white);
                mediaPlayerChoose.start();
        });

        //НАЖАТИЕ НА МУЗЫКУ
        music.setOnClickListener(v -> {
                selectedTopic = "Музыка";
                music.setBackgroundResource(R.drawable.round_back_white_stroke);

                generalErudition.setBackgroundResource(R.drawable.round_back_white);
                film.setBackgroundResource(R.drawable.round_back_white);
                geography.setBackgroundResource(R.drawable.round_back_white);
                mediaPlayerChoose.start();
        });

        //НАЖАТИЕ НА ГЕОГРАФИЮ
        geography.setOnClickListener(v -> {
                selectedTopic = "География";
                geography.setBackgroundResource(R.drawable.round_back_white_stroke);

                generalErudition.setBackgroundResource(R.drawable.round_back_white);
                film.setBackgroundResource(R.drawable.round_back_white);
                music.setBackgroundResource(R.drawable.round_back_white);
                mediaPlayerChoose.start();
        });

        startQuizBtn.setOnClickListener(v -> {

                if (selectedTopic.isEmpty()) {
                    mediaPlayerFail.start();
                    Toast.makeText(MainActivity.this, "Выберите викторину", Toast.LENGTH_SHORT).show();
                } else {
                    mediaPlayerNext.start();
                    Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                    intent.putExtra("selectedTopic", selectedTopic);
                    startActivity(intent);
                    finish();
                }
        });
    }
}