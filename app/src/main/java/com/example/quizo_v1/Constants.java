package com.example.quizo_v1;

import java.util.ArrayList;

public class Constants {

    public static final String QUIZ_NUMBER = "quiz_number";
    public static final String total_questions = "total_questions";
    public static final String correct_answers ="correct_answers";
    public static final String QUIZ_NAME = "quiz_name";
    public static final String TIMER = "timer";
    public static final String FORCE_TIMER = "force_timer";
    public static final String MAX_TIME = "max_time";
    public static final String USE_TIMER ="use_timer";

    private static ArrayList<Quiz> quizArrayList = new ArrayList<Quiz>();

    private static MainSettings settings = new MainSettings(true);

    public static void setQuizArrayList(ArrayList<Quiz> quizArrayList) {
        Constants.quizArrayList = quizArrayList;
    }

    public static ArrayList<Quiz> getQuizArrayList() {
        return quizArrayList;
    }

    public static void addQuiz(Quiz quiz) {
        quizArrayList.add(quiz);
    }

    public static Quiz getQuiz(int i) {
        return quizArrayList.get(i);
    }

    public static MainSettings getSettings() {
        return settings;
    }

    public static void setSettings(MainSettings settings) {
        Constants.settings = settings;
    }
}
