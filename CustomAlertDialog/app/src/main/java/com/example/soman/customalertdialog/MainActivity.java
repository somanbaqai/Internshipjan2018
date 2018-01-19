package com.example.soman.customalertdialog;


import android.app.Dialog;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button dialogButtonOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialogButtonOk = findViewById(R.id.dialogButtonOk);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onClickCustomShowButton(View view){
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setTitle(R.string.title);

        dialog.setContentView(R.layout.custome_dialog);

        TextView textView = (TextView) dialog.findViewById(R.id.text);
        textView.setText("Custom Alert Dialog Box Example....");


        ImageView imageView = (ImageView) dialog.findViewById(R.id.image);
        imageView.setImageResource(R.mipmap.ic_launcher_round);

        Button buttonDialog = dialog.findViewById(R.id.dialogButtonOk);
        buttonDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }


        });

        dialog.create();
        dialog.show();


    }
}
