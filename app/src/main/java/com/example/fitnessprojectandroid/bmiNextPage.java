package com.example.fitnessprojectandroid;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class bmiNextPage extends AppCompatActivity {
    public TextView tx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bminextpage_layout);
        tx = (TextView) findViewById(R.id.textView5);

    }
}