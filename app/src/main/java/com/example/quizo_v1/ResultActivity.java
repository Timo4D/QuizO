package com.example.quizo_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView tv_name;
    private TextView tv_score;
    private Button btn_finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();

        tv_name = findViewById(R.id.tv_name);
        tv_score = findViewById(R.id.tv_score);
        btn_finish  = findViewById(R.id.btn_finish);

        tv_name.setText(Constants.getUserName());
        tv_score.setText("Your score is "+intent.getIntExtra(Constants.correct_answers,0)+" out of "+intent.getIntExtra(Constants.total_questions,0)+"!");

        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ResultActivity.this, QuizListActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}