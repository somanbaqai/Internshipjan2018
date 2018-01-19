package com.example.soman.bussinessapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.*;

import static android.support.design.widget.Snackbar.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView titleText = findViewById(R.id.titleResturant);
        ImageView titleImage = findViewById(R.id.burgermain);
        TextView sloganText = findViewById(R.id.slogan);
        ImageView phoneImage = findViewById(R.id.phoneImage);
        TextView phoneText = findViewById(R.id.phoneNumber);
        ImageView emailImage = findViewById(R.id.emailImage);
        TextView emailText = findViewById(R.id.emailText);
        ImageView addressImage = findViewById(R.id.locationImage);
        TextView addressText = findViewById(R.id.addressText);
        final EditText editText = findViewById(R.id.editt);
        Button buttonName = findViewById(R.id.buttonName);
        final TextView textView = findViewById(R.id.nameText);

        buttonName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = String.valueOf(editText.getText());
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

                textView.setText(str);

            }
        });


        addressText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //          Toast.makeText(MainActivity.this, "Address Text Clicked", Toast.LENGTH_SHORT).show();
                Snackbar snackbar = Snackbar.make(findViewById(R.id.mainn), "Snackbar Opened", LENGTH_LONG).setAction("retry?", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Retry Clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                snackbar.setActionTextColor(Color.WHITE);

                View sbView = snackbar.getView();
                TextView snackbarText = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                snackbarText.setTextColor(Color.BLUE);
                snackbar.show();
            }
        });
        addressImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Address Image Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        emailText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Email Text Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        emailImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Email Image Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        phoneText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Phone Number Text Cliked", Toast.LENGTH_SHORT).show();
            }
        });
        phoneImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Phone Image Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        sloganText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Slogan Text Cliked", Toast.LENGTH_SHORT).show();
            }
        });
        titleImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, "Title Image Clicked", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        titleText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Exit Alert!");
                builder.setMessage("Do You Want To Exit?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.this.finish();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Title Text Clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });


    }

}
