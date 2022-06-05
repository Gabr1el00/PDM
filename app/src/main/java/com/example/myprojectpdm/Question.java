package com.example.myprojectpdm;

import android.os.Parcel;
import android.os.Parcelable;

public class Question implements Parcelable {
    private int id;
    private String option1;
    private String option2;
    private int answerNr1;
    private int answerNr2;

    public Question() {
    }

    public Question(String option1, String option2, int answerNr1, int answerNr2) {
        this.option1 = option1;
        this.option2 = option2;
        this.answerNr1 = answerNr1;
        this.answerNr2 = answerNr2;
    }

    protected Question(Parcel in) {
        id = in.readInt();
        option1 = in.readString();
        option2 = in.readString();
        answerNr1 = in.readInt();
        answerNr2 = in.readInt();

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(option1);
        dest.writeString(option2);
        dest.writeInt(answerNr1);
        dest.writeInt(answerNr2);


    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }


    public int getAnswerNr1() {
        return answerNr1;
    }
    public int getAnswerNr2() {
        return answerNr2;
    }
    public int getID(){return id;}
    public void setAnswerNr1(int answerNr1) {
        this.answerNr1 = answerNr1;
    }
    public void setAnswerNr2(int answerNr2) {
        this.answerNr2 = answerNr2;
    }
}
