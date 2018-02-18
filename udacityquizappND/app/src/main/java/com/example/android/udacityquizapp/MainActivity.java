package com.example.android.udacityquizapp;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static final String STATE_USER = "user";
    String result;
    int points;
    private String mUser;
    private RadioButton questions1ALosAngelos, questions1_b, questions1_c, questions1_d;
    private RadioButton questions2ALux, questions2_b, questions2_c, questions2_d;
    private RadioButton questions3_a, questions3_b, questions3CPiano, questions3_d;
    private RadioButton questions4_a, questions4BWings, questions4_c, questions4_d;
    private CheckBox questions5AMazikeen, questions5BMmazikeen, questions5CBazikeen, questions5DBazikeen;
    private EditText questions6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Check whether we're recreating a previously destroyed instance
        if (savedInstanceState != null) {
            // Restore value of members from saved state
            mUser = savedInstanceState.getString(STATE_USER);
        } else {
            // Probably initialize members with default values for a new instance
            mUser = "NewUser";
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString(STATE_USER, mUser);
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    /**
     * This method is called when the submit button is clicked
     */
    public void ShowScore(View view) {

        questions1ALosAngelos = findViewById(R.id.checkQuestion1ALosAngeles);
        boolean isLosAngele = questions1ALosAngelos.isChecked();

        questions2ALux = findViewById(R.id.checkQuestion2ALux);
        boolean isLux = questions2ALux.isChecked();

        questions3CPiano = findViewById(R.id.checkQuestion3CPiano);
        boolean isPiano = questions3CPiano.isChecked();

        questions4BWings = findViewById(R.id.checkQuestion4BWings);
        boolean isWings = questions4BWings.isChecked();

        questions5AMazikeen = findViewById(R.id.checkQuestion5AMazikeen);
        boolean isMazekChecked = questions5AMazikeen.isChecked();

        questions5BMmazikeen = findViewById(R.id.checkQuestion5BMazikeen);
        boolean isMazek1Checked = questions5BMmazikeen.isChecked();

        questions5CBazikeen = findViewById(R.id.checkQuestion5CBazikeen);
        boolean isBuzeChecked = questions5CBazikeen.isChecked();

        questions5DBazikeen = findViewById(R.id.checkQuestion5DBazikeen);
        boolean isBuze1Checked = questions5DBazikeen.isChecked();

        questions6 = findViewById(R.id.questions6);
        String answerNum = questions6.getText().toString();


        points = calculateScore(isLosAngele, isLux, isPiano, isWings, isMazek1Checked,
                isMazekChecked, isBuzeChecked, isBuze1Checked, isAnswerNumber(answerNum));
        Resources res = getResources();
        if (points == 7) {
            result = res.getString(R.string.result1, points);
        } else if (points > 3) {
            result = res.getString(R.string.result2, points);
        } else if (points > 0) {
            result = res.getString(R.string.result3, points);
        } else if (points == 0) {
            result = res.getString(R.string.result4, points);
        }

        Toast toast = Toast.makeText(getApplicationContext(), result,
                Toast.LENGTH_LONG);
        toast.show();

    }

    private boolean isAnswerNumber(String answerNum) {
        try {
            int number = Integer.parseInt(answerNum);
            if (number == 5) {
                return (true);
            } else return (false);
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * This method is count our score
     */

    private int calculateScore(boolean isLosAngeles, boolean isLux, boolean isPiano,
                               boolean isWings, boolean isMazek1Checked, boolean isMazekChecked,
                               boolean isBuzeChecked, boolean isBuze1Checked,
                               boolean isAnswerNumber) {
        int points = 0;
        if (isLosAngeles) {
            points += 1;
        }

        if (isLux) {
            points += 1;
        }

        if (isPiano) {
            points += 1;
        }

        if (isWings) {
            points += 1;
        }

        if (isMazek1Checked) {
            points += 1;
        }

        if (isMazekChecked) {
            points += 1;
        }

        if (isBuzeChecked) {
            points -= 1;
        }

        if (isBuze1Checked) {
            points -= 1;
        }

        if (isAnswerNumber) {
            points += 1;
        }
        return points;
    }

    /**
     * This method is called when the reset button is clicked
     */
    // start again our quiz
    public void reset(View view) {
        setContentView(R.layout.activity_main);
    }
}