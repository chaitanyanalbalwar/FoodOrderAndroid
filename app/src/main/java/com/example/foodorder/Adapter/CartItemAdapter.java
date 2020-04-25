package com.example.foodorder.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorder.Fragments.Cart;
import com.example.foodorder.Fragments.Checkout;
import com.example.foodorder.Fragments.OrderStatus;
import com.example.foodorder.Model.CartItemModel;
import com.example.foodorder.R;

import java.util.ArrayList;

public class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.MyViewHolder> {


    Context context;
    ArrayList<CartItemModel> cartItemModelArrayList;

    public CartItemAdapter(Context context, ArrayList<CartItemModel> cartItemModelArrayList) {
        this.context = context;
        this.cartItemModelArrayList = cartItemModelArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_list, parent, false);
        return new CartItemAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        CartItemModel cartItemModel=cartItemModelArrayList.get(position);

        holder.ItemName.setText(cartItemModel.getItemName());
        holder.ItemPrice.setText(cartItemModel.getPrice());
        holder.addOns.setText(cartItemModel.getAddOns());

    }

    @Override
    public int getItemCount() {
        return cartItemModelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView ItemName,ItemPrice,addOns;
        ImageView imagelogo;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ItemName =itemView.findViewById(R.id.ItemName);
            ItemPrice =itemView.findViewById(R.id.ItemPrice);
            addOns =itemView.findViewById(R.id.addOns);
            imagelogo =itemView.findViewById(R.id.imagelogo);

            imagelogo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    loadFragment();
                }
            });
        }
    }

    private void loadFragment() {

        ((FragmentActivity) context).getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_container, new OrderStatus())
                .addToBackStack(null)
                .commit();
    }
}
