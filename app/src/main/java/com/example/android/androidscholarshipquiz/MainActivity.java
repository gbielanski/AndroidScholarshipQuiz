package com.example.android.androidscholarshipquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioButton question_1A_answer_1;
    private RadioButton question_1A_answer_2;
    private RadioButton question_1A_answer_3;

    private CheckBox question_1B_answer_1;
    private CheckBox question_1B_answer_2;
    private CheckBox question_1B_answer_3;

    private EditText question_2A_answer;

    private RadioButton question_2B_answer_1;
    private RadioButton question_2B_answer_2;
    private RadioButton question_2B_answer_3;

    private EditText question_3A_answer;
    private CheckBox question_3B_answer_1;
    private CheckBox question_3B_answer_2;
    private CheckBox question_3B_answer_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init_question_1A_views();
        init_question_1B_views();
        init_question_2A_views();
        init_question_2B_views();
        init_question_3A_views();
        init_question_3B_views();
    }

    private void init_question_3B_views() {
        question_3B_answer_1 = (CheckBox)findViewById(R.id.question_3B_answer_1);
        question_3B_answer_2 = (CheckBox)findViewById(R.id.question_3B_answer_2);
        question_3B_answer_3 = (CheckBox)findViewById(R.id.question_3B_answer_3);
    }

    private void init_question_3A_views() {
        question_3A_answer = (EditText)findViewById(R.id.question_3A_answer);
    }

    private void init_question_2B_views() {
        question_2B_answer_1 = (RadioButton)findViewById(R.id.question_2B_answer_1);
        question_2B_answer_2 = (RadioButton)findViewById(R.id.question_2B_answer_2);
        question_2B_answer_3 = (RadioButton)findViewById(R.id.question_2B_answer_3);
    }

    private void init_question_2A_views() {
        question_2A_answer = (EditText)findViewById(R.id.question_2A_answer);
    }

    private void init_question_1B_views() {
        question_1B_answer_1 = (CheckBox)findViewById(R.id.question_1B_answer_1);
        question_1B_answer_2 = (CheckBox)findViewById(R.id.question_1B_answer_2);
        question_1B_answer_3 = (CheckBox)findViewById(R.id.question_1B_answer_3);
    }

    private void init_question_1A_views() {
        question_1A_answer_1 = (RadioButton)findViewById(R.id.question_1A_answer_1);
        question_1A_answer_2 = (RadioButton)findViewById(R.id.question_1A_answer_2);
        question_1A_answer_3 = (RadioButton)findViewById(R.id.question_1A_answer_3);
    }

    public void submitAnswer(View view) {
        int score = getQuestion1AScore() + getQuestion1BScore() + getQuestion2AScore() +
                    getQuestion2BScore() + getQuestion3AScore() + getQuestion3BScore();
        String question1AAnswer = getQuestion1AAnswer();
        String question1BAnswer = getQuestion1BAnswer();
        String question2AAnswer = getQuestion2AAnswer();
        String question2BAnswer = getQuestion2BAnswer();
        String question3AAnswer = getQuestion3AAnswer();
        String question3BAnswer = getQuestion3BAnswer();
        String submitMessage =
                "Your score " + score + "/6\n" + question1AAnswer + question1BAnswer +
                question2AAnswer + question2BAnswer + question3AAnswer + question3BAnswer;
        Toast.makeText(this, submitMessage, Toast.LENGTH_LONG).show();
    }

    private String getQuestion3BAnswer() {
        if ( question_3B_answer_1.isChecked() &&
             question_3B_answer_2.isChecked() &&
            !question_3B_answer_3.isChecked())
            return getString(R.string.correct_3b);
        else
            return getString(R.string.wrong_3b);
    }

    private String getQuestion3AAnswer() {
        String answer = getString(R.string.answer_3a);
        if (question_3A_answer.getText().toString().compareTo(answer)==0)
            return getString(R.string.correct_3a);
        else
            return getString(R.string.wrong_3a);
    }

    private String getQuestion2BAnswer() {
        if (question_2B_answer_2.isChecked())
            return getString(R.string.correct_2b);
        else
            return getString(R.string.wrong_2b);
    }

    private String getQuestion2AAnswer() {
        String answer = "logcat";
        if (question_2A_answer.getText().toString().toLowerCase().compareTo(answer)==0)
            return getString(R.string.correct_2a);
        else
            return getString(R.string.wrong_2a);
    }

    private String getQuestion1BAnswer() {
        if(!question_1B_answer_1.isChecked() &&
            question_1B_answer_2.isChecked() &&
            question_1B_answer_3.isChecked())

            return getString(R.string.correct_1B);
        else
            return getString(R.string.wrong_1b);
    }
    private String getQuestion1AAnswer() {
        if (question_1A_answer_3.isChecked())
            return getString(R.string.correct_1a);
        else
            return getString(R.string.wrong_1a);
    }

    private int getQuestion3BScore() {
        if ( question_3B_answer_1.isChecked() &&
             question_3B_answer_2.isChecked() &&
            !question_3B_answer_3.isChecked())
            return 1;
        else
            return 0;
    }

    private int getQuestion3AScore() {
        String answer = "findViewById";
        if (question_3A_answer.getText().toString().compareTo(answer)==0)
            return 1;
        else
            return 0;
    }

    private int getQuestion2BScore() {
        if (question_2B_answer_2.isChecked())
            return 1;
        else
            return 0;
    }

    private int getQuestion2AScore() {
        String answer = "logcat";
        if (question_2A_answer.getText().toString().toLowerCase().compareTo(answer)==0)
            return 1;
        else
            return 0;
    }

    public int getQuestion1BScore() {
        if(!question_1B_answer_1.isChecked() &&
            question_1B_answer_2.isChecked() &&
            question_1B_answer_3.isChecked())
            return 1;
        else
            return 0;
    }
    public int getQuestion1AScore() {
        if (question_1A_answer_3.isChecked())
            return 1;
        else
            return 0;
    }


    public void resetAnswers(View view){
        reset_question_1A_answers();
        reset_question_1B_answers();
        reset_question_2A_answers();
        reset_question_2B_answers();
        reset_question_3A_answers();
        reset_question_3B_answers();
    }

    private void reset_question_3B_answers() {
        question_3B_answer_1.setChecked(false);
        question_3B_answer_2.setChecked(false);
        question_3B_answer_3.setChecked(false);
    }

    private void reset_question_3A_answers() {
        question_3A_answer.setText("");
    }

    private void reset_question_2B_answers() {
        question_2B_answer_1.setChecked(false);
        question_2B_answer_2.setChecked(false);
        question_2B_answer_3.setChecked(false);
    }

    private void reset_question_2A_answers() {
        question_2A_answer.setText("");
    }

    private void reset_question_1B_answers() {
        question_1B_answer_1.setChecked(false);
        question_1B_answer_2.setChecked(false);
        question_1B_answer_3.setChecked(false);
    }

    private void reset_question_1A_answers() {
        question_1A_answer_1.setChecked(false);
        question_1A_answer_2.setChecked(false);
        question_1A_answer_3.setChecked(false);
    }
}