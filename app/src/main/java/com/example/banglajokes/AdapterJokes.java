package com.example.banglajokes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterJokes extends RecyclerView.Adapter<AdapterJokes.Myholder> {
    Context context;
    List<JokesDetailsModel> jokesList;

    public AdapterJokes(Context context, List<JokesDetailsModel> jokesList) {
        this.context = context;
        this.jokesList = jokesList;
    }



    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.jokes_view,parent,false);
        return new Myholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
             String jokes = jokesList.get(position).getJokes();

             holder.jokesTv.setText(jokes);

    }

    @Override
    public int getItemCount() {
        return jokesList.size();
    }

    public class Myholder extends RecyclerView.ViewHolder {
        TextView jokesTv;

        public Myholder(@NonNull View itemView) {
            super(itemView);
            jokesTv =itemView.findViewById(R.id.jokesTv);

        }
    }

}
