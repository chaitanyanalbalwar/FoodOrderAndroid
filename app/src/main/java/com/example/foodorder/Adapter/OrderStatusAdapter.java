package com.example.foodorder.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorder.Model.OrderStatusModel;
import com.example.foodorder.R;

import java.util.ArrayList;

public class OrderStatusAdapter extends RecyclerView.Adapter<OrderStatusAdapter.MyViewHolder> {

    Context context;
    ArrayList<OrderStatusModel> statusModelArrayList;

    public OrderStatusAdapter(Context context, ArrayList<OrderStatusModel> statusModelArrayList) {
        this.context = context;
        this.statusModelArrayList = statusModelArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_status_list_item, parent, false);
        return new OrderStatusAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        OrderStatusModel model=statusModelArrayList.get(position);

        holder.OrderStatus.setText(model.getName());
        holder.Time.setText(model.getTime());

        holder.CheckStatus.setChecked(false);


    }

    @Override
    public int getItemCount() {
        return statusModelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView OrderStatus,Time;
        CheckBox CheckStatus;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            OrderStatus=itemView.findViewById(R.id.statusName);
            Time=itemView.findViewById(R.id.time);
            CheckStatus=itemView.findViewById(R.id.checkStatus);
        }
    }
}
