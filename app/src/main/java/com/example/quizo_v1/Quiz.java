package com.example.quizo_v1;

import java.util.ArrayList;

public class Quiz {

    private String quizName;
    private boolean forceTimerOn;
    private int maxTime;
    private ArrayList<Question> questionsList = new ArrayList<Question>();

    public Quiz (String QuizName) {
        this.quizName = QuizName;
    }

    public Quiz (String QuizName, ArrayList<Question> QuesitonsList) {
        this.quizName = QuizName;
        this.questionsList = QuesitonsList;
    }

    public String getQuizName() {
        return this.quizName;
    }

    public ArrayList<Question> getQuestionsList() {
        return this.questionsList;
    }

    public void setQuestionsList(ArrayList<Question> questionsList) {
        this.questionsList = questionsList;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public void addQuestion(Question question) {
        this.questionsList.add(question);
    }

    public ArrayList<Question> getQuestionsListArray() {
        return this.questionsList;
    }

    public int getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(int maxTime) {
        this.maxTime = maxTime;
    }

    public void setForceTimerOn(boolean forceTimerOn) {
        this.forceTimerOn = forceTimerOn;
    }

    public boolean isForceTimerOn() {
        return forceTimerOn;
    }
}
