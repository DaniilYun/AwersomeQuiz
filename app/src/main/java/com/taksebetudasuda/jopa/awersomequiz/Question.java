package com.taksebetudasuda.jopa.awersomequiz;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Daniil on 06.08.2018.
 */
public class Question implements Parcelable  {

    public static final String CATEGORY_LIAR = "тест на лжеца";
    public static final String CATEGORY_VOZRAST = "тест на возраст";
    public static final String CATEGORY_IQ = "Тест на iq";
    public static final String CATEGORY_DEBILIZM = "Тест на дебилизм";
    public static final String CATEGORY_BEREMENNOST = "Тест на беременность";
    public static final String CATEGORY_TERPIMOST = "Тест на терпимость";
    public static final String CATEGORY_ALFA = "Тест на альфасамца";
    public static final String CATEGORY_KRASOTA = "Тест на привлекательность";
    public static final String CATEGORY_HZ = "Тест на что-то";
    public static final String CATEGORY_ALCOHOL = "Тест на алкоголика";
    public static final String CATEGORY_RAZVRATNOST = "Тест на развратность";
    public static final String CATEGORY_PRIVLEKATELNOST = "Тест на привлекательность";
    public static final String CATEGORY_DOVERCHIVOST = "Тест на доверчивость";

    private String question;
    private String option1;
    private String option2;
    private String option3;
    private int answerNr;
    private int answerNr2;
    private String category;
//    private String sol1;
//    private String sol1a;
//    private String sol1b;
//    private String sol2;
//    private String sol2a;
//    private String sol2b;
//    private String sol3;
//    private String sol3a;
//    private String sol3b;
//    private String categotyRecomendet1;
//    private String categotyRecomendet2;
//    private String categotyRecomendet3;

    public Question() {
    }

    public Question(String question, String option1, String option2, String option3, int answerNr, int answerNr2, String category) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.answerNr = answerNr;
        this.answerNr2 = answerNr2;
        this.category = category;
    }

    protected Question(Parcel in) {
        question = in.readString();
        option1 = in.readString();
        option2 = in.readString();
        option3 = in.readString();
        answerNr = in.readInt();
        answerNr2 = in.readInt();
        category = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question);
        dest.writeString(option1);
        dest.writeString(option2);
        dest.writeString(option3);
        dest.writeInt(answerNr);
        dest.writeInt(answerNr2);
        dest.writeString(category);
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

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
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

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public int getAnswerNr() {
        return answerNr;
    }

    public void setAnswerNr(int answerNr) {
        this.answerNr = answerNr;
    }

    public int getAnswerNr2() {
        return answerNr2;
    }

    public void setAnswerNr2(int answerNr2) {
        this.answerNr2 = answerNr2;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public static String[] getAllDifficultyLevels(){
        return new String[]{
                CATEGORY_ALFA,
                CATEGORY_BEREMENNOST,
                CATEGORY_DEBILIZM,
                CATEGORY_HZ,
                CATEGORY_IQ,
                CATEGORY_KRASOTA,
                CATEGORY_LIAR,
                CATEGORY_TERPIMOST,
                CATEGORY_VOZRAST,
                CATEGORY_ALCOHOL,
                CATEGORY_PRIVLEKATELNOST,
                CATEGORY_RAZVRATNOST,
                CATEGORY_DOVERCHIVOST
        };
    }
}
