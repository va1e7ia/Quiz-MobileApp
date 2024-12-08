package com.example.tvseries_quiz;

import java.util.ArrayList;
import java.util.List;

public class QuestionsList {

    private final String question;
    private final String option1;
    private final String option2;
    private final String option3;
    private final String option4;
    private final String answer;
    private String userSelectedAnswer;
    private final boolean isMultipleChoice;
    private List<String> userSelectedAnswers;

    private List<String> correctAnswers;

    // Конструктор
    public QuestionsList(String question, String option1, String option2, String option3, String option4, String answer, boolean isMultipleChoice) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = answer;
        this.isMultipleChoice = isMultipleChoice;
        this.userSelectedAnswers = new ArrayList<>();

        if (isMultipleChoice) {
            correctAnswers = new ArrayList<>();
            if (option1.equals(answer)) {
                correctAnswers.add(option1);
            }
            if (option2.equals(answer)) {
                correctAnswers.add(option2);
            }
            if (option3.equals(answer)) {
                correctAnswers.add(option3);
            }
            if (option4.equals(answer)) {
                correctAnswers.add(option4);
            }
        }
    }

    // Геттеры и сеттеры
    public String getQuestion() {
        return question;
    }

//    public void setQuestion(String question) {
//        this.question = question;
//    }

    public String getOption1() {
        return option1;
    }

//    public void setOption1(String option1) {
//        this.option1 = option1;
//    }

    public String getOption2() {
        return option2;
    }

//    public void setOption2(String option2) {
//        this.option2 = option2;
//    }

    public String getOption3() {
        return option3;
    }

//    public void setOption3(String option3) {
//        this.option3 = option3;
//    }

    public String getOption4() {
        return option4;
    }

//    public void setOption4(String option4) {
//        this.option4 = option4;
//    }

    public String getAnswer() {
        return answer;
    }

//    public void setAnswer(String answer) {
//        this.answer = answer;
//    }

    public String getUserSelectedAnswer() {
        return userSelectedAnswer;
    }

    public void setUserSelectedAnswer(String userSelectedAnswer) {
        this.userSelectedAnswer = userSelectedAnswer;
    }

    public boolean isMultipleChoice() {
        return isMultipleChoice;
    }

//    public void setMultipleChoice(boolean multipleChoice) {
//        isMultipleChoice = multipleChoice;
//    }

    public List<String> getUserSelectedAnswers() {
        return userSelectedAnswers;
    }

    public void setUserSelectedAnswers(List<String> userSelectedAnswers) {
        this.userSelectedAnswers = userSelectedAnswers;
    }

    public List<String> getCorrectAnswers() {
        return correctAnswers;
    }
}
