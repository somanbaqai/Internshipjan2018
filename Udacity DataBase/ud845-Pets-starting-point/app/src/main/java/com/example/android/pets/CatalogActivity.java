/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.pets;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import android.widget.TextView;

import com.example.android.pets.data.PetContentValues;
import com.example.android.pets.data.PetContract.PetEntry;
import com.example.android.pets.data.PetDbHelper;
import com.example.android.pets.data.PetListAdapter;

import java.util.ArrayList;

/**
 * Displays list of pets that were entered and stored in the app.
 */
public class CatalogActivity extends AppCompatActivity {
    PetDbHelper petDbHelper;

    ListView listView;
    PetListAdapter adapter;

    ArrayList<PetContentValues> petContentValuesArrayList;
    String getName, getBreed;
    int getgender, getweight;
    int checkfirsttime = 0;
    public static boolean isResume;

    SearchView pet_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);



        petContentValuesArrayList = new ArrayList<>();

        listView = findViewById(R.id.list_item);
        adapter = new PetListAdapter(petContentValuesArrayList, this);

        // Setup FAB to open EditorActivity
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(CatalogActivity.this, EditorActivity.class);
                startActivity(intent);
            }
        });
        pet_search = findViewById(R.id.search_pet_ev);
        pet_search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        petDbHelper = new PetDbHelper(this);


        displayDatabaseInfoOnCreate();

    }

    @Override
    protected void onStart() {
        super.onStart();
        displayDatabaseInfo();
        isResume = false;
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
//        displayDatabaseInfo();
    }

    private void insertPet() {
        SQLiteDatabase db = petDbHelper.getWritableDatabase();

        ContentValues values1 = new ContentValues();

        values1.put(PetEntry.COLUMN_NAME, "toto");
        values1.put(PetEntry.COLUMN_BREED, "Terrier");
        values1.put(PetEntry.COLUMN_GENDER, 1);
        values1.put(PetEntry.COLUMN_WEIGHT, 7);
        long Row_ID = db.insert(PetEntry.TABLE_NAME, null, values1);
        Log.v("CatalogActivity", "added row id = " + Row_ID);


    }


    private void displayDatabaseInfo() {
        // To access our database, we instantiate our subclass of SQLiteOpenHelper
        // and pass the context, which is the current activity.
        //    PetDbHelper mDbHelper = new PetDbHelper(this);

        // Create and/or open a database to read from it
        SQLiteDatabase db = petDbHelper.getReadableDatabase();

        // Perform this raw SQL query "SELECT * FROM pets"
        // to get a Cursor that contains all rows from the pets table.
//        Cursor cursor = db.rawQuery("SELECT * FROM " + PetEntry.TABLE_NAME, null);
        String[] projection = {
                PetEntry.COLUMN_id,
                PetEntry.COLUMN_NAME,
                PetEntry.COLUMN_BREED,
                PetEntry.COLUMN_GENDER,
                PetEntry.COLUMN_WEIGHT
        };
        Cursor cursor = db.query(
                PetEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);


        try {
            // Display the number of rows in the Cursor (which reflects the number of rows in the
            // pets table in the database).
            //   TextView displayView = (TextView) findViewById(R.id.text_view_pet);
            //displayView.setText("Number of rows in pets database table: " + cursor.getCount() + "\n\n");
            // displayView.append("_ID\tName\tBreed\tgender\tWeight \n\n");
            if (cursor.moveToLast()) {
                if (isResume) {
                    int IDColoumnIndex = cursor.getColumnIndex(PetEntry.COLUMN_id);
                    int getId = cursor.getInt(IDColoumnIndex);


                    int NameColumnIndex = cursor.getColumnIndex(PetEntry.COLUMN_NAME);
                    getName = cursor.getString(NameColumnIndex);

                    int BreedColumnIndex = cursor.getColumnIndex(PetEntry.COLUMN_BREED);
                    getBreed = cursor.getString(BreedColumnIndex);

                    int genderIndex = cursor.getColumnIndex(PetEntry.COLUMN_GENDER);
                    getgender = cursor.getInt(genderIndex);

                    int weightindex = cursor.getColumnIndex(PetEntry.COLUMN_WEIGHT);
                    getweight = cursor.getInt(weightindex);

                    //   displayView.append("\n" + getId + "\t" +getName + "\t" + getBreed + "\t" + getgender + "\t" + getweight );

                    petContentValuesArrayList.add(new PetContentValues(getName, getgender, getBreed, getweight));
                    listView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }

            }


        } finally {
            // Always close the cursor when you're done reading from it. This releases all its
            // resources and makes it invalid.
            cursor.close();
        }
    }


    private void displayDatabaseInfoOnCreate() {
        // To access our database, we instantiate our subclass of SQLiteOpenHelper
        // and pass the context, which is the current activity.
        //    PetDbHelper mDbHelper = new PetDbHelper(this);

        // Create and/or open a database to read from it
        SQLiteDatabase db = petDbHelper.getReadableDatabase();

        // Perform this raw SQL query "SELECT * FROM pets"
        // to get a Cursor that contains all rows from the pets table.
//        Cursor cursor = db.rawQuery("SELECT * FROM " + PetEntry.TABLE_NAME, null);
        String[] projection = {
                PetEntry.COLUMN_id,
                PetEntry.COLUMN_NAME,
                PetEntry.COLUMN_BREED,
                PetEntry.COLUMN_GENDER,
                PetEntry.COLUMN_WEIGHT
        };
        Cursor cursor = db.query(
                PetEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);


        try {
            // Display the number of rows in the Cursor (which reflects the number of rows in the
            // pets table in the database).
            //   TextView displayView = (TextView) findViewById(R.id.text_view_pet);
            //displayView.setText("Number of rows in pets database table: " + cursor.getCount() + "\n\n");
            // displayView.append("_ID\tName\tBreed\tgender\tWeight \n\n");
            while (cursor.moveToNext()) {
                int IDColoumnIndex = cursor.getColumnIndex(PetEntry.COLUMN_id);
                int getId = cursor.getInt(IDColoumnIndex);

                int NameColumnIndex = cursor.getColumnIndex(PetEntry.COLUMN_NAME);
                getName = cursor.getString(NameColumnIndex);

                int BreedColumnIndex = cursor.getColumnIndex(PetEntry.COLUMN_BREED);
                getBreed = cursor.getString(BreedColumnIndex);

                int genderIndex = cursor.getColumnIndex(PetEntry.COLUMN_GENDER);
                getgender = cursor.getInt(genderIndex);

                int weightindex = cursor.getColumnIndex(PetEntry.COLUMN_WEIGHT);
                getweight = cursor.getInt(weightindex);

                //   displayView.append("\n" + getId + "\t" +getName + "\t" + getBreed + "\t" + getgender + "\t" + getweight );

                petContentValuesArrayList.add(new PetContentValues(getName, getgender, getBreed, getweight));
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                isResume = true;
            }


        } finally {
            // Always close the cursor when you're done reading from it. This releases all its
            // resources and makes it invalid.
            cursor.close();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate  the menu options from the res/menu/menu_catalog.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_catalog, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Insert dummy data" menu option
            case R.id.action_insert_dummy_data:
                insertPet();
                displayDatabaseInfo();

                return true;
            // Respond to a click on the "Delete all entries" menu option
            case R.id.action_delete_all_entries:
                // Do nothing for now
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
