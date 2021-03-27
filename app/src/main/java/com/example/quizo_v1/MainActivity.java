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

        Quiz quiz = new Quiz("Beispiel Quiz");
        Question que1 = new Question(1,"Wer wurde 2013 Formel 1 Weltmeister?","Lewis Hamilton","Fernando Alonso","Sebastian Vettel", "Michael Schumacher",3);
        Question que2 = new Question(2,"Was ist die Hauptstadt von Deutschland?","Bonn","Stuttgart","Muenchen","Berlin",4);
        Question que3 = new Question(3,"In welchem Jahr hat Dirk Nowitzki die NBA Meisterachaft gewonnen?","2011","2013","2009","2010",1);
        Question que4 = new Question(4,"Bei welchem Team fährt Sebastian Vettel 2021 in der Formel 1","Mercedes","Aston Martin","Ferrari","Red Bull",2);
        Question que5 = new Question(5,"Mit welchem Album hat Kendick Lamar ein Pulitzer Preis gewonnen?","To Pimp a Butterfly","Damn","Section.80","good kid, m.A.A.d city",2);
        quiz.addQuestion(que1);
        quiz.addQuestion(que2);
        quiz.addQuestion(que3);
        quiz.addQuestion(que4);
        quiz.addQuestion(que5);
        Constants.addQuiz(quiz);
    }
}