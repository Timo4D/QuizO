package com.example.quizo_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CreateQuizActivity extends AppCompatActivity {

    private String quizName;
    private int questionNr = 1;
    private Quiz quiz;
    private int correctAnswer;
    private boolean forceTimer;

    private TextView tv_quizName;
    private TextView tv_questionNr;
    private EditText et_question;
    private EditText et_option1;
    private EditText et_option2;
    private EditText et_option3;
    private EditText et_option4;
    private EditText et_correctAnswer;
    private Button btn_addNextQuestion;
    private Button btn_doneWithQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_quiz);

        Intent intent = getIntent();
        quizName = intent.getStringExtra(Constants.QUIZ_NAME);
        forceTimer = intent.getBooleanExtra(Constants.FORCE_TIMER,false);

        tv_quizName = findViewById(R.id.tv_createQuizQuizName);
        tv_questionNr = findViewById(R.id.tv_questionNumber);
        et_question = findViewById(R.id.et_question);
        et_option1 = findViewById(R.id.et_option1);
        et_option2 = findViewById(R.id.et_option2);
        et_option3 = findViewById(R.id.et_option3);
        et_option4 = findViewById(R.id.et_option4);
        et_correctAnswer = findViewById(R.id.et_correctAnswer);
        btn_addNextQuestion = findViewById(R.id.btn_nextQuestion);
        btn_doneWithQuiz = findViewById(R.id.btn_doneWithQuiz);


        tv_questionNr.setText(""+questionNr);
        tv_quizName.setText(quizName);

        quiz = new Quiz(quizName);
        quiz.setForceTimerOn(forceTimer);


        btn_addNextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createQuestion();
            }
        });

        btn_doneWithQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(quiz.getQuestionsList().isEmpty()) {
                    Toast.makeText(CreateQuizActivity.this,"Please create at least 1 question",Toast.LENGTH_SHORT).show();
                } else {
                    createQuestion();
                    Constants.addQuiz(quiz);
                    Intent i = new Intent(CreateQuizActivity.this,QuizListActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });
    }

    private void createQuestion() {

        if(et_question.getText().toString().isEmpty() || et_option1.getText().toString().isEmpty() || et_option2.getText().toString().isEmpty() ||
                et_option3.getText().toString().isEmpty() || et_option4.getText().toString().isEmpty() || et_correctAnswer.getText().toString().isEmpty()) {

            Toast.makeText(CreateQuizActivity.this,"Please fill out all Boxes",Toast.LENGTH_SHORT).show();
        } else {

            Integer pCorrectAnwer = Integer.parseInt(et_correctAnswer.getText().toString());

            if(pCorrectAnwer >= 1 && pCorrectAnwer <= 4) {
                Question question = new Question(questionNr,
                        et_question.getText().toString(),
                        et_option1.getText().toString(),
                        et_option2.getText().toString(),
                        et_option3.getText().toString(),
                        et_option4.getText().toString(),
                        Integer.parseInt(String.valueOf(et_correctAnswer.getText())));

                quiz.addQuestion(question);

                questionNr++;
                tv_questionNr.setText(""+questionNr);
                clearEditText();
            } else {
                Toast.makeText(CreateQuizActivity.this,"Please select a correct answer between 1 and 4",Toast.LENGTH_SHORT).show();
            }
        }

    }

    private void clearEditText() {
        et_question.setText("");
        et_option1.setText("");
        et_option2.setText("");
        et_option3.setText("");
        et_option4.setText("");
        et_correctAnswer.setText("");
    }

}