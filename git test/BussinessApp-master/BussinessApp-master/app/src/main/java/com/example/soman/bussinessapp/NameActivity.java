package com.example.soman.bussinessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        final EditText editText = (EditText) findViewById(R.id.textname);
      Button ActivityChangeButton = (Button) findViewById(R.id.ActivityChangeButton);
        ActivityChangeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                Intent intent = new Intent(v.getContext(),MainActivity.class);
                intent.putExtra("Name",name);
                startActivity(intent);
            }
        });
    }
}
