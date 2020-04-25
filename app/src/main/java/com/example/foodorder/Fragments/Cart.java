package com.example.foodorder.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodorder.Adapter.CartItemAdapter;
import com.example.foodorder.Adapter.HomeAdapter;
import com.example.foodorder.Model.CartItemModel;
import com.example.foodorder.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Cart extends Fragment {

    RecyclerView recyclerView;

    ArrayList<CartItemModel> cartItemModelArrayList;

    CartItemAdapter cartItemAdapter;

    public Cart() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_cart, container, false);


        recyclerView=view.findViewById(R.id.recyclerview);


        cartItemModelArrayList=new ArrayList<>();

        CartItemModel cartItemModel=new  CartItemModel("Spaghetti","$32.50","Cheese");
        CartItemModel cartItemModel1=new  CartItemModel("Pizza","$32.50","Cheese");
        CartItemModel cartItemModel2=new  CartItemModel("Burger","$32.50","Cheese");

        cartItemModelArrayList.add(cartItemModel);
        cartItemModelArrayList.add(cartItemModel1);
        cartItemModelArrayList.add(cartItemModel2);


        cartItemAdapter = new CartItemAdapter(getContext(),cartItemModelArrayList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(cartItemAdapter);

        return view;
    }

}
