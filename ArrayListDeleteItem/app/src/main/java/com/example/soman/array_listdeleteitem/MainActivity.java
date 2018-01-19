package com.example.soman.array_listdeleteitem;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<CarDetails> carDetailsArrayList;

    CarDetails car;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carDetailsArrayList = new ArrayList<>();
        listView = findViewById(R.id.listView);

        carDetailsArrayList.add(new CarDetails("alto", 123));
        carDetailsArrayList.add(new CarDetails("swift", 456));
        carDetailsArrayList.add(new CarDetails("mera", 789));
        carDetailsArrayList.add(new CarDetails("fit", 147));
        carDetailsArrayList.add(new CarDetails("aqua", 258));


        final CustomCarAdapter customCarAdapter = new CustomCarAdapter(carDetailsArrayList, this);
        listView.setAdapter(customCarAdapter);
        customCarAdapter.notifyDataSetChanged();
        

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
                carDetailsArrayList.remove(position);
                customCarAdapter.notifyDataSetChanged();
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Delete Item");
                builder.setMessage("Are you sure you want to delete?");
                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        carDetailsArrayList.remove(position);
                        customCarAdapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                         dialog.dismiss();
                            }
                        });
                           AlertDialog dialog = builder.create();
                           dialog.show();
                return false;
            }



        });




    }
}
