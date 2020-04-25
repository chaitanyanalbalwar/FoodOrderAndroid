package com.example.foodorder.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorder.Model.ItemModel;
import com.example.foodorder.R;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {


    Context context;
    ArrayList<ItemModel> itemModelArrayList;

    public ItemAdapter(Context context, ArrayList<ItemModel> itemModelArrayList) {
        this.context = context;
        this.itemModelArrayList = itemModelArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_ons_list_item, parent, false);
        return new ItemAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ItemModel itemModel=itemModelArrayList.get(position);

        holder.itemName.setText(itemModel.getItemName());
        holder.itemPrice.setText(itemModel.getPrice());

    }

    @Override
    public int getItemCount() {
        return itemModelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView itemName,itemPrice;
        Button plus,minus;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            itemName=itemView.findViewById(R.id.addonsName);
            itemPrice=itemView.findViewById(R.id.addOnsPrice);
        }
    }
}
