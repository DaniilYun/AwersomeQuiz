package com.taksebetudasuda.jopa.awersomequiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Daniil on 07.08.2018.
 */
public class QuestionLab {
    private  static  QuestionLab questionLab;

    private SQLiteDatabase db;

    public static QuestionLab get(Context context) {
        if (questionLab == null) {
            questionLab = new QuestionLab(context);
        }

        return questionLab;
    }

    private QuestionLab(Context context){
        Context context1 = context.getApplicationContext();
        db = new QuizDbHelper(context).getWritableDatabase();
    }

    public ArrayList<Question> getQuestions(String difficulty) {
        ArrayList<Question> questionList = new ArrayList<>();

        String[] selectionArgs = new String[]{difficulty};
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContract.QuestionTable.TABLE_NAME +
                " WHERE " + QuizContract.QuestionTable.COLUMN_CATEROGY + " = ?", selectionArgs);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_ANSWER_NR)));
                question.setAnswerNr2(c.getInt(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_ANSWER_NR_2)));
                question.setCategory(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_CATEROGY)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }

    public Category getCategory(String difficulty) {
        Category categoryList = new Category();

        String[] selectionArgs = new String[]{difficulty};
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContract.QuestionTable.TABLE_NAME2 +
                " WHERE " + QuizContract.QuestionTable.COLUMN_CATEROGY + " = ?", selectionArgs);

        if (c.moveToFirst()) {
            do {
                Category category = new Category();
                category.setCategoty(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_CATEROGY)));
                category.setResult1a(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_SOLUTION1)));
                category.setResult1b(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_SOLUTION1A)));
                category.setResult1c(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_SOLUTION1B)));
                category.setResult2a(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_SOLUTION2)));
                category.setResult2b(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_SOLUTION2A)));
                category.setResult2c(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_SOLUTION2B)));
                category.setResult3a(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_SOLUTION3)));
                category.setResult3b(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_SOLUTION3A)));
                category.setResult3c(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_SOLUTION3B)));
                category.setRecomend1(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_CATEGORY_RECOMENDET1)));
                category.setRecomend2(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_CATEGORY_RECOMENDET2)));
                category.setRecomend3(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_CATEGORY_RECOMENDET3)));
                category.setResultForView(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_SOLUTION_FOR_VIEW)));
                category.setImageName(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_IMAGE_NAME)));
                categoryList= category;
            } while (c.moveToNext());
        }
        c.close();
        return categoryList;
    }

    public ArrayList<Category> getAllCategories() {
        ArrayList<Category> questionList = new ArrayList<>();

        Cursor c = db.rawQuery("SELECT * FROM " + QuizContract.QuestionTable.TABLE_NAME2 , null);

        if (c.moveToFirst()) {
            do {
                Category category = new Category();
                category.setCategoty(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_CATEROGY)));
                category.setResult1a(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_SOLUTION1)));
                category.setResult1b(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_SOLUTION1A)));
                category.setResult1c(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_SOLUTION1B)));
                category.setResult2a(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_SOLUTION2)));
                category.setResult2b(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_SOLUTION2A)));
                category.setResult2c(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_SOLUTION2B)));
                category.setResult3a(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_SOLUTION3)));
                category.setResult3b(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_SOLUTION3A)));
                category.setResult3c(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_SOLUTION3B)));
                category.setRecomend1(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_CATEGORY_RECOMENDET1)));
                category.setRecomend2(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_CATEGORY_RECOMENDET2)));
                category.setRecomend3(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_CATEGORY_RECOMENDET3)));
                category.setResultForView(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_SOLUTION_FOR_VIEW)));
                category.setImageName(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_IMAGE_NAME)));
                questionList.add(category);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }

    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> questionList = new ArrayList<>();

        Cursor c = db.rawQuery("SELECT * FROM " + QuizContract.QuestionTable.TABLE_NAME , null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_ANSWER_NR)));
                question.setAnswerNr2(c.getInt(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_ANSWER_NR_2)));
                question.setCategory(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_CATEROGY)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }

    public static ContentValues getContentValuesForQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuizContract.QuestionTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuizContract.QuestionTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuizContract.QuestionTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuizContract.QuestionTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuizContract.QuestionTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        cv.put(QuizContract.QuestionTable.COLUMN_ANSWER_NR_2, question.getAnswerNr2());
        cv.put(QuizContract.QuestionTable.COLUMN_CATEROGY, question.getCategory());
        return  cv;
    }
    public static ContentValues getContentValuesForCategotyes(Category category) {
        ContentValues cv = new ContentValues();
        cv.put(QuizContract.QuestionTable.COLUMN_CATEROGY, category.getCategoty());
        cv.put(QuizContract.QuestionTable.COLUMN_SOLUTION1, category.getResult1a());
        cv.put(QuizContract.QuestionTable.COLUMN_SOLUTION1A, category.getResult1b());
        cv.put(QuizContract.QuestionTable.COLUMN_SOLUTION1B, category.getResult1c());
        cv.put(QuizContract.QuestionTable.COLUMN_SOLUTION2, category.getResult2a());
        cv.put(QuizContract.QuestionTable.COLUMN_SOLUTION2A, category.getResult2b());
        cv.put(QuizContract.QuestionTable.COLUMN_SOLUTION2B, category.getResult2c());
        cv.put(QuizContract.QuestionTable.COLUMN_SOLUTION3, category.getResult3a());
        cv.put(QuizContract.QuestionTable.COLUMN_SOLUTION3A, category.getResult3b());
        cv.put(QuizContract.QuestionTable.COLUMN_SOLUTION3B, category.getResult3c());
        cv.put(QuizContract.QuestionTable.COLUMN_CATEGORY_RECOMENDET1, category.getRecomend1());
        cv.put(QuizContract.QuestionTable.COLUMN_CATEGORY_RECOMENDET2, category.getRecomend2());
        cv.put(QuizContract.QuestionTable.COLUMN_CATEGORY_RECOMENDET3, category.getRecomend3());
        cv.put(QuizContract.QuestionTable.COLUMN_SOLUTION_FOR_VIEW, category.getResultForView());
        cv.put(QuizContract.QuestionTable.COLUMN_IMAGE_NAME, category.getImageName());
        return  cv;
    }

    public void updateQuestion(Question question){
        String q = question.getQuestion();
        ContentValues cv = getContentValuesForQuestion(question);
        db.update(QuizContract.QuestionTable.TABLE_NAME,cv,
                QuizContract.QuestionTable.COLUMN_QUESTION + " = ?", new String[]{q});
    }

    public void updateCategory(Category category){
        String q = category.getCategoty();
        ContentValues cv = getContentValuesForCategotyes(category);
        db.update(QuizContract.QuestionTable.TABLE_NAME2,cv,
                QuizContract.QuestionTable.COLUMN_CATEROGY + " = ?", new String[]{q});
    }
}
