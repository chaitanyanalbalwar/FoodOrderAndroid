package com.example.foodorder.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorder.HotelList.Model.HotelNameModel;
import com.example.foodorder.Model.LayoutListModel;
import com.example.foodorder.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class LayoutListAdapter extends BaseAdapter {

    Context context;
    ArrayList<LayoutListModel> list;
    LayoutInflater inflter;

    ArrayList<HotelNameModel> nameList;



    public LayoutListAdapter(Context context, ArrayList<HotelNameModel> value) {

        this.context = context;
        this.nameList = value;

        inflter = (LayoutInflater.from(context));
    }




    @Override
    public int getCount() {
        return nameList.size();
    }

    @Override
    public Object getItem(int i) {
        return nameList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=inflter.inflate(R.layout.layout_list_item,null);

        final ImageView mImageView=view.findViewById(R.id.restLogo);
        final TextView mTxtName=view.findViewById(R.id.restName);


        Picasso.with(context).load(nameList.get(i).getImage()).into(mImageView);

        mTxtName.setText(nameList.get(i).getName());

        return view;

    }

}
