package com.example.tvseries_quiz;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QuizActivity extends AppCompatActivity {

    MediaPlayer mediaPlayerChoose, mediaPlayerFail, mediaPlayerNext, mediaPlayerBack, mediaPlayerRight;
    private TextView questions, question;
    private AppCompatButton option1, option2, option3, option4, nextBtn;
    private CountDownTimer quizTimer;
    private int seconds = 0;
    private int totalTimeInMins = 1;

    private List<QuestionsList> questionsLists;
    private int currentQuestionPosition = 0;
    private List<String> selectedOptionsByUser = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final ImageView backBtn = findViewById(R.id.backBtn);
        final TextView timer = findViewById(R.id.timer);
        final TextView selectedTopicName = findViewById(R.id.selectedTopicName);

        mediaPlayerChoose = MediaPlayer.create(this, R.raw.sound_choose);
        mediaPlayerFail = MediaPlayer.create(this, R.raw.sound_fail);
        mediaPlayerNext = MediaPlayer.create(this, R.raw.sound_next);
        mediaPlayerBack = MediaPlayer.create(this, R.raw.sound_back);
        mediaPlayerRight = MediaPlayer.create(this, R.raw.sound_right);

        questions = findViewById(R.id.questions);
        question = findViewById(R.id.question);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        nextBtn = findViewById(R.id.nextBtn);

        final String getSelectedTopic = getIntent().getStringExtra("selectedTopic");
        selectedTopicName.setText(getSelectedTopic);

        questionsLists = QuestionsBank.qetQuestions(getSelectedTopic);



        loadQuestion();

        backBtn.setOnClickListener(v -> {
            quizTimer.cancel();
            mediaPlayerBack.start();
            startActivity(new Intent(QuizActivity.this, MainActivity.class));
            finish();
        });

        option1.setOnClickListener(v -> handleOptionSelection(option1));
        option2.setOnClickListener(v -> handleOptionSelection(option2));
        option3.setOnClickListener(v -> handleOptionSelection(option3));
        option4.setOnClickListener(v -> handleOptionSelection(option4));

        nextBtn.setOnClickListener(v -> {
            if (questionsLists.get(currentQuestionPosition).isMultipleChoice() && selectedOptionsByUser.isEmpty()) {
                mediaPlayerFail.start();
                Toast.makeText(QuizActivity.this, "Выберите хотя бы один вариант", Toast.LENGTH_SHORT).show();
            } else if (!questionsLists.get(currentQuestionPosition).isMultipleChoice() && selectedOptionsByUser.isEmpty()) {
                mediaPlayerFail.start();
                Toast.makeText(QuizActivity.this, "Сделайте выбор", Toast.LENGTH_SHORT).show();
            } else {
                mediaPlayerNext.start();
                saveUserAnswers();
                changeNextQuestion();
            }
        });
    }

    private void loadQuestion() {
        QuestionsList currentQuestion = questionsLists.get(currentQuestionPosition);

        selectedOptionsByUser.clear();

        questions.setText((currentQuestionPosition + 1) + "/" + questionsLists.size());
        question.setText(currentQuestion.getQuestion());
        option1.setText(currentQuestion.getOption1());
        option2.setText(currentQuestion.getOption2());
        option3.setText(currentQuestion.getOption3());
        option4.setText(currentQuestion.getOption4());

        resetOptionStyles();
    }

    private void handleOptionSelection(AppCompatButton option) {
        String selectedOption = option.getText().toString();
        QuestionsList currentQuestion = questionsLists.get(currentQuestionPosition);

        if (currentQuestion.isMultipleChoice()) {
            if (selectedOptionsByUser.contains(selectedOption)) {
                // Убираем вариант, если он уже был выбран
                selectedOptionsByUser.remove(selectedOption);
                option.setBackgroundResource(R.drawable.round_back_white);
                option.setTextColor(Color.BLACK);
            } else {
                // Добавляем вариант в список выбранных
                selectedOptionsByUser.add(selectedOption);
                option.setBackgroundResource(R.drawable.round_back_red);
                option.setTextColor(Color.WHITE);
            }
        } else {
            if (selectedOptionsByUser.isEmpty()) {
                // Для одиночного выбора, просто выделяем первый вариант
                selectedOptionsByUser.add(selectedOption);
                option.setBackgroundResource(R.drawable.round_back_red);
                option.setTextColor(Color.WHITE);
                revealAnswer();
            }
        }

        // После выбора вариантов, подсвечиваем правильные ответы
        revealAnswer();
    }

    private void saveUserAnswers() {
        QuestionsList currentQuestion = questionsLists.get(currentQuestionPosition);

        if (currentQuestion.isMultipleChoice()) {
            currentQuestion.setUserSelectedAnswers(new ArrayList<>(selectedOptionsByUser));
        } else if (!selectedOptionsByUser.isEmpty()) {
            currentQuestion.setUserSelectedAnswer(selectedOptionsByUser.get(0));
        }
    }

    private void revealAnswer() {
        QuestionsList currentQuestion = questionsLists.get(currentQuestionPosition);
        String correctAnswer = currentQuestion.getAnswer();  // Правильный ответ для одиночного выбора
        List<String> correctAnswers = currentQuestion.getCorrectAnswers();  // Для множественного выбора

        // Для одиночного выбора
        if (!currentQuestion.isMultipleChoice()) {
            if (option1.getText().toString().equals(correctAnswer)) {
                option1.setBackgroundResource(R.drawable.round_back_green10);
                option1.setTextColor(Color.WHITE);
            } else {
                option1.setBackgroundResource(R.drawable.round_back_red);
                option1.setTextColor(Color.WHITE);
            }

            if (option2.getText().toString().equals(correctAnswer)) {
                option2.setBackgroundResource(R.drawable.round_back_green10);
                option2.setTextColor(Color.WHITE);
            } else {
                option2.setBackgroundResource(R.drawable.round_back_red);
                option2.setTextColor(Color.WHITE);
            }

            if (option3.getText().toString().equals(correctAnswer)) {
                option3.setBackgroundResource(R.drawable.round_back_green10);
                option3.setTextColor(Color.WHITE);
            } else {
                option3.setBackgroundResource(R.drawable.round_back_red);
                option3.setTextColor(Color.WHITE);
            }

            if (option4.getText().toString().equals(correctAnswer)) {
                option4.setBackgroundResource(R.drawable.round_back_green10);
                option4.setTextColor(Color.WHITE);
            } else {
                option4.setBackgroundResource(R.drawable.round_back_red);
                option4.setTextColor(Color.WHITE);
            }
        } else {
            // Для множественного выбора
            // Если правильный, подсвечиваем зеленым, если неправильный, красным
            if (correctAnswers.contains(option1.getText().toString())) {
                option1.setBackgroundResource(R.drawable.round_back_green10);
                option1.setTextColor(Color.WHITE);
            } else if (option1.getText().toString().equals(selectedOptionsByUser)) {
                option1.setBackgroundResource(R.drawable.round_back_red);
                option1.setTextColor(Color.WHITE);
            }

            if (correctAnswers.contains(option2.getText().toString())) {
                option2.setBackgroundResource(R.drawable.round_back_green10);
                option2.setTextColor(Color.WHITE);
            } else if (option2.getText().toString().equals(selectedOptionsByUser)) {
                option2.setBackgroundResource(R.drawable.round_back_red);
                option2.setTextColor(Color.WHITE);
            }

            if (correctAnswers.contains(option3.getText().toString())) {
                option3.setBackgroundResource(R.drawable.round_back_green10);
                option3.setTextColor(Color.WHITE);
            } else if (option3.getText().toString().equals(selectedOptionsByUser)) {
                option3.setBackgroundResource(R.drawable.round_back_red);
                option3.setTextColor(Color.WHITE);
            }

            if (correctAnswers.contains(option4.getText().toString())) {
                option4.setBackgroundResource(R.drawable.round_back_green10);
                option4.setTextColor(Color.WHITE);
            } else if (option4.getText().toString().equals(selectedOptionsByUser)) {
                option4.setBackgroundResource(R.drawable.round_back_red);
                option4.setTextColor(Color.WHITE);
            }
        }
    }









    private void changeNextQuestion() {
        currentQuestionPosition++;
        if (currentQuestionPosition < questionsLists.size()) {
            loadQuestion();
        } else {
            navigateToResults();
        }
    }

    private void navigateToResults() {
        Intent intent = new Intent(QuizActivity.this, QuizResults.class);
        intent.putExtra("correct", getCorrectAnswers());
        intent.putExtra("incorrect", getInCorrectAnswers());
        startActivity(intent);
        finish();
    }

    private int getCorrectAnswers() {
        int correctAnswers = 0;
        for (QuestionsList question : questionsLists) {
            if (question.isMultipleChoice()) {
                // Получаем правильные ответы, разделяя строку по запятой и очищая пробелы
                Set<String> correctAnswerSet = new HashSet<>();
                for (String answer : question.getAnswer().split(",")) {
                    correctAnswerSet.add(answer.trim());  // Убираем пробелы
                }

                // Получаем выбранные пользователем ответы, очищая пробелы
                Set<String> userAnswerSet = new HashSet<>();
                for (String userAnswer : question.getUserSelectedAnswers()) {
                    userAnswerSet.add(userAnswer.trim());  // Убираем пробелы
                }

                // Логирование для отладки
                Log.d("Correct Answers", "Correct Answers: " + correctAnswerSet.toString());
                Log.d("User Answers", "User Answers: " + userAnswerSet.toString());

                // Сравниваем множества
                if (correctAnswerSet.equals(userAnswerSet)) {
                    correctAnswers++;
                }
            } else {
                // Для вопросов с одним правильным ответом
                if (question.getAnswer().equals(question.getUserSelectedAnswer())) {
                    correctAnswers++;
                }
            }
        }
        return correctAnswers;
    }



    private int getInCorrectAnswers() {
        return questionsLists.size() - getCorrectAnswers();
    }

    private void resetOptionStyles() {
        option1.setBackgroundResource(R.drawable.round_back_white);
        option1.setTextColor(Color.BLACK);

        option2.setBackgroundResource(R.drawable.round_back_white);
        option2.setTextColor(Color.BLACK);

        option3.setBackgroundResource(R.drawable.round_back_white);
        option3.setTextColor(Color.BLACK);

        option4.setBackgroundResource(R.drawable.round_back_white);
        option4.setTextColor(Color.BLACK);
    }
}
