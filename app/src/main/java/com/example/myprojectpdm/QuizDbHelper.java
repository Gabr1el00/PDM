package com.example.myprojectpdm;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myprojectpdm.QuizContract.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyTemperamentQuiz.db";
    private static final int DATABASE_VERSION = 1;
    private static QuizDbHelper instance;
    private SQLiteDatabase db;
    private QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized QuizDbHelper getInstance(Context context) {
        if (instance == null) {
            instance = new QuizDbHelper(context.getApplicationContext());
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR1 + " INTEGER, " +
                QuestionsTable.COLUMN_ANSWER_NR2 + " INTEGER )";
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }


    private void fillQuestionsTable() {
        Question q1 = new Question("A. Sunt foarte impresionat chiar de lucruri mărunte.",
                "B. Sunt tulburat numai în situaţii grave, deosebite.", 1,2);
        insertQuestion(q1);
        Question q2 = new Question("A. Mă entuziasmez şi mă indignez din nimic.",
                "B. De obicei iau lucrurile aşa cum sunt, păstrându-mi calmul..", 1,2
                );
        insertQuestion(q2);
        Question q3 = new Question("A. Când vorbesc, în general mă aprind şi ridic vocea.",
                "B. Obişnuiesc să vorbesc calm, aşezat, fără grabă.", 1,2
                );
        insertQuestion(q3);
        Question q4 = new Question("A. Trec adesea fără motiv de la bucurie la tristeţe şi invers.",
                "B. Am o dispoziţie egală. Îmi văd de treabă, fără să iau în considerare atmosfera care mă înconjoară.", 1,2
                );
        insertQuestion(q4);
        Question q5 = new Question("A. Uneori de emoţie mă pierd, sunt ca şi paralizat.",
                "B. Aşa ceva nu mi se întâmplă. Fac faţă oricărei situaţii.", 1,2
                );
        insertQuestion(q5);
        Question q6 = new Question("A. O ironie mă doare într-atât, încât pur şi simplu amuţesc.",
                "B. Cuvintele nu au mare importanţă pentru mine deoarece eu apreciez numai faptele.", 1,2
               );
        insertQuestion(q6);
        Question q7 = new Question("A. La cinematograf trăiesc din plin ceea ce se petrece pe ecran, mă agit, sunt emoţionat, râd sau plâng.",
                "B. Filmul este un simplu joc de umbre pe o pânză. Uneori mă distrează, alteori nu, dar atât.", 1,2
        );
        insertQuestion(q7);
        Question q8 = new Question("A. Când am timp liber, mă odihnesc, dorm, etc..",
                "B. În timpul meu liber studiez, muncesc sau fac sport.", 1,2
        );
        insertQuestion(q8);
        Question q9 = new Question("A. Fac în general eforturi ca să trec de la gând la faptă.",
                "B. Este de ajuns să doresc ceva ca să trec imediat la fapte.", 1,2
        );
        insertQuestion(q9);
        Question q10 = new Question("A. Decât să fac multe lucruri simple, mai bine gândesc mult, corect şi realizez puţin.",
                "B. În general inventez şi organizez mereu câte ceva.", 1,2
        );
        insertQuestion(q10);
        Question q11 = new Question("A. În general nu îmi asum riscul. Sunt tentat să ocolesc, să amân, să aştept, deoarece multe se rezolvă de la sine.",
                "B. Atunci când am hotărât ceva, nu dau înapoi indiferent de piedicile întâlnite.", 1,2
        );
        insertQuestion(q11);
        Question q12 = new Question("A. Fără motive întemeiate nu întreprind nimic. Ar fi o oboseală inutilă.",
                "B. Sunt mereu ocupat. Mă enervează să stau şi să nu fac nimic.", 1,2
        );
        insertQuestion(q12);
        Question q13 = new Question("A. Prefer să privesc un joc decât să particip la el.",
                "B. Îmi place mai mult să particip la un joc decât să privesc.", 1,2
        );
        insertQuestion(q13);
        Question q14 = new Question("A. Obosesc foarte repede chiar şi atunci când îmi place munca pe care o fac.",
                "B. Am multă putere de muncă, sunt rezistent la efort.", 1,2
        );
        insertQuestion(q14);
        Question q15 = new Question("A. Încep multe lucruri, însă ele rămân adesea neterminate.",
                "B. Concep planuri pe termen lung şi în timp le realizez.", 1,2
        );
        insertQuestion(q15);
        Question q16 = new Question("A. Îmi schimb adesea părerile atunci când descopăr lucruri neaşteptate, necunoscute.",
                "B. Sunt foarte constant în simpatiile şi antipatiile mele.", 1,2
        );
        insertQuestion(q16);
        Question q17 = new Question("A. Necazurile reuşesc să le depăşesc repede.",
                "B. Cuvintele nu au mare importanţă pentru mine deoarece eu apreciez." +
                        "numai faptele.", 1,2
        );
        insertQuestion(q17);
        Question q18 = new Question("A. Şi viitorul este important însă eu trăiesc în prezent.",
                "B. Prezentul înseamnă prea puţin faţă de trecut şi viitor.", 1,2
        );
        insertQuestion(q18);
        Question q19 = new Question("A. Când sunt supărat izbucnesc şi mă descarc.",
                "B. Supărările nu se pot descărca. Le aduni în tine şi le suporţi.", 1,2
        );
        insertQuestion(q19);
        Question q20 = new Question("A. Mă plictisesc lucrurile şi fenomenele cunoscute, prefer schimbarea.",
                "B. Am multe obiceiuri exacte la care ţin mult. Nu-mi place necunoscutul.", 1,2
        );
        insertQuestion(q20);
        Question q21 = new Question("A. Firea mea deşi deschisă, este un permanent şir de surprize.",
                "B. Este greu să mă cunoască cineva bine, fiind o fire reţinută, interiorizată.", 1,2
        );
        insertQuestion(q21);
    }


    private void insertQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR1, question.getAnswerNr1());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR2, question.getAnswerNr2());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }


    @SuppressLint("Range")
    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME + " ORDER BY "+QuestionsTable._ID+" ASC",
                null);
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setId(c.getInt(c.getColumnIndex(QuestionsTable._ID)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setAnswerNr1(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR1)));
                question.setAnswerNr2(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR2)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();


        return questionList;
    }

}