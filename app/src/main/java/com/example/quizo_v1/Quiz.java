package com.example.quizo_v1;

import java.util.ArrayList;

public class Quiz {

    private String quizName;
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


}
