package com.example.fitnessprojectandroid;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListExercise extends AppCompatActivity {
    RecyclerView recyclerView;

    String e1[], e2[];
    int image[] = {R.drawable.exr6,R.drawable.exr5,R.drawable.exr4,R.drawable.exr3,R.drawable.exr2,R.drawable.exr1,R.drawable.exr0};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = getResources().getStringArray(R.array.exercise_name);
        e2 = getResources().getStringArray(R.array.Description);
        recyclerView = findViewById(R.id.recyclerView);

        My_Adapter my_adapter = new My_Adapter(this,e1,e2,image);
        recyclerView.setAdapter(my_adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}