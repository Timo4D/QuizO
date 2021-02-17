package com.example.quizo_v1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class QuizAnswerActivity extends AppCompatActivity {

    private int currentPosition = 1;
    private ArrayList<Question> questionArrayList;
    private int quizNumber;
    private int selectedPosition = 0;
    private Boolean questionAnwered = false;
    private Boolean timerIsRunning = false;
    private long pauseOffset;

    private int correctAnswers = 0;

    private Chronometer chronometer;
    private TextView tv_question;
    private TextView tv_option1;
    private TextView tv_option2;
    private TextView tv_option3;
    private TextView tv_option4;
    private TextView tv_progress;
    private ProgressBar progressBar;
    private Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_answer);

        Intent intent = getIntent();
        quizNumber = intent.getIntExtra(Constants.QUIZ_NUMBER,0);

        questionAnwered = false;

        questionArrayList = Constants.getQuiz(quizNumber).getQuestionsList();

        tv_question = findViewById(R.id.tv_question);
        tv_option1 = findViewById(R.id.tv_option_1);
        tv_option2 = findViewById(R.id.tv_option_2);
        tv_option3 = findViewById(R.id.tv_option_3);
        tv_option4 = findViewById(R.id.tv_option_4);
        progressBar = findViewById(R.id.progressBar);
        tv_progress = findViewById(R.id.tv_progress);
        btn_submit = findViewById(R.id.btn_submit);
        chronometer = findViewById(R.id.chronometer);

        if(!Constants.getSettings().isUseTimer()) {
            chronometer.setVisibility(View.GONE);
        }

        setQuestion();

        startChronometer();

        tv_option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questionAnwered==false) {
                    selectedOptionView(tv_option1,1);
                }
            }
        });

        tv_option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questionAnwered==false) {
                    selectedOptionView(tv_option2, 2);
                }
            }
        });

        tv_option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questionAnwered==false) {
                    selectedOptionView(tv_option3, 3);
                }
            }
        });

        tv_option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questionAnwered==false) {
                    selectedOptionView(tv_option4, 4);
                }
            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedPosition == 0) {
                    currentPosition++;

                    if(currentPosition <= questionArrayList.size()) {
                        setQuestion();
                        questionAnwered = false;
                    } else {
                        pauseChronometer();
                        Intent i = new Intent(QuizAnswerActivity.this,ResultActivity.class);
                        i.putExtra(Constants.TIMER,chronometer.getText().toString());
                        i.putExtra(Constants.correct_answers,correctAnswers);
                        i.putExtra(Constants.total_questions,questionArrayList.size());
                        i.putExtra(Constants.QUIZ_NUMBER,quizNumber);
                        resetChronometer();
                        startActivity(i);
                        finish();
                    }
                } else {
                    Question question = (Question) questionArrayList.get(currentPosition-1);
                    if(question.getCorrectAnswer() != selectedPosition) {
                        answerView(selectedPosition,R.drawable.wrong_option_border_bg);
                    } else {
                        correctAnswers++;
                    }
                    answerView(question.getCorrectAnswer(),R.drawable.correct_option_border_bg);

                    if(currentPosition == questionArrayList.size()) {
                        btn_submit.setText("Finish");
                        questionAnwered = true;
                    } else {
                        btn_submit.setText("Go to next Quesiton");
                        questionAnwered =true;
                    }

                    selectedPosition=0;
                }
            }
        });
    }

    private void resetChronometer() {
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseOffset = 0;
    }

    private void pauseChronometer() {
        if(timerIsRunning) {
            chronometer.stop();
            pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
            timerIsRunning = false;
        }
    }

    private void startChronometer() {
        if(!timerIsRunning) {
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
            chronometer.start();
            timerIsRunning = true;
        }
    }


    private void setQuestion() {
        Question question = (Question) questionArrayList.get(currentPosition-1);
        defaultOptionsView();
        btn_submit.setText("submit");

        progressBar.setMax(questionArrayList.size());
        progressBar.setProgress(currentPosition);

        tv_progress.setText(currentPosition+"/"+progressBar.getMax());

        tv_question.setText(question.getQuestion());

        tv_option1.setText(question.getOption1());

        tv_option2.setText(question.getOption2());

        tv_option3.setText(question.getOption3());

        tv_option4.setText(question.getOption4());
    }

    private void defaultOptionsView() {
        ArrayList<TextView> options = new ArrayList<TextView>();
        options.add(0,tv_option1);
        options.add(1,tv_option2);
        options.add(2,tv_option3);
        options.add(3,tv_option4);

        for(int i=0; i<options.size();i++) {
            TextView tv = (TextView) options.get(i);
            tv.setTextColor(Color.parseColor("#7A8089"));
            tv.setTypeface(Typeface.DEFAULT);
            tv.setBackground(ContextCompat.getDrawable(this, R.drawable.default_option_border_bg));
        }

    }

    private void selectedOptionView(TextView tv, int selectedOptionNumber) {
        defaultOptionsView();
        selectedPosition = selectedOptionNumber;

        tv.setTextColor(Color.parseColor("#363A43"));
        tv.setTypeface(tv.getTypeface(),Typeface.BOLD);
        tv.setBackground(ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg));
    }

    private void answerView(int answer, int drawableView) {
        switch (answer) {
            case 1:
                tv_option1.setBackground(ContextCompat.getDrawable(this, drawableView));
                break;

            case 2:
                tv_option2.setBackground(ContextCompat.getDrawable(this, drawableView));
                break;

            case 3:
                tv_option3.setBackground(ContextCompat.getDrawable(this, drawableView));
                break;

            case 4:
                tv_option4.setBackground(ContextCompat.getDrawable(this, drawableView));
                break;
        }
    }

}