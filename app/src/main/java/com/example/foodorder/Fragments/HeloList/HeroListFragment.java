package com.example.foodorder.Fragments.HeloList;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodorder.Fragments.HeloList.Adapter.HeroesAdapter;
import com.example.foodorder.Fragments.HeloList.Model.Hero;
import com.example.foodorder.Fragments.HeloList.ViewModel.HeroesViewModel;
import com.example.foodorder.R;

import java.util.List;


public class HeroListFragment extends Fragment {


    RecyclerView recyclerView;
    HeroesAdapter adapter;

    List<Hero> heroList;



    public HeroListFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_hero_list, container, false);


        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        HeroesViewModel model = ViewModelProviders.of(this).get(HeroesViewModel.class);

        model.getHeroes().observe(this, new Observer<List<Hero>>() {
            @Override
            public void onChanged(@Nullable List<Hero> heroList) {
                adapter = new HeroesAdapter(getContext(), heroList);
                recyclerView.setAdapter(adapter);
            }
        });


        return view;
    }


}
