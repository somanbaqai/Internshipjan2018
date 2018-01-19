package com.example.android.pets.data;

import android.provider.BaseColumns;

/**
 * Created by soman on 1/16/2018.
 */

public final class PetContract {
    public PetContract() {
    }

    public static abstract class PetEntry implements BaseColumns {
        public static final String TABLE_NAME = "PetsTable";
        public static final String COLUMN_NAME = "Name";
        public static final String COLUMN_GENDER = "Gender";
        public static final String COLUMN_BREED = "Breed";
        public static final String COLUMN_WEIGHT = "Weight";
        public static final String COLUMN_id = BaseColumns._ID;

        /**
         *  Possible Values For Gender of pets
         */
        public static final int Gender_male = 1;
        public static final int Gender_female = 2;
        public static final int Gender_unknown = 0;


    }
}
