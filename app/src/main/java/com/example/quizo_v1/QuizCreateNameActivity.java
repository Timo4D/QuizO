package com.example.quizo_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class QuizCreateNameActivity extends AppCompatActivity {

    private EditText et_quizName;
    private Button btn_createQuiz;
    private Button btn_cancle;
    private SwitchMaterial switch_forceTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_create_name);

        et_quizName = findViewById(R.id.et_quizName);
        btn_cancle = findViewById(R.id.btn_cancleCreateQuizName);
        btn_createQuiz = findViewById(R.id.btn_createNewQuiz);
        switch_forceTimer = findViewById(R.id.switch_forceTimer);


        btn_createQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_quizName.getText().toString().isEmpty()) {
                    Toast.makeText(QuizCreateNameActivity.this,"Please enter a name for your quiz",Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = new Intent(QuizCreateNameActivity.this,CreateQuizActivity.class);
                    i.putExtra(Constants.QUIZ_NAME,et_quizName.getText().toString());
                    i.putExtra(Constants.FORCE_TIMER, switch_forceTimer.isChecked());
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