package com.example.quizo_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class QuizCreateNameActivity extends AppCompatActivity {

    private EditText et_quitName;
    private Button btn_createQuiz;
    private Button btn_cancle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_create_name);

        et_quitName = findViewById(R.id.et_quizName);
        btn_cancle = findViewById(R.id.btn_cancleCreateQuizName);
        btn_createQuiz = findViewById(R.id.btn_createNewQuiz);

        btn_createQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_quitName.getText().toString().isEmpty()) {
                    Toast.makeText(QuizCreateNameActivity.this,"Please enter a name for your quiz",Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = new Intent(QuizCreateNameActivity.this,CreateQuizActivity.class);
                    i.putExtra(Constants.QUIZ_NAME,et_quitName.getText().toString());
                    startActivity(i);
                }
            }
        });

        btn_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(QuizCreateNameActivity.this,QuizListActivity.class);
                startActivity(i);
            }
        });

    }
}