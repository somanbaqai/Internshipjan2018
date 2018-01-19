package com.example.soman.navigationdrawer;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] drawerItemText;
    DrawerLayout drawerLayout;
    ListView listView;
    CharSequence drawerTitle;
    CharSequence title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = drawerTitle = getTitle();



        drawerItemText = getResources().getStringArray(R.array.menu_item);
        drawerLayout = findViewById(R.id.drawer_layout);
        listView = findViewById(R.id.list_item);

       getSupportActionBar().hide();

        DrawerAdapter adapter = new DrawerAdapter(this,R.layout.list_view_item_row,drawerItemText);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });



    }
}
