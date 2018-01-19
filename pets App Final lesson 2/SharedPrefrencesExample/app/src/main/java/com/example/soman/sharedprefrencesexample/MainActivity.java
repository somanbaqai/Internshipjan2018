package com.example.soman.sharedprefrencesexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email_edit;
    EditText pass_edit;
    Button signIn_btn;
    CheckBox rememberMe_check;
    Button display_pref_data_btn;
    TextView display_pref_data_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences = getSharedPreferences("userInfo",Context.MODE_PRIVATE);

        email_edit = findViewById(R.id.email_et);
        pass_edit = findViewById(R.id.Password_et);
        signIn_btn = findViewById(R.id.sign_in_btn);
        rememberMe_check = findViewById(R.id.Remember_Me_check_box);
        display_pref_data_btn = findViewById(R.id.pref_data_btn);
        display_pref_data_tv = findViewById(R.id.pref_data_tv);




        if(sharedPreferences.contains("username") && sharedPreferences.contains("password")){

            startLogin(sharedPreferences);

        }

        signIn_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptLogin();
            }
        });

        display_pref_data_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPreferenceData();
            }
        });


    }

    public void startLogin(SharedPreferences sharedPreferences){
        String email = sharedPreferences.getString("username","invalid username");
        String pass = sharedPreferences.getString("password","invalid password");

        display_pref_data_tv.setText(email + "  |  " +pass);
    }

    private void getPreferenceData() {

        SharedPreferences sharedPreferences = getSharedPreferences("userInfo",Context.MODE_PRIVATE);

        String email = sharedPreferences.getString("username","invalid username");
        String pass = sharedPreferences.getString("password","invalid password");

            display_pref_data_tv.setText(email + "  |  " +pass);
    }

    private void attemptLogin() {



        String email = email_edit.getText().toString();
        String password = pass_edit.getText().toString();

        if(email.equals("soman.baqai@gmail.com") && password.equals("12345") ){
            SharedPreferences sharedPreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("username",email);
            editor.putString("password",password);
            editor.apply();
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
        }





    }
}
