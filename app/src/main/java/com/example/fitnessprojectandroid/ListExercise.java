package com.example.fitnessprojectandroid;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListExercise extends AppCompatActivity {
    RecyclerView recyclerView;

    String e1[], e2[];
    int image[] = {R.drawable.sidetwist,R.drawable.feetelevated,R.drawable.lyinglegexr,R.drawable.windsheildwipers,R.drawable.wheelroller,R.drawable.sideplank,R.drawable.frontplank};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_exercise);

        e1 = getResources().getStringArray(R.array.exercise_name);
        e2 = getResources().getStringArray(R.array.Description);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(ListExercise.this, DividerItemDecoration.VERTICAL));


        My_Adapter my_adapter = new My_Adapter(this,e1,e2,image);
        recyclerView.setAdapter(my_adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}