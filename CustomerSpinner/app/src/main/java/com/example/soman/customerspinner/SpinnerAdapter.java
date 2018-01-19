package com.example.soman.customerspinner;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by soman on 1/4/2018.
 */

public class SpinnerAdapter extends BaseAdapter {
    private List<String> listData;
    private Activity activity;
    private LayoutInflater inflater;
    public SpinnerAdapter(List<String> listData, Activity activity) {
        this.listData = listData;
        this.activity = activity;
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(convertView == null){
            view = inflater.inflate(R.layout.spinner_item,null);

        }
        TextView textView = (TextView) view.findViewById(R.id.textview);
        textView.setText(listData.get(position));
        return view;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View view = super.getDropDownView(position,convertView,parent);
        LinearLayout linearLayout = (LinearLayout) view;
        TextView textView = (TextView) linearLayout.findViewById(R.id.textview);
        textView.setGravity(Gravity.LEFT);
        textView.setTextColor(R.color.colorAccent);
        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
        return view;
    }
}
