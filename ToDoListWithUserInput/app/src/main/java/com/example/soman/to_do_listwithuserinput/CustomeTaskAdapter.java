package com.example.soman.to_do_listwithuserinput;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by soman on 1/9/2018.
 */

public class CustomeTaskAdapter extends BaseAdapter {

    Context context;
    ArrayList<TaskDetail> taskDetailArrayList;
    LayoutInflater inflater = null;

    public CustomeTaskAdapter(Context context, ArrayList<TaskDetail> taskDetailArrayList) {
        this.context = context;
        this.taskDetailArrayList = taskDetailArrayList;
    }

    @Override
    public int getCount() {
        return taskDetailArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return taskDetailArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if(row == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.task_list_row,null);

            TextView tile_txt = row.findViewById(R.id.title);
            TextView description_txt = row.findViewById(R.id.description);

            TaskDetail task = (TaskDetail) getItem(position);
            tile_txt.setText(task.getTitle());
            description_txt.setText(task.getDescription());

        }

        return row;
    }
}
