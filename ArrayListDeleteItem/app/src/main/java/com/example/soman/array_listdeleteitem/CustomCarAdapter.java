package com.example.soman.array_listdeleteitem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by soman on 1/10/2018.
 */

public class CustomCarAdapter extends BaseAdapter {
    ArrayList<CarDetails> carDetailsArrayList;
    Context context;
    LayoutInflater layoutInflater = null;

    public CustomCarAdapter(ArrayList<CarDetails> carDetailsArrayList, Context context) {
        this.carDetailsArrayList = carDetailsArrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return carDetailsArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return carDetailsArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if(row == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.car_list_element, null);
        }
        TextView car_tv = row.findViewById(R.id.car_tv);
        TextView serial_tv = row.findViewById(R.id.serial_tv);

        car_tv.setText(carDetailsArrayList.get(position).getCarName());
        serial_tv.setText(carDetailsArrayList.get(position).getSeriol_no());

        notifyDataSetChanged();





        return row;
    }

    public void RemoveItem(int pos) {

        carDetailsArrayList.remove(pos);
        notifyDataSetChanged();
    }


}
