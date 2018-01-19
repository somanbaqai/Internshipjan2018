package com.example.android.pets.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.android.pets.data.PetContract.PetEntry;
/**
 * Created by soman on 1/16/2018.
 */

public class PetDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = PetDbHelper.class.getSimpleName();

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "shelter.db";

    public PetDbHelper(Context context) {
        super(context, DATABASE_NAME ,null, DATABASE_VERSION);
    }

//    public PetDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
//        super(context, name, factory, version, errorHandler);
//    }


    @Override
    public void onCreate(SQLiteDatabase db) {
//        String SQL_CREATE_PETS_TABLE = "CREATE TABLE " + PetEntry.TABLE_NAME + " ( "
//                + PetEntry.COLUMN_id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
//                + PetEntry.COLUMN_NAME + " TEXT NOT NULL, "
//                + PetEntry.COLUMN_GENDER + " INTEGER NOT NULL, "
//                + PetEntry.COLUMN_BREED + " TEXT, "
//                + PetEntry.COLUMN_WEIGHT + " INTEGER NOT NULL DEFAULT 0);";


        String SQL_CREATE_PETS_TABLE =  "CREATE TABLE " + PetEntry.TABLE_NAME + " ("
                                + PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                                + PetEntry.COLUMN_NAME + " TEXT NOT NULL, "
                                + PetEntry.COLUMN_BREED + " TEXT, "
                               + PetEntry.COLUMN_GENDER + " INTEGER NOT NULL, "
                               + PetEntry.COLUMN_WEIGHT + " INTEGER NOT NULL DEFAULT 0);";

        db.execSQL(SQL_CREATE_PETS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {





    }
}
