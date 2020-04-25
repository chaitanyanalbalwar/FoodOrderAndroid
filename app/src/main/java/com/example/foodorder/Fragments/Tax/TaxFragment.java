package com.example.foodorder.Fragments.Tax;


import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodorder.Fragments.Tax.Model.TaxModel;
import com.example.foodorder.Fragments.Tax.ViewModel.TaxViewModel;
import com.example.foodorder.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TaxFragment extends Fragment {


    ArrayList<TaxModel> list;

    public TaxFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_tax, container, false);

        TaxViewModel model= ViewModelProviders.of(this).get(TaxViewModel.class);

        model.getMutableLiveData().observe(this, new Observer<List<TaxModel>>() {
            @Override
            public void onChanged(List<TaxModel> taxModels) {

                list= (ArrayList<TaxModel>) taxModels;

                Log.d("size", String.valueOf(list.size()));

            }
        });



        return view;
    }

}
