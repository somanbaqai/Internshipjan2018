package com.example.soman.checkboxandradiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBox;
    RadioButton radioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickCheckBox(View view) {
        checkBox = (CheckBox) findViewById(R.id.check);
        if (checkBox.isChecked()) {
            Toast.makeText(this, "check box Checked", Toast.LENGTH_SHORT).show();
        }


    }
    public void onClickRadioButton(View view){
        radioButton = (RadioButton) findViewById(R.id.radi);
        if(radioButton.isChecked()){
            Toast.makeText(this, "Radio Button Checked", Toast.LENGTH_SHORT).show();
        }
    }
}
