package com.example.banglajokes;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static  DatabaseAccess instance;
    Cursor c=null;


    DatabaseAccess(Context context){
        this.openHelper =new DatabaseOpenHelper(context);

    }

    public static DatabaseAccess getInstance(Context context){
        if (instance==null){
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    public void open(){
        this.db = openHelper.getWritableDatabase();
    }
    public void close(){
        if (db!=null){
            this.db.close();
        }
    }

    public List<JokesModel> getJokesList(){

        JokesModel jokesModel = null;
        List<JokesModel> mJokesCatList = new ArrayList<>();
        open();
        Cursor cursor = db.rawQuery("SELECT * FROM jokes_category",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            jokesModel = new JokesModel(cursor.getInt(0),cursor.getString(1));
            mJokesCatList.add(jokesModel);
            cursor.moveToNext();
        }

        cursor.close();
        close();
        return mJokesCatList;
    }



    // for sura details list
    public List<JokesDetailsModel> getJokesDetails(String arg){

        JokesDetailsModel detailsModel = null;
        List<JokesDetailsModel> jokesDetailsList = new ArrayList<>();
        open();

        Cursor cursor = db.rawQuery("SELECT * FROM details WHERE tag=?",new String[]{arg});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            detailsModel = new JokesDetailsModel(cursor.getString(0),cursor.getString(1),cursor.getString(2));
            jokesDetailsList.add(detailsModel);
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return jokesDetailsList;
    }



}
