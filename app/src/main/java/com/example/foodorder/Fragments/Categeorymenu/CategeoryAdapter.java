package com.example.foodorder.Fragments.Categeorymenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodorder.Fragments.Categeorymenu.Model.CategeoryModel;
import com.example.foodorder.Fragments.Restourant.RestoAdapter;
import com.example.foodorder.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CategeoryAdapter extends RecyclerView.Adapter<CategeoryAdapter.MyViewHolder> {

    Context context;
    List<CategeoryModel> list;

    public CategeoryAdapter(Context context, List<CategeoryModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categeory_list_item, parent, false);
        return new CategeoryAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        CategeoryModel model=list.get(position);

        holder.textView.setText(model.getName());

        Picasso.with(context).load(model.getFileName()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.logo);
            textView=itemView.findViewById(R.id.name);
        }
    }
}
