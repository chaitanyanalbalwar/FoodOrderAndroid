package com.example.foodorder.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodorder.Adapter.OrderStatusAdapter;
import com.example.foodorder.Model.OrderStatusModel;
import com.example.foodorder.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderStatus extends Fragment {


    RecyclerView recyclerView;
    OrderStatusAdapter orderStatusAdapter;

    ArrayList<OrderStatusModel> statusModelArrayList;


    public OrderStatus() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_order_status, container, false);


        recyclerView=view.findViewById(R.id.recyclerview);

        statusModelArrayList=new ArrayList<>();


        OrderStatusModel model=new OrderStatusModel("Order Confirmed","12.3pm",false);
        OrderStatusModel model1=new OrderStatusModel("Order Confirmed","12.3pm",false);
        OrderStatusModel model2=new OrderStatusModel("Order Confirmed","12.3pm",false);
        OrderStatusModel model3=new OrderStatusModel("Order Confirmed","12.3pm",false);

        statusModelArrayList.add(model);
        statusModelArrayList.add(model1);
        statusModelArrayList.add(model2);
        statusModelArrayList.add(model3);

        orderStatusAdapter=new OrderStatusAdapter(getContext(),statusModelArrayList);


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(orderStatusAdapter);


        return view;
    }

}
