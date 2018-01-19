package com.example.soman.implicentintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText ;//=(EditText) findViewById(R.id.editText);
    Button emailButton  ;//= (Button) findViewById(R.id.emailButton);
    Button browserButton  ;//  = (Button) findViewById(R.id.browserButton);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         editText = findViewById(R.id.editText);
        emailButton  = findViewById(R.id.emailButton);
         browserButton    = findViewById(R.id.browserButton);
    }

    public void SendEmail(View view){
        Intent i = new Intent(Intent.ACTION_SEND);
        String recipent = "soman.baqai@gmail.com";
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_EMAIL,recipent);
        i.putExtra(Intent.EXTRA_SUBJECT,"THis is subject");
        String message = editText.getText().toString();
        i.putExtra(Intent.EXTRA_TEXT,message);
        if(i.resolveActivity(getPackageManager() ) != null){
            startActivity(i);

        }


    }
    public void OpenBrowser (View view){
        String num = "03413160187";
        Intent i = new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:" + num));
//        Intent i = new Intent();
//        i.setAction(Intent.ACTION_VIEW);
//        i.setData(Uri.parse("http://www.google.com"));
        if(i.resolveActivity(getPackageManager()) != null){
            startActivity(i);

        }

    }

}
