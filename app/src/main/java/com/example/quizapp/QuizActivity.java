package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.quizapp.databinding.ActivityQuizBinding;

public class QuizActivity extends AppCompatActivity {
    private ActivityQuizBinding binding;
    private String name;
    private String gender;
    private int mScore;
    private RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityQuizBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        quizScore();
        getIntents();
        message();
    }

    /**
     * this method is to get data from the from the MainActivity
     * get name and gender
     */
    private void getIntents() {
        Intent intent = getIntent();
        if (intent != null) {
            name = intent.getStringExtra("name");
            gender = intent.getStringExtra("gender");
        }
    }

    /**
     * using if/else statement to use gender and start the Toast message
     *
     * @return msg
     */
    private String message() {
        String msg = "";
        if (getString(R.string.male).equals(gender))
            msg = getString(R.string.welcomeMr) + name;
        else if (getString(R.string.female).equals(gender))
            msg = getString(R.string.welcomeMs) + name;
        msg += "\n" + getString(R.string.yourScore) + mScore;
        msg += "\nThank you.";
        return msg;
    }

    /**
     * this method is to combine all questions scores and show the Toast score message
     * by using OnClickListener method
     */
    private void quizScore() {
        binding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                one();
                two();
                three();
                four();
                five();
                six();
                Toast.makeText(QuizActivity.this, message(), Toast.LENGTH_LONG).show();
                mScore = 0;
            }
        });
    }

    /**
     * question 1
     * we using ViewBinding instead of findViewById with some components
     * other components can not unfortunately change using of findViewById
     */
    private void one() {
        int selectedId = binding.questionOneAnswer.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);
        if (radioButton.getText().equals(getString(R.string.yes))) {
            mScore++;
        }
    }

    /**
     * question 2
     */
    private void two() {
        int selectedId = binding.questionTwoAnswer.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);
        if (radioButton.getText().equals(getString(R.string.code))) {
            mScore++;
        }
    }

    /**
     * question 3
     */
    private void three() {
        int selectedId = binding.questionThreeAnswer.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);
        if (radioButton.getText().equals(getString(R.string.loop))) {
            mScore++;
        }
    }

    /**
     * question 4
     */
    private void four() {
        int selectedId = binding.questionFourAnswer.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);
        if (radioButton.getText().equals(getString(R.string.bug))) {
            mScore++;
        }
    }

    /**
     * question 5
     */
    private void five() {
        if (binding.questionFiveCheck1.isChecked()
                && binding.questionFiveCheck2.isChecked()
                && !binding.questionFiveCheck3.isChecked()) {
            mScore++;
        }
    }

    /**
     * question 6
     */
    private void six() {
        if (binding.questionSixAnswer.getText().toString().trim().equals("computerScience")
                || binding.questionSixAnswer.getText().toString().trim().equals("ComputerScience"))
            mScore++;
    }
}