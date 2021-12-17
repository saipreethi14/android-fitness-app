package com.example.fitnessprojectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class descriptionActivity extends AppCompatActivity {
    ImageView mainImageView;
    TextView title, description;

    String data1,data2;
    int myImage;
    public Button timebtn;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        mainImageView = findViewById(R.id.imageView1);
        title = findViewById(R.id.titleid);
        description = findViewById(R.id.descriptionid);
        timebtn = findViewById(R.id.timesetbtnid);

        timebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(descriptionActivity.this,TimeReminder.class);
                startActivity(i);
            }
        });

        getData();
        setData();
    }
    private void getData(){
        if(getIntent().hasExtra("myImage") && getIntent().hasExtra("data1")
                && getIntent().hasExtra("data2")){
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            myImage = getIntent().getIntExtra("myImage", 1);

        }else{
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }

    }
    private void setData(){
        title.setText(data1);
        description.setText(data2);
        mainImageView.setImageResource(myImage);
    }
}