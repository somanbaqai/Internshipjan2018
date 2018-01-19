package com.example.soman.datetimepicker;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DatePicker dp = findViewById(R.id.dp);
        final TimePicker tp = findViewById(R.id.tp);



        final TextView tv = findViewById(R.id.tv);
        int date = dp.getDayOfMonth();
        int month = dp.getMonth();
        int year = dp.getYear();
        float f = dp.getY();

        tv.setText(String.valueOf(month)+ " " + String.valueOf(date) + " " +String.valueOf(year));

        tv.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                int date = tp.getBaseline();
                int month = tp.getHour();
                int year = tp.getMinute();

                tv.setText(String.valueOf(month



                )+ " " + String.valueOf(year) + " " +String.valueOf(date));

            }
        });
    }
}
