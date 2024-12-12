package com.example.tvseries_quiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TicketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        TextView ticketTitleView = findViewById(R.id.ticketTitleView);
        TextView ticketTextView = findViewById(R.id.ticketTextView);
        Button backBtn = findViewById(R.id.backBtnLearn);

        String ticketTitle = getIntent().getStringExtra("ticketTitle");
        String ticketText = getIntent().getStringExtra("ticketText");

        ticketTitleView.setText(ticketTitle);
        ticketTextView.setText(ticketText);

        backBtn.setOnClickListener(v -> {
            Intent intent = new Intent(TicketActivity.this, LearnTicketsActivity.class);
            startActivity(intent);
            finish(); // Закрыть текущую активити
        });
    }
}