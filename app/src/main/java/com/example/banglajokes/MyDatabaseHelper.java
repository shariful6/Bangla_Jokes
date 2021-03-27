package com.example.banglajokes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper  {

    public static final String DB_NAME ="JokesDB";
    public static final String TABLE_NAME= "fav_jokes";
    public static final String KEY_ID= "id";
    public static final String JOKES= "jokes";
    public static final int DB_VERSION =1;


    private static  final String CREATE_TABLE ="CREATE TABLE "+TABLE_NAME+"("+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+JOKES+" VARCHAR(500));";
    private static final String DROP_TABLE= "DROP TABLE IF EXISTS "+TABLE_NAME;

    private Context context;

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        try {

            Toast.makeText(context, "onCreate is Called", Toast.LENGTH_SHORT).show();
            db.execSQL(CREATE_TABLE);

        }
        catch (Exception e)
        {
            Toast.makeText(context, "Exception: "+e, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try
        {
            Toast.makeText(context, "onUpgrade is Called", Toast.LENGTH_SHORT).show();
            db.execSQL(DROP_TABLE);
            onCreate(db);

        }
        catch (Exception e)
        {
            Toast.makeText(context, "Exception: "+e, Toast.LENGTH_SHORT).show();
        }

    }
}
