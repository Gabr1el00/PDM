package com.example.myprojectpdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {
    private TextView text;
    private TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        onIntent();
    }

    protected void onIntent() {
        Intent i = getIntent();
        String name = i.getStringExtra("name");
        text=findViewById(R.id.text);
        text.setText("Temperamentul tău este "+name);


        Button button = findViewById(R.id.button_restart_quiz);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, QuizActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}