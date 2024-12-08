package com.example.tvseries_quiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    private EditText emailId;
    private EditText passId;
    private EditText userId;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mAuth = FirebaseAuth.getInstance();

        emailId = findViewById(R.id.emailId);
        passId = findViewById(R.id.passId);
        userId = findViewById(R.id.userId);
        Button registerBtn = findViewById(R.id.registerBtn);

        registerBtn.setOnClickListener(v-> {
                String email = emailId.getText().toString();
                String password = passId.getText().toString();
                String username = userId.getText().toString();

                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(getApplicationContext(), "Неверный формат электронной почты", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Пароль должен содержать не менее 6 символов", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (email.isEmpty() || password.isEmpty() || username.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Поля не могут быть пустыми", Toast.LENGTH_SHORT).show();
                } else {
                    // Создание пользователя
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(task -> {
                                if (task.isSuccessful()) {
                                    // Регистрация успешна
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    if (user != null) {

                                        // Получение ссылки на базу данных с указанием региона
                                        FirebaseDatabase database = FirebaseDatabase.getInstance("https://androidquiz-534e9-default-rtdb.europe-west1.firebasedatabase.app");
                                        DatabaseReference userRef = database.getReference("Users");
                                        // Сохранение информации о пользователе в Firebase Database
                                        HashMap<String, String> userInfo = new HashMap<>();
                                        userInfo.put("email", email);
                                        userInfo.put("username", username);
                                        // Запись данных в Realtime Database
                                        userRef.child(user.getUid()).setValue(userInfo)
                                                .addOnCompleteListener(saveTask -> {
                                                    if (saveTask.isSuccessful()) {
                                                        Toast.makeText(getApplicationContext(), "Пользователь успешно зарегистрирован", Toast.LENGTH_SHORT).show();
                                                        startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                                                        finish(); // Закрыть RegisterActivity
                                                    } else {
                                                        Toast.makeText(getApplicationContext(), "Не удалось сохранить информацию о пользователе", Toast.LENGTH_SHORT).show();
                                                    }
                                                });
                                    }
                                } else {
                                    Toast.makeText(getApplicationContext(), "Регистрация не удалась: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
                }
        });
    }
}