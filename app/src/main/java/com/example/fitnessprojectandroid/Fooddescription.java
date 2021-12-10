package com.example.fitnessprojectandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class Fooddescription extends Activity {
    ImageView mainImageview;
    TextView title,description;
    Button  timerbtn;

    String data1,data2;
    int myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fooddescription);

        mainImageview = findViewById(R.id.mainImageView);
        title = findViewById(R.id.titleid);
        description = findViewById(R.id.desceiptionid);
        timerbtn = findViewById(R.id.reminderbtnid);

        timerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Fooddescription.this, TimeReminder.class));
                finish();
            }
        });
        getData();
        setData();

//        Intent i = new Intent(Fooddescription.this, TimePicker.class);
//        i.putExtra("key",data1);
//        startActivity(i);

    }
    private void getData(){
        if(getIntent().hasExtra("myImage") && getIntent().hasExtra("data1") && getIntent().hasExtra("data2")){
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            myImage = getIntent().getIntExtra("myImage",1);

        }else {
            Toast.makeText(this,"NO DATA",Toast.LENGTH_SHORT).show();
        }
    }
    private void setData(){
        title.setText(data1);
        description.setText(data2);
        mainImageview.setImageResource(myImage);

    }
}