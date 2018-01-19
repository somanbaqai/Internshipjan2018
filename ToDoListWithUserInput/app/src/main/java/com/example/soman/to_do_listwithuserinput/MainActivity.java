package com.example.soman.to_do_listwithuserinput;

import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
        ArrayList<TaskDetail> taskDetailArrayList;
        ListView listView;
        EditText  title_txt;
        EditText description_txt;
        FloatingActionButton create_task;

        TaskDetail task;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        taskDetailArrayList = new ArrayList<>();

     //   taskDetailArrayList.add(new TaskDetail("soman","description: 1"));
     //   taskDetailArrayList.add(new TaskDetail("soman","description: 1"));

        listView = findViewById(R.id.list_view);
//        CustomeTaskAdapter adapter = new CustomeTaskAdapter(this,taskDetailArrayList);
//        listView.setAdapter(adapter);
//        create_task =  findViewById(R.id.create_task);

    }

    public void onClickCreateNewTask(View view){

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.insert_task_layout,null);
        title_txt = dialogView.findViewById(R.id.new_title);
        description_txt = dialogView.findViewById(R.id.new_description);
        task = new TaskDetail();
        builder.setPositiveButton("Insert Task", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
         //       task.setTitle(title_txt.getText().toString());
         //       task.setDescription(description_txt.getText().toString());
                taskDetailArrayList.add(new TaskDetail(title_txt.getText().toString(),description_txt.getText().toString()));
                CustomeTaskAdapter adapter = new CustomeTaskAdapter(MainActivity.this,taskDetailArrayList);
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();


            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.setView(dialogView);
        AlertDialog dialog = builder.create();
        dialog.show();



    }

}
