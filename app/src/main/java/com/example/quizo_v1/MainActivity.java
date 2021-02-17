package com.example.quizo_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btn_start;
    private EditText et_name;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name = findViewById(R.id.et_name);
        btn_start = findViewById(R.id.btn_start);

        MobileAds.initialize(MainActivity.this);
        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        setUpTestQuiz();

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_name.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this,"Please enter your name",Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this,QuizListActivity.class);
                    Constants.getSettings().setUserName(et_name.getText().toString());
                    startActivity(intent);
                    finish();
                }
            }
        });

    }

    public void setUpTestQuiz() {

        Quiz quiz = new Quiz("Test");
        Question que1 = new Question(1,"What ist 1+1","obstsalat","kartoffelsalat","2", "hobbylos",3);
        Question que2 = new Question(2,"Ist das ein Test?","ja","nein","vielleicht","eventuell",3);
        quiz.addQuestion(que1);
        quiz.addQuestion(que2);
        Constants.addQuiz(quiz);
    }
}