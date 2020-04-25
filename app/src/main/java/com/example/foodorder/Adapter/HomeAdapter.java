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
import com.example.foodorder.Fragments.ItemPage;
import com.example.foodorder.Model.HomeModel;
import com.example.foodorder.R;
import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

    Context context;
    ArrayList<HomeModel> list;

    public HomeAdapter(Context context, ArrayList<HomeModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_list_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        HomeModel homeModel=list.get(position);

        holder.itemName.setText(homeModel.getItemName());
        holder.itemPrice.setText(homeModel.getItemPrice());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView mainItemLogo,itemLogo;
        TextView  itemName,itemPrice;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mainItemLogo=itemView.findViewById(R.id.itemMainLogo);
            itemLogo=itemView.findViewById(R.id.itemLogo);
            itemName=itemView.findViewById(R.id.itemName);
            itemPrice=itemView.findViewById(R.id.itemPrice);


            mainItemLogo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    loadFragment();

                }
            });


        }
    }


    private void loadFragment() {

        ((FragmentActivity) context).getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_container, new Cart())
                .addToBackStack(null)
                .commit();
    }
}
