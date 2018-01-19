package com.example.soman.todolist;

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

public class CustomeBaseAdapter extends BaseAdapter{

    Context context;

    static LayoutInflater inflater = null;

    ArrayList<TaskDetail> taskDetailArrayList;


    public CustomeBaseAdapter(Context context,ArrayList<TaskDetail> taskDetailArrayList) {
        this.context = context;
        this.taskDetailArrayList = taskDetailArrayList;
    }

    @Override
    public int getCount() {
        return this.taskDetailArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.taskDetailArrayList.get(position);
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
            row = inflater.inflate(R.layout.list_view_of_row, null);

            TextView descriptionTextView = row.findViewById(R.id.description);
            TextView titleTextView = row.findViewById(R.id.title);
            TaskDetail taskDetail =  (TaskDetail) getItem(position);
            titleTextView.setText(taskDetail.getTitle());
            descriptionTextView.setText(taskDetail.getDescription());

        }

        return row;
    }
}
