package com.example.foodorder.Fragments.Restourant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorder.Fragments.Restourant.Model.RestoModel;
import com.example.foodorder.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RestoAdapter extends RecyclerView.Adapter<RestoAdapter.MyVIewHolder> {

    Context context;
    List<RestoModel> list;

    public RestoAdapter(Context context, List<RestoModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyVIewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.resto_list_item, parent, false);
        return new MyVIewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVIewHolder holder, int position) {

        RestoModel restoModel=list.get(position);

        holder.textView.setText(restoModel.getName());

        Picasso.with(context).load(restoModel.getFileName()).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyVIewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView  textView;

        public MyVIewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.logo);
            textView=itemView.findViewById(R.id.RestoName);
        }
    }
}
