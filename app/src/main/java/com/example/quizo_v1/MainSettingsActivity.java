package com.example.quizo_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainSettingsActivity extends AppCompatActivity {

    private EditText et_userName;
    private SwitchMaterial switch_Timer;
    private Button btn_applyChange;
    private Button btn_cancle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_settings);

        et_userName = findViewById(R.id.et_userName);
        switch_Timer = findViewById(R.id.switch_useTimer);
        btn_applyChange = findViewById(R.id.btn_applyChange);
        btn_cancle = findViewById(R.id.btn_settingsCancle);

        et_userName.setText(Constants.getSettings().getUserName());

        btn_applyChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_userName.getText().toString().isEmpty()) {
                    Toast.makeText(MainSettingsActivity.this,"Please enter a Username",Toast.LENGTH_SHORT).show();
                } else {
                    Constants.getSettings().setUserName(et_userName.getText().toString());
                }

                if(switch_Timer.isChecked()) {
                    Constants.getSettings().setUseTimer(true);
                } else {
                    Constants.getSettings().setUseTimer(false);
                }

                Intent intent = new Intent(MainSettingsActivity.this,QuizListActivity.class);
                startActivity(intent);
                finish();

            }
        });

        btn_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainSettingsActivity.this,QuizListActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}