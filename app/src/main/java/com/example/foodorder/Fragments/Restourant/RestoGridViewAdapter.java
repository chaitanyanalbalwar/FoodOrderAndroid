package com.example.foodorder.Fragments.Restourant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodorder.Fragments.Restourant.Model.RestoModel;
import com.example.foodorder.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RestoGridViewAdapter extends BaseAdapter {

    Context context;
    ArrayList<RestoModel> list;


    private LayoutInflater mInflater;

    public RestoGridViewAdapter(Context context, ArrayList<RestoModel> list) {
        this.context = context;
        this.list = list;

        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = mInflater.inflate(R.layout.resto_list_item, null);

        ImageView imageview = (ImageView) view.findViewById(R.id.logo);
        TextView textview = (TextView) view.findViewById(R.id.RestoName);

        textview.setText(list.get(i).getName());

        Picasso.with(context).load(list.get(i).getFileName()).into(imageview);

        return view;
    }
}
