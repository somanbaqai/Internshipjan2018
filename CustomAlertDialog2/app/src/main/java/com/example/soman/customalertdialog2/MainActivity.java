package com.example.soman.customalertdialog2;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button showDiaogButton = findViewById(R.id.btnShowDialog);
        showDiaogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                View view = getLayoutInflater().inflate(R.layout.dialog_login,null);
                final EditText editTextEmail = (EditText) view.findViewById(R.id.etEmail);
                final EditText editTextPassword = (EditText) view.findViewById(R.id.etPassword);
//                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
 //                   @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        if(!editTextEmail.getText().toString().isEmpty() && !editTextPassword.getText().toString().isEmpty()){
//                            Toast.makeText(MainActivity.this, "succedd", Toast.LENGTH_SHORT).show();
//                            dialog.dismiss();
//
//                        }
//                        else{
//                            Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
                Button btnLogin = (Button) view.findViewById(R.id.btnLogin);
                btnLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!editTextEmail.getText().toString().equals("")){
                            Toast.makeText(MainActivity.this, "succedd", Toast.LENGTH_SHORT).show();
                           builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                               @Override
                               public void onDismiss(DialogInterface dialog) {
                                   dialog.dismiss();
                               }
                           });

                        }
                        else{
                            Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}
