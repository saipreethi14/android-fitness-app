package com.example.fitnessprojectandroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Fooddescription extends Activity {
    ImageView mainImageview;
    TextView title,description;

    String data1,data2;
    int myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fooddescription);

        mainImageview = findViewById(R.id.mainImageView);
        title = findViewById(R.id.titleid);
        description = findViewById(R.id.desceiptionid);
        getData();
        setData();
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