package com.example.soman.layoutvisibility;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    Button layoutA_btn;
    Button layoutB_btn;
    RelativeLayout layoutA;
    RelativeLayout layoutB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutA_btn = findViewById(R.id.layoutA_btn);
        layoutB_btn = findViewById(R.id.layoutB_btn);

        layoutA = findViewById(R.id.layoutA);
        layoutB = findViewById(R.id.layoutB);

        layoutA_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutA.setVisibility(View.GONE);
                layoutB.setVisibility(View.VISIBLE);

            }
        });

        layoutB_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutB.setVisibility(View.GONE);
                layoutA.setVisibility(View.VISIBLE);


            }
        });


    }
}
