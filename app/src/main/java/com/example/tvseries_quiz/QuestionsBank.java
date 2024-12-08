package com.example.tvseries_quiz;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class QuestionsBank {

    private static List<QuestionsList> generalEruditionQuestions(Context context) {

        final List<QuestionsList> questionsList = new ArrayList<>();

        questionsList.add(new QuestionsList(
                context.getString(R.string.question1_title),
                context.getString(R.string.question1_option1),
                context.getString(R.string.question1_option2),
                context.getString(R.string.question1_option3),
                context.getString(R.string.question1_option4),
                context.getString(R.string.question1_correct_answer),
                true
        ));

        questionsList.add(new QuestionsList(
                context.getString(R.string.question2_title),
                context.getString(R.string.question2_option1),
                context.getString(R.string.question2_option2),
                context.getString(R.string.question2_option3),
                context.getString(R.string.question2_option4),
                context.getString(R.string.question2_correct_answer),
                false
        ));

        questionsList.add(new QuestionsList(
                context.getString(R.string.question3_title),
                context.getString(R.string.question3_option1),
                context.getString(R.string.question3_option2),
                context.getString(R.string.question3_option3),
                context.getString(R.string.question3_option4),
                context.getString(R.string.question3_correct_answer),
                false
        ));

        questionsList.add(new QuestionsList(
                context.getString(R.string.question4_title),
                context.getString(R.string.question4_option1),
                context.getString(R.string.question4_option2),
                context.getString(R.string.question4_option3),
                context.getString(R.string.question4_option4),
                context.getString(R.string.question4_correct_answer),
                false
        ));

        questionsList.add(new QuestionsList(
                context.getString(R.string.question5_title),
                context.getString(R.string.question5_option1),
                context.getString(R.string.question5_option2),
                context.getString(R.string.question5_option3),
                context.getString(R.string.question5_option4),
                context.getString(R.string.question5_correct_answer),
                true
        ));

        questionsList.add(new QuestionsList(
                context.getString(R.string.question6_title),
                context.getString(R.string.question6_option1),
                context.getString(R.string.question6_option2),
                context.getString(R.string.question6_option3),
                context.getString(R.string.question6_option4),
                context.getString(R.string.question6_correct_answer),
                false
        ));

        questionsList.add(new QuestionsList(
                context.getString(R.string.question7_title),
                context.getString(R.string.question7_option1),
                context.getString(R.string.question7_option2),
                context.getString(R.string.question7_option3),
                context.getString(R.string.question7_option4),
                context.getString(R.string.question7_correct_answer),
                true
        ));

        questionsList.add(new QuestionsList(
                context.getString(R.string.question8_title),
                context.getString(R.string.question8_option1),
                context.getString(R.string.question8_option2),
                context.getString(R.string.question8_option3),
                context.getString(R.string.question8_option4),
                context.getString(R.string.question8_correct_answer),
                false
        ));

        questionsList.add(new QuestionsList(
                context.getString(R.string.question9_title),
                context.getString(R.string.question9_option1),
                context.getString(R.string.question9_option2),
                context.getString(R.string.question9_option3),
                context.getString(R.string.question9_option4),
                context.getString(R.string.question9_correct_answer),
                false
        ));

        questionsList.add(new QuestionsList(
                context.getString(R.string.question10_title),
                context.getString(R.string.question10_option1),
                context.getString(R.string.question10_option2),
                context.getString(R.string.question10_option3),
                context.getString(R.string.question10_option4),
                context.getString(R.string.question10_correct_answer),
                false
        ));

        return questionsList;
    }

    private static List<QuestionsList> filmQuestions(Context context){

        final List<QuestionsList> questionsList = new ArrayList<>();

        questionsList.add(new QuestionsList(
                context.getString(R.string.f_question1_title),
                context.getString(R.string.f_question1_option1),
                context.getString(R.string.f_question1_option2),
                context.getString(R.string.f_question1_option3),
                context.getString(R.string.f_question1_option4),
                context.getString(R.string.f_question1_correct_answer),
                false
        ));

        questionsList.add(new QuestionsList(
                context.getString(R.string.f_question2_title),
                context.getString(R.string.f_question2_option1),
                context.getString(R.string.f_question2_option2),
                context.getString(R.string.f_question2_option3),
                context.getString(R.string.f_question2_option4),
                context.getString(R.string.f_question2_correct_answer),
                false
        ));

        questionsList.add(new QuestionsList(
                context.getString(R.string.f_question3_title),
                context.getString(R.string.f_question3_option1),
                context.getString(R.string.f_question3_option2),
                context.getString(R.string.f_question3_option3),
                context.getString(R.string.f_question3_option4),
                context.getString(R.string.f_question3_correct_answer),
                false
        ));

        questionsList.add(new QuestionsList(
                context.getString(R.string.f_question4_title),
                context.getString(R.string.f_question4_option1),
                context.getString(R.string.f_question4_option2),
                context.getString(R.string.f_question4_option3),
                context.getString(R.string.f_question4_option4),
                context.getString(R.string.f_question4_correct_answer),
                true
        ));

        questionsList.add(new QuestionsList(
                context.getString(R.string.f_question5_title),
                context.getString(R.string.f_question5_option1),
                context.getString(R.string.f_question5_option2),
                context.getString(R.string.f_question5_option3),
                context.getString(R.string.f_question5_option4),
                context.getString(R.string.f_question5_correct_answer),
                false
        ));

        questionsList.add(new QuestionsList(
                context.getString(R.string.f_question6_title),
                context.getString(R.string.f_question6_option1),
                context.getString(R.string.f_question6_option2),
                context.getString(R.string.f_question6_option3),
                context.getString(R.string.f_question6_option4),
                context.getString(R.string.f_question6_correct_answer),
                false
        ));

        questionsList.add(new QuestionsList(
                context.getString(R.string.f_question7_title),
                context.getString(R.string.f_question7_option1),
                context.getString(R.string.f_question7_option2),
                context.getString(R.string.f_question7_option3),
                context.getString(R.string.f_question7_option4),
                context.getString(R.string.f_question7_correct_answer),
                false
        ));

        questionsList.add(new QuestionsList(
                context.getString(R.string.f_question8_title),
                context.getString(R.string.f_question8_option1),
                context.getString(R.string.f_question8_option2),
                context.getString(R.string.f_question8_option3),
                context.getString(R.string.f_question8_option4),
                context.getString(R.string.f_question8_correct_answer),
                false
        ));

        questionsList.add(new QuestionsList(
                context.getString(R.string.f_question9_title),
                context.getString(R.string.f_question9_option1),
                context.getString(R.string.f_question9_option2),
                context.getString(R.string.f_question9_option3),
                context.getString(R.string.f_question9_option4),
                context.getString(R.string.f_question9_correct_answer),
                false
        ));

        questionsList.add(new QuestionsList(
                context.getString(R.string.f_question10_title),
                context.getString(R.string.f_question10_option1),
                context.getString(R.string.f_question10_option2),
                context.getString(R.string.f_question10_option3),
                context.getString(R.string.f_question10_option4),
                context.getString(R.string.f_question10_correct_answer),
                false
        ));

        return questionsList;
    }

    private static List<QuestionsList> musicQuestions(Context context) {

        final List<QuestionsList> questionsList = new ArrayList<>();

        questionsList.add(new QuestionsList(
                context.getString(R.string.m_question1_title),
                context.getString(R.string.m_question1_option1),
                context.getString(R.string.m_question1_option2),
                context.getString(R.string.m_question1_option3),
                context.getString(R.string.m_question1_option4),
                context.getString(R.string.m_question1_correct_answer),
                false
        ));

        questionsList.add(new QuestionsList(
                context.getString(R.string.m_question2_title),
                context.getString(R.string.m_question2_option1),
                context.getString(R.string.m_question2_option2),
                context.getString(R.string.m_question2_option3),
                context.getString(R.string.m_question2_option4),
                context.getString(R.string.m_question2_correct_answer),
                false
        ));

        questionsList.add(new QuestionsList(
                context.getString(R.string.m_question3_title),
                context.getString(R.string.m_question3_option1),
                context.getString(R.string.m_question3_option2),
                context.getString(R.string.m_question3_option3),
                context.getString(R.string.m_question3_option4),
                context.getString(R.string.m_question3_correct_answer),
                false
        ));

        questionsList.add(new QuestionsList(
                context.getString(R.string.m_question4_title),
                context.getString(R.string.m_question4_option1),
                context.getString(R.string.m_question4_option2),
                context.getString(R.string.m_question4_option3),
                context.getString(R.string.m_question4_option4),
                context.getString(R.string.m_question4_correct_answer),
                false
        ));

        questionsList.add(new QuestionsList(
                context.getString(R.string.m_question5_title),
                context.getString(R.string.m_question5_option1),
                context.getString(R.string.m_question5_option2),
                context.getString(R.string.m_question5_option3),
                context.getString(R.string.m_question5_option4),
                context.getString(R.string.m_question5_correct_answer),
                false
        ));

        questionsList.add(new QuestionsList(
                context.getString(R.string.m_question6_title),
                context.getString(R.string.m_question6_option1),
                context.getString(R.string.m_question6_option2),
                context.getString(R.string.m_question6_option3),
                context.getString(R.string.m_question6_option4),
                context.getString(R.string.m_question6_correct_answer),
                false
        ));

        questionsList.add(new QuestionsList(
                context.getString(R.string.m_question7_title),
                context.getString(R.string.m_question7_option1),
                context.getString(R.string.m_question7_option2),
                context.getString(R.string.m_question7_option3),
                context.getString(R.string.m_question7_option4),
                context.getString(R.string.m_question7_correct_answer),
                false
        ));

        questionsList.add(new QuestionsList(
                context.getString(R.string.m_question8_title),
                context.getString(R.string.m_question8_option1),
                context.getString(R.string.m_question8_option2),
                context.getString(R.string.m_question8_option3),
                context.getString(R.string.m_question8_option4),
                context.getString(R.string.m_question8_correct_answer),
                false
        ));

        questionsList.add(new QuestionsList(
                context.getString(R.string.m_question9_title),
                context.getString(R.string.m_question9_option1),
                context.getString(R.string.m_question9_option2),
                context.getString(R.string.m_question9_option3),
                context.getString(R.string.m_question9_option4),
                context.getString(R.string.m_question9_correct_answer),
                false
        ));

        questionsList.add(new QuestionsList(
                context.getString(R.string.m_question10_title),
                context.getString(R.string.m_question10_option1),
                context.getString(R.string.m_question10_option2),
                context.getString(R.string.m_question10_option3),
                context.getString(R.string.m_question10_option4),
                context.getString(R.string.m_question10_correct_answer),
                false
        ));

        return questionsList;
    }

    private static List<QuestionsList> geographyQuestions(Context context) {

        final List<QuestionsList> questionsList = new ArrayList<>();

        questionsList.add(new QuestionsList(
                context.getString(R.string.g_question1_title),
                context.getString(R.string.g_question1_option1),
                context.getString(R.string.g_question1_option2),
                context.getString(R.string.g_question1_option3),
                context.getString(R.string.g_question1_option4),
                context.getString(R.string.g_question1_correct_answer),
                false
        ));

        questionsList.add(new QuestionsList(
                context.getString(R.string.g_question2_title),
                context.getString(R.string.g_question2_option1),
                context.getString(R.string.g_question2_option2),
                context.getString(R.string.g_question2_option3),
                context.getString(R.string.g_question2_option4),
                context.getString(R.string.g_question2_correct_answer),
                false
        ));

        questionsList.add(new QuestionsList(
                context.getString(R.string.g_question3_title),
                context.getString(R.string.g_question3_option1),
                context.getString(R.string.g_question3_option2),
                context.getString(R.string.g_question3_option3),
                context.getString(R.string.g_question3_option4),
                context.getString(R.string.g_question3_correct_answer),
                false
        ));

        questionsList.add(new QuestionsList(
                context.getString(R.string.g_question4_title),
                context.getString(R.string.g_question4_option1),
                context.getString(R.string.g_question4_option2),
                context.getString(R.string.g_question4_option3),
                context.getString(R.string.g_question4_option4),
                context.getString(R.string.g_question4_correct_answer),
                false
        ));

        questionsList.add(new QuestionsList(
                context.getString(R.string.g_question5_title),
                context.getString(R.string.g_question5_option1),
                context.getString(R.string.g_question5_option2),
                context.getString(R.string.g_question5_option3),
                context.getString(R.string.g_question5_option4),
                context.getString(R.string.g_question5_correct_answer),
                false
        ));

        questionsList.add(new QuestionsList(
                context.getString(R.string.g_question6_title),
                context.getString(R.string.g_question6_option1),
                context.getString(R.string.g_question6_option2),
                context.getString(R.string.g_question6_option3),
                context.getString(R.string.g_question6_option4),
                context.getString(R.string.g_question6_correct_answer),
                false
        ));

        questionsList.add(new QuestionsList(
                context.getString(R.string.g_question7_title),
                context.getString(R.string.g_question7_option1),
                context.getString(R.string.g_question7_option2),
                context.getString(R.string.g_question7_option3),
                context.getString(R.string.g_question7_option4),
                context.getString(R.string.g_question7_correct_answer),
                false
        ));

        questionsList.add(new QuestionsList(
                context.getString(R.string.g_question8_title),
                context.getString(R.string.g_question8_option1),
                context.getString(R.string.g_question8_option2),
                context.getString(R.string.g_question8_option3),
                context.getString(R.string.g_question8_option4),
                context.getString(R.string.g_question8_correct_answer),
                false
        ));

        questionsList.add(new QuestionsList(
                context.getString(R.string.g_question9_title),
                context.getString(R.string.g_question9_option1),
                context.getString(R.string.g_question9_option2),
                context.getString(R.string.g_question9_option3),
                context.getString(R.string.g_question9_option4),
                context.getString(R.string.g_question9_correct_answer),
                false
        ));

        questionsList.add(new QuestionsList(
                context.getString(R.string.g_question10_title),
                context.getString(R.string.g_question10_option1),
                context.getString(R.string.g_question10_option2),
                context.getString(R.string.g_question10_option3),
                context.getString(R.string.g_question10_option4),
                context.getString(R.string.g_question10_correct_answer),
                false
        ));

        return questionsList;
    }

    public static List<QuestionsList> getQuestions (Context context, String selectedTopicName){
        switch(selectedTopicName){
            case "Общая эрудиция": return generalEruditionQuestions(context);
            case "Кино и телевидение": return filmQuestions(context);
            case "Музыка": return musicQuestions(context);
            default: return geographyQuestions(context);
        }
    }

}
