package com.example.soman.customerspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> listsource = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateData();
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        android.widget.SpinnerAdapter  adapter = new SpinnerAdapter(listsource,MainActivity.this);
        spinner.setAdapter(adapter);spinner.setDropDownVerticalOffset(100);


    }

    private void generateData() {
        for(int i =0;i<10;i++){
            listsource.add("Item: " + i);
        }
    }
}
