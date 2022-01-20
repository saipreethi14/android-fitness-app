package com.example.fitnessprojectandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Threebutton extends AppCompatActivity {
    Button low;
    Button good;
    Button fat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.three_buttonspage);
        low = (Button) findViewById(R.id.lowid);
        good = (Button) findViewById(R.id.goodis);
        fat = (Button) findViewById(R.id.fatid);

        low.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Threebutton.this,DietPage.class);
                startActivity(i);
            }
        });
        good.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(Threebutton.this,DietPage.class);
                startActivity(j);
            }
        });
        fat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(Threebutton.this,DietPage.class);
                startActivity(k);
            }
        });
    }
}
