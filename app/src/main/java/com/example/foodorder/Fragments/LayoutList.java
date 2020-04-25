package com.example.foodorder.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import com.example.foodorder.Adapter.LayoutListAdapter;
import com.example.foodorder.HotelList.Model.HotelNameModel;
import com.example.foodorder.HotelList.ViewModel.HotelListViewModel;
import com.example.foodorder.Model.LayoutListModel;
import com.example.foodorder.R;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */

public class LayoutList extends Fragment {

    GridView mGridView;

    ArrayList<LayoutListModel> layoutListModels;
    LayoutListAdapter layoutListAdapter;
    HotelListViewModel mHotelListViewModel;

    public LayoutList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_layout_list, container, false);

        mGridView=view.findViewById(R.id.gridview);

        layoutListModels=new ArrayList<>();


        mHotelListViewModel= ViewModelProviders.of(this).get(HotelListViewModel.class);
        mHotelListViewModel.init();

        mHotelListViewModel.getHotelList().observe(this, new Observer<List<HotelNameModel>>() {
            @Override
            public void onChanged(List<HotelNameModel> hotelNameModels) {

                layoutListAdapter.notifyDataSetChanged();

            }
        });


        layoutListAdapter=new LayoutListAdapter(getContext(), (ArrayList<HotelNameModel>) mHotelListViewModel.getHotelList().getValue());
        mGridView.setAdapter(layoutListAdapter);


        return view;
    }

}
