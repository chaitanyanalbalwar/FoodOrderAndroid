package com.example.foodorder.Fragments.Restourant;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.foodorder.Fragments.HeloList.Adapter.HeroesAdapter;
import com.example.foodorder.Fragments.Restourant.Model.RestoModel;
import com.example.foodorder.Fragments.Restourant.ViewModel.RestoViewModel;
import com.example.foodorder.R;
import com.example.foodorder.Util.AppController;
import com.example.foodorder.Util.Url;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestourantList extends Fragment {

    RecyclerView recyclerView;
    RestoAdapter restoAdapter;

    ProgressDialog dialog;

    public RestourantList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_restourant_list, container, false);

      //  gridView=view.findViewById(R.id.gridview);

        recyclerView =view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        dialog=new ProgressDialog(getContext());
        dialog.setCanceledOnTouchOutside(false);
        dialog.setMessage("Loading...");
        dialog.show();

        RestoViewModel model= ViewModelProviders.of(this).get(RestoViewModel.class);


        model.getUserMutableLiveData().observe(this, new Observer<List<RestoModel>>() {
           @Override
           public void onChanged(List<RestoModel> restoModels) {


               restoAdapter=new RestoAdapter(getContext(),restoModels);
               recyclerView.setAdapter(restoAdapter);

               dialog.cancel();
               dialog.dismiss();
           }
       });



        return  view;
    }




}
