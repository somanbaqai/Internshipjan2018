package com.example.soman.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<TaskDetail> taskDetailArrayList;
    Button add_task_btn;
    TaskDetail task = new TaskDetail();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        listView = findViewById(R.id.listview);
        taskDetailArrayList = new ArrayList<>();

   //     add_task_btn = findViewById(R.id.add_task_btn);
        getDataForTaskList();
        CustomeBaseAdapter adapter = new CustomeBaseAdapter(this,taskDetailArrayList);
        listView.setAdapter(adapter);

    }

    private void getDataForTaskList() {
//        taskDetailArrayList.add(new TaskDetail("title","description"));
//        taskDetailArrayList.add(new TaskDetail("title","description"));
//        taskDetailArrayList.add(new TaskDetail("title","description"));
//        taskDetailArrayList.add(new TaskDetail("title","description"));
//        taskDetailArrayList.add(new TaskDetail("title","description"));
//        taskDetailArrayList.add(new TaskDetail("title","description"));
//        taskDetailArrayList.add(new TaskDetail("title","description"));
//        taskDetailArrayList.add(new TaskDetail("title","description"));
//        taskDetailArrayList.add(new TaskDetail("title","description"));


        for(int i =0;i<= 2;i++){
            task.setTitle("task : " );
            task.setDescription("sdasdsadsdasdsdsa : " + (i+1) );
            taskDetailArrayList.add(task);

        }

    }

    public void OnClickAddButton(View view){
        task.setTitle("click task");
        task.setDescription("descriptionnnnnnnnnn tan tan tana tannnn");
        taskDetailArrayList.add(task);
        CustomeBaseAdapter adapter = new CustomeBaseAdapter(this,taskDetailArrayList);
        listView.setAdapter(adapter);
    //    adapter.notifyDataSetChanged();



    }
}
