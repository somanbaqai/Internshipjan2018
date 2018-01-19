package com.example.soman.spinnerexample2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner1;
    private Spinner spinner2;
    private Button btnSubmit;
    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addItemsOnSpinner2();
        addListnerOnButon();
        addListenerOnListItemSelection();

    }

    private void addItemsOnSpinner2() {
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        list = new ArrayList<String>();
        list.add("Select");
        list.add("item 1");
        list.add("item 2");
        list.add("abc");
        list.add("item 4");
        list.add("item 5");
        list.add("item 6");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);
        spinner2.setSelection(3);

    }
    private void addListenerOnListItemSelection() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());

    }



    private void addListnerOnButon() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "OnClickListener: " +
                        "\nspinner1 : " + String.valueOf(spinner1.getSelectedItem()) +
                        "\nspinner2 : " + String.valueOf(spinner2.getSelectedItem()),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

}
