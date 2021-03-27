package com.example.banglajokes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterJokes extends RecyclerView.Adapter<AdapterJokes.Myholder> {
    Context context;
    List<JokesDetailsModel> jokesList;
    FavouriteDatabaseSource databaseSource;

    public AdapterJokes(Context context, List<JokesDetailsModel> jokesList) {
        this.context = context;
        this.jokesList = jokesList;
    }



    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        databaseSource = new FavouriteDatabaseSource(context);         ///////////////////////////////
        View view = LayoutInflater.from(context).inflate(R.layout.jokes_view,parent,false);
        return new Myholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
             String jokes = jokesList.get(position).getJokes();
             String id = jokesList.get(position).getId();

             holder.jokesTv.setText(jokes);

             holder.favBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(context, ""+jokes, Toast.LENGTH_SHORT).show();
               saveFav(jokes);
           }
       });


    }

    @Override
    public int getItemCount() {
        return jokesList.size();
    }

    public class Myholder extends RecyclerView.ViewHolder {
        TextView jokesTv;
        Button  favBtn;

        public Myholder(@NonNull View itemView) {
            super(itemView);
            jokesTv =itemView.findViewById(R.id.jokesTv);
            favBtn =itemView.findViewById(R.id.favBtn);

        }
    }

    private void saveFav(String s){


        boolean status= databaseSource.insertEmployee(s);
        if (status)
        {
            Toast.makeText(context, "Inserted !!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(context, "Failed to insert !!", Toast.LENGTH_SHORT).show();
        }

    }

}
