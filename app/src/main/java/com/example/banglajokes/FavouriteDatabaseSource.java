package com.example.banglajokes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class FavouriteDatabaseSource {

    private MyDatabaseHelper helper;

    private SQLiteDatabase db;

    public FavouriteDatabaseSource(Context context) {
        helper= new MyDatabaseHelper(context);
    }


    public  void  open()
    {
        db = helper.getWritableDatabase();
    }
    public void close()
    {
        db.close();
    }


    public boolean insertEmployee(String s)
    {
        this.open();
        ContentValues cv= new ContentValues();
        cv.put(helper.JOKES,s);
        long insertRow = db.insert(helper.TABLE_NAME,null,cv);
        this.close();
        if (insertRow>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public List<FavModel> getAllEmployee() {

        List<FavModel> favJokeList = new ArrayList<>();
        db = helper.getReadableDatabase();

        String query = "SELECT * FROM " + MyDatabaseHelper.TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(MyDatabaseHelper.KEY_ID));
                String name = cursor.getString(cursor.getColumnIndex(MyDatabaseHelper.JOKES));
                FavModel favModel = new FavModel( id,name);

                favJokeList.add(favModel);

            } while (cursor.moveToNext());
            db.close();
        }
        return favJokeList;

    }

}

