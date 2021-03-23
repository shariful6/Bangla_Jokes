package com.example.banglajokes;

import android.content.Context;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseOpenHelper extends SQLiteAssetHelper {
    private  static  final String DATABASE_NAME = "Jokes.db";
    private static  final int DB_VERSION = 1;

    public DatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
    }
}
