package com.taksebetudasuda.jopa.awersomequiz;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {
    public static final String EXTRA_DIFFICULTY = "extraDifficulty";
    public static final String EXTRA_SCORE = "exstraScore";
    private final String TAG = "QuizActivity";
//    public static final String EXTRA_CATEGOTY = "exstraCategoy";
    private static final long COUNT_DOWN_MILLIS = 31000;

    private static final String KEY_SCORE = "keyScore";
    private static final String KEY_QUESTION_COUNT = "keyQuestionCount";
    private static final String KEY_MILLIS_LEFT = "keyMillisLeft";
    private static final String KEY_ANSWERED = "keyAnswered";
    private static final String KEY_QUESTION_LIST= "keyQuestionList";

    private TextView textViewQuestion;
    private TextView textViewQuestionCount;
    private TextView textViewCountDown;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private Button btnConfirmNext;

    private ColorStateList textColorDefaultCd;

    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;

    private ArrayList<Question> questionList;
    private Category cuurentCategory;
    private int questionCounter;
    private int questionCountTotal;
    private Question currentQuestion;
    private String newDifficulty;
    private String difficulty;

    private int score;
    private boolean answered;

    private long backPressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        textViewQuestion = findViewById(R.id.text_view_question);
        textViewQuestionCount = findViewById(R.id.text_view_question_count);
        textViewCountDown = findViewById(R.id.text_view_count_down);
        rbGroup = findViewById(R.id.radio_group);
        rb1 = findViewById(R.id.radio_btn1);
        rb2 = findViewById(R.id.radio_btn2);
        rb3 = findViewById(R.id.radio_btn3);
        btnConfirmNext = findViewById(R.id.btn_confirm_next);

        textColorDefaultCd = textViewCountDown.getTextColors();

        Intent intent = getIntent();
        difficulty = intent.getStringExtra(EXTRA_DIFFICULTY);

        cuurentCategory = QuestionLab.get(this).getCategory(difficulty);

        if (savedInstanceState == null) {
            questionList =QuestionLab.get(this).getQuestions(difficulty);
            questionCountTotal = questionList.size();
//            Collections.shuffle(questionList);

            showNextQuestion();
        }else {
            questionList = savedInstanceState.getParcelableArrayList(KEY_QUESTION_LIST);

            questionCountTotal = questionList.size();
            questionCounter = savedInstanceState.getInt(KEY_QUESTION_COUNT);
            currentQuestion = questionList.get(questionCounter-1);
            score = savedInstanceState.getInt(KEY_SCORE);
            timeLeftInMillis = savedInstanceState.getLong(KEY_MILLIS_LEFT);
            answered = savedInstanceState.getBoolean(KEY_ANSWERED);

            if (!answered){
                startCountDown();
            }else {
                updateCountDownText();
                showSolution();
            }
        }

        btnConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered) {
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(QuizActivity.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });
    }

    private void checkAnswer() {
        answered = true;

        countDownTimer.cancel();

        RadioButton rbSelected = findViewById(rbGroup.getCheckedRadioButtonId());
        int answerNr = rbGroup.indexOfChild(rbSelected) + 1;

        if (answerNr == currentQuestion.getAnswerNr()) {
            score+=2;
        }else if (answerNr == currentQuestion.getAnswerNr2()) {
            score++;
        }
        showSolution();
    }

    private void showSolution() {
        if (questionCounter < questionCountTotal) {
//            btnConfirmNext.setText("Next");
            showNextQuestion();
        } else {
            btnConfirmNext.setText("Show Result");
        }
    }

    private void showNextQuestion() {
        rbGroup.clearCheck();


        if (questionCounter < questionCountTotal) {
            currentQuestion = questionList.get(questionCounter);

            textViewQuestion.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());

            questionCounter++;
            textViewQuestionCount.setText("Question: " + questionCounter + "/" + questionCountTotal);
            answered = false;
            btnConfirmNext.setText("Confirm");

            timeLeftInMillis = COUNT_DOWN_MILLIS;
            startCountDown();
        } else {
            showResult();
        }
    }

    private void showResult() {
        int maxScore =questionList.size()*2;
        Random random = new Random();
        int randomResult = random.nextInt(3);
        Toast.makeText(this, "res "+randomResult, Toast.LENGTH_SHORT).show();
        String result = "";
//        Log.d(TAG, "showResult: "+score);
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.dialog_result, (ViewGroup) findViewById(R.id.dialog_layout));
        TextView resultTextView =  layout.findViewById(R.id.text_view_resultat);
        TextView nextCategoryTextView = layout.findViewById(R.id.text_view_next_category);




        if (score>=maxScore*60/100){
            result= cuurentCategory.getAllRecomendation()[randomResult];
            newDifficulty = cuurentCategory.getRecomend1();
        }else if (score>=maxScore*30/100 && score<maxScore*60/100){
            result=cuurentCategory.getAllRecomendation()[randomResult+3];
            newDifficulty = cuurentCategory.getRecomend2();
        }else {
            result =cuurentCategory.getAllRecomendation()[randomResult+6];
            newDifficulty = cuurentCategory.getRecomend3();
        }
//        builder.setTitle(result);


        cuurentCategory.setResultForView(result);
        QuestionLab.get(this).updateCategory(cuurentCategory);
//        builder.setMessage("Может пройдете " +newDifficulty + "?");
        resultTextView.setText(result);
        nextCategoryTextView.setText("может вы пройдете "+ newDifficulty+ "?");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(layout);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(QuizActivity.this, QuizActivity.class);
                intent.putExtra(EXTRA_DIFFICULTY, newDifficulty);
                finish();
                startActivityForResult(intent, StartingScreenActivity.REQUEST_CODE_QUIZ);
            }
        });

        builder.setNegativeButton("MENU", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishQuiz();
            }
        });
        AlertDialog dialog = builder.create();

        dialog.show();

    }

    private void startCountDown() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        textViewCountDown.setText(timeFormatted);

        if (timeLeftInMillis < 10000) {
            textViewCountDown.setTextColor(Color.RED);
        } else {
            textViewCountDown.setTextColor(textColorDefaultCd);
        }
    }

    private void finishQuiz() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCORE, score);
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            finishQuiz();
        } else Toast.makeText(this, "Press back again to finish", Toast.LENGTH_SHORT).show();

        backPressedTime = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCORE, score);
        outState.putInt(KEY_QUESTION_COUNT, questionCounter);
        outState.putLong(KEY_MILLIS_LEFT, timeLeftInMillis);
        outState.putBoolean(KEY_ANSWERED, answered);
        outState.putParcelableArrayList(KEY_QUESTION_LIST,questionList);
    }

    public static Intent newIntent(Context context, String difficulty){
        Intent intent = new Intent(context, QuizActivity.class);
        intent.putExtra(EXTRA_DIFFICULTY, difficulty);
        return intent;
    }

}
