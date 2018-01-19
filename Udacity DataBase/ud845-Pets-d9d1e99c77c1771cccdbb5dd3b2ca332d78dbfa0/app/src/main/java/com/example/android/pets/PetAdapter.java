package com.example.android.pets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by soman on 1/19/2018.
 */

public class PetAdapter extends BaseAdapter {
    Context context;
    ArrayList<PetDetails> petDetailsArrayList;

    LayoutInflater inflater;

    public PetAdapter(Context context, ArrayList<PetDetails> petDetailsArrayList) {
        this.context = context;
        this.petDetailsArrayList = petDetailsArrayList;

    }

    @Override
    public int getCount() {
        return petDetailsArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return petDetailsArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row= convertView;
        if(row == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.list_view_layout,null);
        }

        PetDetails petDetails = (PetDetails) getItem(position);

        TextView dogTv_name = row.findViewById(R.id.name_tv);
        TextView dogTv_breed = row.findViewById(R.id.Breed_tv);
        TextView dogTv_gender = row.findViewById(R.id.gender_tv);
        TextView dogTv_weight = row.findViewById(R.id.weight_tv);

        dogTv_name.setText(petDetails.getName());
        dogTv_breed.setText(petDetails.getBreed());
        dogTv_gender.setText(String.valueOf(petDetails.getGender()));
        dogTv_weight.setText(String.valueOf(petDetails.getWeight()));

        notifyDataSetChanged();






        return row;
    }
}
