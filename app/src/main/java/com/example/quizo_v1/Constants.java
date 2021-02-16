package com.example.quizo_v1;

import java.util.ArrayList;

public class Constants {

    public static final String QUIZ_NUMBER = "quiz_number";
    public static final String user_name = "user_name";
    public static final String total_questions = "total_questions";
    public static final String correct_answers ="correct_answers";
    public static final String QUIZ_NAME = "quiz_name";
    public static final String TIMER = "timer";

    private static ArrayList<Quiz> quizArrayList = new ArrayList<Quiz>();
    private static String userName;

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

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        Constants.userName = userName;
    }
}
