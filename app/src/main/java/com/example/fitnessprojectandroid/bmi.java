package com.example.fitnessprojectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class bmi extends AppCompatActivity {
    private EditText h;
    private EditText w;
    private TextView r;
    private TextView l;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_layout);

        button = (Button) findViewById(R.id.btn);
        h = (EditText) findViewById(R.id.height);
        w = (EditText) findViewById(R.id.weight);
        r = (TextView) findViewById(R.id.result);
        l = (TextView) findViewById(R.id.label);

    }
    public void calculateBmi(View v){
        String heightStr = h.getText().toString();
        String weightStr = w.getText().toString();

        float heightValue = Float.parseFloat(heightStr) / 100;
        float weightValue = Float.parseFloat(weightStr);
        float bmi = weightValue / (heightValue * heightValue);
        r.setText(String.valueOf(bmi));
        displayBmi(bmi);
    }

    private void displayBmi(float bmi){
        String bmiLabel = "";

        if(bmi <= 18){
            bmiLabel = "Under Weight";
        }
        else if(bmi >= 18 && bmi <= 24){
            bmiLabel = "Good";
        }

        else{
            bmiLabel = "Over Weight";
        }
        l.setText(String.valueOf(bmiLabel));
        r.setText(String.format("%.2f", bmi));
    }

}
