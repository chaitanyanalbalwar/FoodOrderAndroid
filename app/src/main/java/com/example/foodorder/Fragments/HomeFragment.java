package com.example.foodorder.Fragments;



import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodorder.Adapter.HomeAdapter;
import com.example.foodorder.Model.HomeModel;
import com.example.foodorder.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    HomeAdapter homeAdapter;
    ArrayList<HomeModel> homeModelArrayList;
    SearchView searchView;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);


        recyclerView=view.findViewById(R.id.recyclerView);
        searchView=view.findViewById(R.id.search);

        homeModelArrayList=new ArrayList<>();


        HomeModel homeModel=new HomeModel(null,null,"Burger","5.00 $");
        HomeModel homeModel1=new HomeModel(null,null,"Pizza","10.00 $");
        HomeModel homeModel2=new HomeModel(null,null,"Chese Burger","8.00 $");

        homeModelArrayList.add(homeModel);
        homeModelArrayList.add(homeModel1);
        homeModelArrayList.add(homeModel2);


        homeAdapter = new HomeAdapter(getContext(),homeModelArrayList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(homeAdapter);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                filter(s.toString());

                return true;
            }
        });


        return view;
    }


    void filter(String text){
        ArrayList<HomeModel> temp = new ArrayList();
        for(HomeModel d: homeModelArrayList){
            //or use .equal(text) with you want equal match
            //use .toLowerCase() for better matches
            if(d.getItemName().equalsIgnoreCase(text)){
                temp.add(d);
            }
        }

        if (temp.size()>0){
            //update recyclerview
            homeAdapter = new HomeAdapter(getContext(),temp);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(homeAdapter);
            homeAdapter.notifyDataSetChanged();
        }else {

            homeAdapter = new HomeAdapter(getContext(),homeModelArrayList);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(homeAdapter);
        }

    }

}
