package com.example.fitnessprojectandroid;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DietPage extends AppCompatActivity {

   RecyclerView recycleView;
    String s1[], s2[];
    int images[] = {R.drawable.almonds, R.drawable.chicken, R.drawable.egg, R.drawable.fish, R.drawable.milk, R.drawable.pulse, R.drawable.proteinpowder
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dietpage);

        recycleView = findViewById(R.id.recycleView);
        s1 = getResources().getStringArray(R.array.food_name);
        s2 = getResources().getStringArray(R.array.description11);
        recycleView.addItemDecoration(new DividerItemDecoration(DietPage.this, DividerItemDecoration.VERTICAL));


        MyAdapter myAdapter = new MyAdapter(this,s1,s2,images);
  recycleView.setAdapter(myAdapter);
  recycleView.setLayoutManager(new LinearLayoutManager(this));
    }
}