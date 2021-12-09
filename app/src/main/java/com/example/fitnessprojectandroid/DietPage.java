package com.example.fitnessprojectandroid;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DietPage extends AppCompatActivity {

   RecyclerView recycleView;
    String s1[], s2[];
    int images[] = {R.drawable.almond, R.drawable.chicken, R.drawable.eggs, R.drawable.fish, R.drawable.milk, R.drawable.pulses, R.drawable.proteinpowder
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dietpage);

        recycleView = findViewById(R.id.recycleView);
        s1 = getResources().getStringArray(R.array.food_name);
        s2 = getResources().getStringArray(R.array.Description);

MyAdapter myAdapter = new MyAdapter(this,s1,s2,images);
  recycleView.setAdapter(myAdapter);
  recycleView.setLayoutManager(new LinearLayoutManager(this));
    }
}