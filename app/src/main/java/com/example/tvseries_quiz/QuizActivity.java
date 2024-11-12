package com.example.tvseries_quiz;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
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

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class QuizActivity extends AppCompatActivity {

    MediaPlayer mediaPlayerChoose, mediaPlayerFail, mediaPlayerNext, mediaPlayerBack, mediaPlayerRight;
    private TextView questions;
    private TextView question;

    private AppCompatButton option1, option2, option3, option4;
    private AppCompatButton nextBtn;

    private CountDownTimer quizTimer;

    private int seconds = 0;
    private int totalTimeInMins = 1;

    private List<QuestionsList> questionsLists;

    private int currentQuestionPosition = 0;

    private String selectedOptionByUser = "";

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

        mediaPlayerChoose=  MediaPlayer.create(this, R.raw.sound_choose);
        mediaPlayerFail =  MediaPlayer.create(this, R.raw.sound_fail);
        mediaPlayerNext =  MediaPlayer.create(this, R.raw.sound_next);
        mediaPlayerBack =  MediaPlayer.create(this, R.raw.sound_back);
        mediaPlayerRight =  MediaPlayer.create(this, R.raw.sound_right);

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

        startTimer(timer);

        questions.setText((currentQuestionPosition+1)+"/"+questionsLists.size());
        question.setText(questionsLists.get(0).getQuestion());
        option1.setText(questionsLists.get(0).getOption1());
        option2.setText(questionsLists.get(0).getOption2());
        option3.setText(questionsLists.get(0).getOption3());
        option4.setText(questionsLists.get(0).getOption4());

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizTimer.cancel();
                mediaPlayerBack.start();
                startActivity(new Intent(QuizActivity.this, MainActivity.class));
                finish();
            }
        });

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option1.getText().toString();
                    option1.setBackgroundResource(R.drawable.round_back_red);
                    option1.setTextColor(Color.WHITE);
                    revealAnswer();
                    questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                    soundForAnswerOption(selectedOptionByUser);
                }

            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option2.getText().toString();
                    option2.setBackgroundResource(R.drawable.round_back_red);
                    option2.setTextColor(Color.WHITE);
                    soundForAnswerOption(selectedOptionByUser);
                    revealAnswer();
                    questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }

            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option3.getText().toString();
                    option3.setBackgroundResource(R.drawable.round_back_red);
                    option3.setTextColor(Color.WHITE);
                    soundForAnswerOption(selectedOptionByUser);
                    revealAnswer();
                    questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }

            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option4.getText().toString();
                    option4.setBackgroundResource(R.drawable.round_back_red);
                    option4.setTextColor(Color.WHITE);
                    soundForAnswerOption(selectedOptionByUser);
                    revealAnswer();
                    questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }

            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selectedOptionByUser.isEmpty()){
                    mediaPlayerFail.start();
                    Toast.makeText(QuizActivity.this, "Сделайте выбор", Toast.LENGTH_SHORT).show();
                } else {
                    mediaPlayerNext.start();
                    changeNextQuestion();
                }

            }
        });

    }

    private void startTimer(final TextView timerTextView) {
        // Переводим минуты и секунды в миллисекунды для `CountDownTimer`
        long totalTimeInMillis = (totalTimeInMins * 60 + seconds) * 1000;

        quizTimer = new CountDownTimer(totalTimeInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // Обновляем оставшиеся минуты и секунды
                int minutes = (int) (millisUntilFinished / 1000) / 60;
                int seconds = (int) (millisUntilFinished / 1000) % 60;

                // Форматируем вывод в формате "MM:SS"
                String finalMinutes = String.valueOf(minutes);
                String finalSeconds = String.valueOf(seconds);

                if (finalMinutes.length() == 1) {
                    finalMinutes = "0" + finalMinutes;
                }
                if (finalSeconds.length() == 1) {
                    finalSeconds = "0" + finalSeconds;
                }

                timerTextView.setText(finalMinutes + ":" + finalSeconds);
            }

            @Override
            public void onFinish() {
                Toast.makeText(QuizActivity.this, "Время вышло", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(QuizActivity.this, QuizResults.class);
                intent.putExtra("correct", getCorrectAnswers());
                intent.putExtra("incorrect", getInCorrectAnswers());

                startActivity(intent);
                finish();
            }
        }.start();
    }


    private int getCorrectAnswers (){

        int correctAnswers = 0;

        for(int i = 0;i<questionsLists.size();i++){

            final String getUserSelectedAnswer = questionsLists.get(i).getUserSelectedAnswer();
            final String getAnswer = questionsLists.get(i).getAnswer();

            if(getUserSelectedAnswer.equals(getAnswer)){
                correctAnswers++;
            }

        }

        return correctAnswers;

    }

    private int getInCorrectAnswers (){

        int correctAnswers = 0;

        for(int i = 0;i<questionsLists.size();i++){

            final String getUserSelectedAnswer = questionsLists.get(i).getUserSelectedAnswer();
            final String getAnswer = questionsLists.get(i).getAnswer();

            if(!getUserSelectedAnswer.equals(getAnswer)){
                correctAnswers++;
            }

        }

        return correctAnswers;

    }

    private void revealAnswer(){

        final String getAnswer = questionsLists.get(currentQuestionPosition).getAnswer();
        if(option1.getText().toString().equals(getAnswer)){
            option1.setBackgroundResource(R.drawable.round_back_green10);
            option1.setTextColor(Color.WHITE);
        }
        else if(option2.getText().toString().equals(getAnswer)){
            option2.setBackgroundResource(R.drawable.round_back_green10);
            option2.setTextColor(Color.WHITE);
        }
        else if(option3.getText().toString().equals(getAnswer)){
            option3.setBackgroundResource(R.drawable.round_back_green10);
            option3.setTextColor(Color.WHITE);
        }
        else if(option4.getText().toString().equals(getAnswer)){
            option4.setBackgroundResource(R.drawable.round_back_green10);
            option4.setTextColor(Color.WHITE);
        }

    }

    private void changeNextQuestion(){
        currentQuestionPosition++;

        if((currentQuestionPosition+1) == questionsLists.size()){
            nextBtn.setText("Готово");
        }

        if(currentQuestionPosition < questionsLists.size()){
            selectedOptionByUser = "";

            option1.setBackgroundResource(R.drawable.round_back_white);
            option1.setTextColor(Color.parseColor("#000000"));

            option2.setBackgroundResource(R.drawable.round_back_white);
            option2.setTextColor(Color.parseColor("#000000"));

            option3.setBackgroundResource(R.drawable.round_back_white);
            option3.setTextColor(Color.parseColor("#000000"));

            option4.setBackgroundResource(R.drawable.round_back_white);
            option4.setTextColor(Color.parseColor("#000000"));

            questions.setText((currentQuestionPosition+1)+"/"+questionsLists.size());
            question.setText(questionsLists.get(currentQuestionPosition).getQuestion());
            option1.setText(questionsLists.get(currentQuestionPosition).getOption1());
            option2.setText(questionsLists.get(currentQuestionPosition).getOption2());
            option3.setText(questionsLists.get(currentQuestionPosition).getOption3());
            option4.setText(questionsLists.get(currentQuestionPosition).getOption4());
        }
        else{
            Intent intent = new Intent(QuizActivity.this, QuizResults.class);
            intent.putExtra("correct", getCorrectAnswers());
            intent.putExtra("incorrect", getInCorrectAnswers());


            startActivity(intent);
            finish();
        }
    }

    private void soundForAnswerOption(String selectedOptionByUser){

        final String getAnswer = questionsLists.get(currentQuestionPosition).getAnswer();

        if(selectedOptionByUser.equals(getAnswer)){
            mediaPlayerRight.start();
        } else {
            mediaPlayerFail.start();
        }
    }
//    @Override
//    public void onBackPressed() {
//        quizTimer.purge();
//        quizTimer.cancel();
//
//        startActivity(new Intent(QuizActivity.this, MainActivity.class));
//        finish();
//    }
}