package com.example.foodorder.Fragments.Categeorymenu;


import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.Toast;

import com.example.foodorder.Fragments.Categeorymenu.Model.CategeoryModel;
import com.example.foodorder.Fragments.Categeorymenu.ViewModel.CategeoryMenuViewModel;
import com.example.foodorder.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategeoryMenuFragment extends Fragment {


    CategeoryAdapter adapter;
    RecyclerView recyclerView;

    ProgressDialog dialog;
    LinearLayoutManager HorizontalLayout;

    public CategeoryMenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_categeory_menu, container, false);

        recyclerView=view.findViewById(R.id.categeoryRecyclerview);
        recyclerView.setHasFixedSize(true);
        HorizontalLayout = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(HorizontalLayout);

        dialog=new ProgressDialog(getContext());
        dialog.setCanceledOnTouchOutside(false);
        dialog.setMessage("Loading...");
        dialog.show();

        CategeoryMenuViewModel model= ViewModelProviders.of(this).get(CategeoryMenuViewModel.class);

        model.getMutableLiveData().observe(this, new Observer<List<CategeoryModel>>() {
            @Override
            public void onChanged(List<CategeoryModel> categeoryModels) {

                if (categeoryModels.size()!=0){
                    adapter=new CategeoryAdapter(getContext(),categeoryModels);
                    recyclerView.setAdapter(adapter);

                    dialog.cancel();
                    dialog.dismiss();
                }else {
                    dialog.cancel();
                    dialog.dismiss();

                    Toast.makeText(getContext(), "No Data Available...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

}
