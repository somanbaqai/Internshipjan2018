package com.example.soman.basicinput;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView tv = findViewById(R.id.tv);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String str = getIntent().getStringExtra("inputtxt");
        tv.setText(str);

    }

}
