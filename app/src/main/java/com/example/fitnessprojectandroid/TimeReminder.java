package com.example.fitnessprojectandroid;

import android.app.AlarmManager;
import android.app.AppComponentFactory;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class TimeReminder extends AppCompatActivity implements View.OnClickListener {


    private int notifications = 1;
    String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_reminderpage);
        findViewById(R.id.setbtn).setOnClickListener(this);
        findViewById(R.id.cancelbtn).setOnClickListener(this);



    }
    @Override
    public void onClick(View view) {
        TextView tx = findViewById(R.id.itemnameid);
        TimePicker timepicker = findViewById(R.id.timepicker);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getString("key");
            tx.setText(value);
        }

        Intent intent = new Intent(TimeReminder.this,Alarmclass.class);
        intent.putExtra("notificationid",notifications);
        intent.putExtra("todo",value);

        PendingIntent alarmIntent = PendingIntent.getBroadcast(TimeReminder.this,0,
                intent,PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager alarm = (AlarmManager) getSystemService(ALARM_SERVICE);

        switch (view.getId()){
            case R.id.setbtn:
                int hour = timepicker.getCurrentHour();
                int minute = timepicker.getCurrentMinute();

                Calendar startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY,hour);
                startTime.set(Calendar.MINUTE,minute);
                startTime.set(Calendar.SECOND,0);
                long alarmStartTime = startTime.getTimeInMillis();

                alarm.set(AlarmManager.RTC_WAKEUP,alarmStartTime,alarmIntent);
                Toast.makeText(this,"Done!",Toast.LENGTH_SHORT).show();
                break;

            case R.id.cancelbtn:
                alarm.cancel(alarmIntent);
                Toast.makeText(this,"Canceled",Toast.LENGTH_SHORT).show();
                break;

                }
    }
}