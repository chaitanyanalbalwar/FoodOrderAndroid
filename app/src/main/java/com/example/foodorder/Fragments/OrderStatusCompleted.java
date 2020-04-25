package com.example.foodorder.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodorder.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderStatusCompleted extends Fragment {


    public OrderStatusCompleted() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_order_status_completed, container, false);

        return view;
    }

}
