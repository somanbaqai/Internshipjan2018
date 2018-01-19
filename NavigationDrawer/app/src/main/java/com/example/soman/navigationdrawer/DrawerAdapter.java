package com.example.soman.navigationdrawer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

/**
 * Created by soman on 1/11/2018.
 */

public class DrawerAdapter extends ArrayAdapter {

    Context context;
    String[] item_String;
    int resourceId;



    public DrawerAdapter(@NonNull Context context, int resource , String[] itemString) {
        super(context, resource);

        this.context = context;
        this.item_String = itemString;
        this.resourceId = resource;

    }
}
