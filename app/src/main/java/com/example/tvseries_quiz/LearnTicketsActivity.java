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

public class LearnTicketsActivity extends AppCompatActivity {

    private String selectedTicketTitle = "";
    private String selectedTicketText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_learn_tickets);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final LinearLayout learnTicket1 = findViewById(R.id.learn_1);
        final LinearLayout learnTicket2 = findViewById(R.id.learn_2);
        final LinearLayout learnTicket3 = findViewById(R.id.learn_3);
        final LinearLayout learnTicket4 = findViewById(R.id.learn_4);



        final Button startLearn = findViewById(R.id.startTicket);

        learnTicket1.setOnClickListener(v -> {
            selectedTicketTitle = getString(R.string.ticket1_title);
            selectedTicketText = getString(R.string.ticket1_text);
            learnTicket1.setBackgroundResource(R.drawable.round_back_white_stroke);
            learnTicket2.setBackgroundResource(R.drawable.round_back_white);
            learnTicket3.setBackgroundResource(R.drawable.round_back_white);
            learnTicket4.setBackgroundResource(R.drawable.round_back_white);
        });

        learnTicket2.setOnClickListener(v -> {
            selectedTicketTitle = getString(R.string.ticket2_title);
            selectedTicketText = getString(R.string.ticket2_text);
            learnTicket2.setBackgroundResource(R.drawable.round_back_white_stroke);
            learnTicket1.setBackgroundResource(R.drawable.round_back_white);
            learnTicket3.setBackgroundResource(R.drawable.round_back_white);
            learnTicket4.setBackgroundResource(R.drawable.round_back_white);
        });

        learnTicket3.setOnClickListener(v -> {
            selectedTicketTitle = getString(R.string.ticket3_title);
            selectedTicketText = getString(R.string.ticket3_text);
            learnTicket3.setBackgroundResource(R.drawable.round_back_white_stroke);
            learnTicket1.setBackgroundResource(R.drawable.round_back_white);
            learnTicket2.setBackgroundResource(R.drawable.round_back_white);
            learnTicket4.setBackgroundResource(R.drawable.round_back_white);
        });

        learnTicket4.setOnClickListener(v -> {
            selectedTicketTitle = getString(R.string.ticket4_title);
            selectedTicketText = getString(R.string.ticket4_text);
            learnTicket4.setBackgroundResource(R.drawable.round_back_white_stroke);
            learnTicket1.setBackgroundResource(R.drawable.round_back_white);
            learnTicket3.setBackgroundResource(R.drawable.round_back_white);
            learnTicket2.setBackgroundResource(R.drawable.round_back_white);
        });

        startLearn.setOnClickListener(v -> {
            if (selectedTicketTitle.isEmpty()) {
                Toast.makeText(LearnTicketsActivity.this, "Выберите билет для изучения!", Toast.LENGTH_SHORT).show();
            }  else {
                Intent intent = new Intent(LearnTicketsActivity.this, TicketActivity.class);
                intent.putExtra("ticketTitle", selectedTicketTitle);
                intent.putExtra("ticketText", selectedTicketText); // Передаём основной текст
                startActivity(intent);
                finish();
            }
        });


        // Установка обработчика для кнопки "Назад"
        Button backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Закрывает текущее активити
            }
        });
    }
}