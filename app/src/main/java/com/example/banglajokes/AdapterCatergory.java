package com.example.banglajokes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterCatergory extends RecyclerView.Adapter<AdapterCatergory.Myholder> {

    Context context;
    List<JokesModel> categoryList;

    public AdapterCatergory(Context context, List<JokesModel> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }




    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_view,parent,false);
        return new Myholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
         int id = categoryList.get(position).getId();
         String categoryName = categoryList.get(position).getName();
         holder.categorynameTv.setText(categoryName);

         holder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 Intent intent = new Intent(AdapterCatergory.this.context,JokesActivity.class);
                 intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                 intent.putExtra("tag",id);
                 intent.putExtra("catName",categoryName);
                 AdapterCatergory.this.context.startActivity(intent);
             }
         });


    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }


    public class Myholder extends RecyclerView.ViewHolder {
        TextView categorynameTv;

        public Myholder(@NonNull View itemView) {
            super(itemView);
            categorynameTv = itemView.findViewById(R.id.catNameTv_id);

        }
    }

    public void setFilter(List<JokesModel> newList) {
        this.categoryList = new ArrayList();
        this.categoryList.addAll(newList);
        notifyDataSetChanged();
    }




}
