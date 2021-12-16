package com.example.fitnessprojectandroid;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {
    public Button exerciseb1;
    public Button bmib2;
    public Button coachb3;
    public Button dietb4;
    public Button aboutusb5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        exerciseb1 = (Button) findViewById(R.id.exercisebntid);
        bmib2 = (Button) findViewById(R.id.bmibtnid);
        coachb3 = (Button) findViewById(R.id.Coachbtnid);
        dietb4 = (Button) findViewById(R.id.dietbtnid);
        aboutusb5 = (Button) findViewById(R.id.ABoutbtnid);

        exerciseb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        bmib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        coachb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        dietb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        aboutusb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
