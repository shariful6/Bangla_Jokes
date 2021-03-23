package com.example.banglajokes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class JokesActivity extends AppCompatActivity {
    String tag;
    String categoryName;
    RecyclerView recyclerView;

    private DatabaseAccess dbAccess;
    private AdapterJokes adapterJokes;
    private List<JokesDetailsModel> jokesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);
        recyclerView = findViewById(R.id.recyclerView_jokes);

        Intent intent = getIntent();
        tag =String.valueOf(intent.getIntExtra("tag",0));
        String categoryName =intent.getStringExtra("catName");
        this.setTitle(categoryName);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
      //  recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        jokesList =new ArrayList<>();

        dbAccess = new DatabaseAccess(this);
        jokesList =dbAccess.getJokesDetails(tag); //ok
        adapterJokes = new AdapterJokes(JokesActivity.this,jokesList);
        recyclerView.setAdapter(adapterJokes);


    }
}