package com.example.quiz;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private boolean isChecking = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RadioGroup question_6_set1 = (RadioGroup) findViewById(R.id.question_6_set1);
        final RadioGroup question_6_set2 = (RadioGroup) findViewById(R.id.question_6_set2);

        final RadioGroup.OnCheckedChangeListener question6Set1Listener = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    question_6_set2.clearCheck();
                }
                isChecking = true;
            }
        };

        final RadioGroup.OnCheckedChangeListener question6Set2Listener = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    question_6_set1.clearCheck();
                }
                isChecking = true;
            }
        };

        question_6_set1.setOnCheckedChangeListener(question6Set1Listener);

        question_6_set2.setOnCheckedChangeListener(question6Set2Listener);
    }

    /*
    * This method runs when submit is clicked
    * @param View
     */

    public void submit(View view) {
        int score = 0;
        // Checking answer for question 1
        TextView question_1 = (TextView) findViewById(R.id.question_1);
        Log.v("Question 1", question_1.getText().toString());
        if (question_1.getText().toString().equals("earth") || question_1.getText().toString().equals("Earth")) score++;

        //Checking answer for question 2
        if (((RadioButton) findViewById(R.id.question_2_mercury)).isChecked() == true) score++;

        //Checking answer for question 3
        if (((RadioButton) findViewById(R.id.question_3_saturn)).isChecked() == true) score++;

        //Checking answer for question 4
        CheckBox question4Mercury = (CheckBox) findViewById(R.id.question_4_mercury);
        CheckBox question4Earth = (CheckBox) findViewById(R.id.question_4_earth);
        CheckBox question4Saturn = (CheckBox) findViewById(R.id.question_4_saturn);
        CheckBox question4Venus = (CheckBox) findViewById(R.id.question_4_venus);

        if (question4Mercury.isChecked() &&
                question4Venus.isChecked() &&
                !question4Earth.isChecked() &&
                !question4Saturn.isChecked()) score++;

        //Checking answer for question 5
        if (((RadioButton) findViewById(R.id.question_5_9)).isChecked() == true) score++;

        //Checking answer for question 6
        if (((RadioButton) findViewById(R.id.question_6_venus)).isChecked() == true) score++;

        Toast.makeText(this, "Your score is: " + score + " out of 6", Toast.LENGTH_SHORT).show();
    }
}
