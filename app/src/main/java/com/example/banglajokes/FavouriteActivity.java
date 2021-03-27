package com.example.banglajokes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class FavouriteActivity extends AppCompatActivity {
    RecyclerView recyclerView ;
     AdapterFavourite adapterFavourite;
    private List<FavModel> favJokesList;

      FavouriteDatabaseSource databaseSource ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);

        recyclerView = findViewById(R.id.recyclerView_fav);
        favJokesList =new ArrayList<>();

        databaseSource = new FavouriteDatabaseSource(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        //  recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        favJokesList = databaseSource.getAllEmployee();

        adapterFavourite = new AdapterFavourite(FavouriteActivity.this,favJokesList);
        recyclerView.setAdapter(adapterFavourite);


    }
}