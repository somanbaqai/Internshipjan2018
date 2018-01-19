package com.example.soman.basicinput;

import android.content.Context;
import android.content.Intent;
import android.hardware.input.InputManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.*;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
//        Button button = findViewById(R.id.button);

 //       final TextView textView = findViewById(R.id.textt);

//
//     //   button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//            }
//        });
    }
    protected void onClickButton(View view){

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("input",editText.getText().toString());
        startActivity(intent);
    }
}
