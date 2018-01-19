package com.example.android.pets.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.android.pets.R;

import java.util.ArrayList;

/**
 * Created by soman on 1/17/2018.
 */

public class PetListAdapter extends BaseAdapter implements Filterable {
    Context context;
    ArrayList<PetContentValues> petContentValuesArrayList;
    ArrayList<PetContentValues> petContentValuesArrayListFiltered;
    int count =0;

    public PetListAdapter(ArrayList<PetContentValues> petContentValuesArrayList,Context context) {
        this.context = context;
        this.petContentValuesArrayList = petContentValuesArrayList;
        this.petContentValuesArrayListFiltered = petContentValuesArrayList;
    }

    @Override
    public int getCount() {
        return petContentValuesArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return petContentValuesArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if(row == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.list_view_layout,null);

        }
        TextView name_tv = row.findViewById(R.id.name_tv);
        TextView breed_tv = row.findViewById(R.id.Breed_tv);
        TextView gender_tv = row.findViewById(R.id.gender_tv);
        TextView weight_tv = row.findViewById(R.id.weight_tv);



        name_tv.setText( position + ") Dog Name: " + petContentValuesArrayList.get(position).getName());
        breed_tv.setText("Breed: " + petContentValuesArrayList.get(position).getBreed());
        gender_tv.setText("Gender: " + petContentValuesArrayList.get(position).getGender());
        weight_tv.setText("Weight: " + petContentValuesArrayList.get(position).getWeight());
     //   notifyDataSetChanged();
        return row;
    }

    @O verride
    public Filter getFilter() {
    return new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            String strQuery = constraint.toString();

            if(strQuery.isEmpty()){
                petContentValuesArrayListFiltered = petContentValuesArrayList;

            }
            else {
                ArrayList<PetContentValues> filterList = new ArrayList<>();

                for( PetContentValues petContentValues : petContentValuesArrayList){

                    if(strQuery.toLowerCase().contains(petContentValues.getName().toLowerCase())){

                        filterList.add(petContentValues);
                    }


                }
                petContentValuesArrayListFiltered = filterList;

            }

            FilterResults results = new FilterResults();
            results.values = petContentValuesArrayListFiltered;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            petContentValuesArrayListFiltered = (ArrayList<PetContentValues>) results.values;
            notifyDataSetChanged();

        }
    };
    }
}
