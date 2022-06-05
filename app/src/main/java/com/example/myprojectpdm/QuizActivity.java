package com.example.myprojectpdm;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.CountDownTimer;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class QuizActivity extends AppCompatActivity {
    public static final String EXTRA_SCORE = "extraScore";
    private int a=0,b=0;
    private int x,y,z;
    private int t=0;
    private String result;
    private static final String KEY_QUESTION_COUNT = "keyQuestionCount";
    private static final String KEY_ANSWERED = "keyAnswered";
    private static final String KEY_QUESTION_LIST = "keyQuestionList";

    private TextView textViewQuestionCount;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private Button buttonConfirmNext;
    private ColorStateList textColorDefaultRb;
    private ArrayList<Question> questionList;
    private int questionCounter;
    private int questionCountTotal;
    private Question currentQuestion;


    private boolean answered;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        textViewQuestionCount = findViewById(R.id.text_view_question_count);
        System.out.println(textViewQuestionCount);
        rbGroup = findViewById(R.id.radio_group);
        rb1 = findViewById(R.id.radio_button1);
        rb2 = findViewById(R.id.radio_button2);
        buttonConfirmNext = findViewById(R.id.button_confirm_next);
        textColorDefaultRb = rb1.getTextColors();
        textColorDefaultRb = rb2.getTextColors();

        Intent intent = getIntent();
        if (savedInstanceState == null) {
            QuizDbHelper dbHelper = QuizDbHelper.getInstance(this);
            questionList = dbHelper.getAllQuestions();
            questionCountTotal = questionList.size();
            System.out.println(questionCountTotal);
            showNextQuestion();
        } else {
            questionList = savedInstanceState.getParcelableArrayList(KEY_QUESTION_LIST);
            questionCountTotal = questionList.size();
            questionCounter = savedInstanceState.getInt(KEY_QUESTION_COUNT);
            currentQuestion = questionList.get(questionCounter-1);
            answered = savedInstanceState.getBoolean(KEY_ANSWERED);
        }

        buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (!answered) {
                    if (rb1.isChecked() || rb2.isChecked()) {
                        checkAnswer();
                        showNextQuestion();
                    } else {
                        Toast.makeText(QuizActivity.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });
    }

    private void showNextQuestion() {
        rb1.setTextColor(textColorDefaultRb);
        rb2.setTextColor(textColorDefaultRb);
        rbGroup.clearCheck();

        if (questionCounter < questionCountTotal) {
            currentQuestion = questionList.get(questionCounter);
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            questionCounter++;

            textViewQuestionCount.setText("Întrebare: " + questionCounter + "/" + questionCountTotal);
            answered = false;
        } else {
            switch (x){
                case 1:{switch(y){
                    case 1:{switch(z){
                        case 1:{result="Nervos";
                            break;}
                        case 2:{
                            result="Sentimental";

                            break;
                        }} break;}

                    case 2:{switch(z) {
                        case 1: {
                            result="Coleric";
                            break;
                        }
                        case 2: {
                            result="Pasionat";
                            break;
                        }
                    }break;}}
                    break;}
                case 2:{switch(y) {
                    case 1 :{switch(z) {
                        case 1: {
                            result="Sangvinic";
                            break;
                        }
                        case 2: {
                            result="Flegmatic";
                            break;
                        }
                    }break;}
                        case 2:{switch(z){
                            case 1:{
                                result="Amorf";
                                break;
                                }
                            case 2:{
                                result="Melancolic";
                                break;
                            }
                        }break;}
                }break;}}
            System.out.println(x+" "+y+" "+z);
            finishQuiz();
        }
    }



    private void checkAnswer() {
        answered = true;
        RadioButton rbSelected = findViewById(rbGroup.getCheckedRadioButtonId());
        int answerNr = rbGroup.indexOfChild(rbSelected) + 1;
        if (answerNr == 1) {
            a++;
        }else{b++;}
        t++;
        System.out.println(t+" a="+a+" b="+b);
        if ((t==7)&&(a>=4)){
            x=1;
            a=0;
            b=0;
        } else if(t==7){
            x=2;
            a=0;
            b=0;
        }
        if ((t==14)&&(a>=4)){
            y=1;
            a=0;
            b=0;
        } else if(t==14){
            y=2;
            a=0;
            b=0;
        }
        if ((t==21)&&(a>=4)){
            z=1;
            a=0;
            b=0;
        } else if(t==21){
            z=2;
            a=0;
            b=0;
        }
    }


    private void finishQuiz() {
        Intent intent = new Intent(QuizActivity.this,ResultActivity.class);
        intent.putExtra("name",result);
        startActivity(intent);
        finish();
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_QUESTION_COUNT, questionCounter);
        outState.putBoolean(KEY_ANSWERED, answered);
        outState.putParcelableArrayList(KEY_QUESTION_LIST, questionList);
    }
}
