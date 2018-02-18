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
    private RadioButton questions1_a, questions1_b, questions1_c, questions1_d;
    private RadioButton questions2_a, questions2_b, questions2_c, questions2_d;
    private RadioButton questions3_a, questions3_b, questions3_c, questions3_d;
    private RadioButton questions4_a, questions4_b, questions4_c, questions4_d;
    private CheckBox questions5_a, questions5_b, questions5_c, questions5_d;
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

        questions1_a = findViewById(R.id.questions1_a);
        boolean isLosAngele = questions1_a.isChecked();

        questions2_a = findViewById(R.id.questions2_a);
        boolean isLux = questions2_a.isChecked();

        questions3_c = findViewById(R.id.questions3_c);
        boolean isPiano = questions3_c.isChecked();

        questions4_b = findViewById(R.id.questions4_b);
        boolean isWings = questions4_b.isChecked();

        questions5_a = findViewById(R.id.questions5_a);
        boolean isMazekChecked = questions5_a.isChecked();

        questions5_b = findViewById(R.id.questions5_b);
        boolean isMazek1Checked = questions5_b.isChecked();

        questions5_c = findViewById(R.id.questions5_c);
        boolean isBuzeChecked = questions5_c.isChecked();

        questions5_d = findViewById(R.id.questions5_d);
        boolean isBuze1Checked = questions5_d.isChecked();

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

    public int calculateScore(boolean isLosAngeles, boolean isLux, boolean isPiano,
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