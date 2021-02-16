package com.example.quizo_v1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class QuizListActivity extends AppCompatActivity {

    private Button btn_addQuiz;
    private ListView lv_QuizList;
    private ArrayList<Quiz> quizArrayList;
    private ArrayList<String> quizNameArrayList;
    private ArrayAdapter<String> quizArrayAdapter;
//TODO long klick item remover
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_list);


        btn_addQuiz = findViewById(R.id.btn_AddQuiz);
        lv_QuizList = findViewById(R.id.lv_QuizList);
        quizArrayList = Constants.getQuizArrayList();
        quizNameArrayList = new ArrayList<String>();
        setQuizNameArray();
        quizArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,quizNameArrayList);
        lv_QuizList.setAdapter(quizArrayAdapter);
        setUpListViewListener();

    }

    private void setUpListViewListener() {
        lv_QuizList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(QuizListActivity.this, QuizAnswerActivity.class);
                i.putExtra(Constants.QUIZ_NUMBER,position);
                startActivity(i);
            }
        });

        lv_QuizList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                return false;
            }
        });

        btn_addQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(QuizListActivity.this,QuizCreateNameActivity.class);
                startActivity(i);
            }
        });
    }

    private void setQuizNameArray() {
        int x = quizArrayList.size();
        for(int i=0;i<x;i++) {
            String quizName = quizArrayList.get(i).getQuizName();
            quizNameArrayList.add(quizName);
        }
    }

}