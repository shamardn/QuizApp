package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                intent.putExtra("name", getName());
                intent.putExtra("gender", getGender());
                MainActivity.this.startActivity(intent);
            }
        });
    }

    /**
     * method to getName from EditText to send it in intent to surveyActivity
     *
     * @return name
     */
    private String getName() {

        return binding.writeName.getText().toString();
    }

    /**
     * method to getGender from RadioGroup to send it in intent to surveyActivity
     *
     * @return gender
     */
    private String getGender() {
        int gValue = binding.genderRadio.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(gValue);
        return radioButton.getText().toString();
    }
}
