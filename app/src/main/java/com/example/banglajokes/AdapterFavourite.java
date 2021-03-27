package com.example.banglajokes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterFavourite extends RecyclerView.Adapter<AdapterFavourite.Myholder> {

    Context context;
    List<FavModel> favJokesList;

    public AdapterFavourite(Context context, List<FavModel> favJokesList) {
        this.context = context;
        this.favJokesList = favJokesList;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.fav_view,parent,false);
        return new AdapterFavourite.Myholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterFavourite.Myholder holder, int position) {
        String jokes = favJokesList.get(position).getJokes();
             holder.jokesTv.setText(jokes);
    }

    @Override
    public int getItemCount() {
        return favJokesList.size();
    }

    public class Myholder extends RecyclerView.ViewHolder {
        TextView jokesTv ;

        public Myholder(@NonNull View itemView) {
            super(itemView);
            jokesTv = itemView.findViewById(R.id.jokesTv_fav);
        }
    }


}
