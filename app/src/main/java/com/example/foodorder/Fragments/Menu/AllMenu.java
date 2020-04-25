package com.example.foodorder.Fragments.Menu;


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
import android.widget.Toast;

import com.example.foodorder.Fragments.Menu.Model.MainMenu;
import com.example.foodorder.Fragments.Menu.ViewModel.AllMenuViewModel;
import com.example.foodorder.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllMenu extends Fragment {

    MenuAdapter menuAdapter;
    RecyclerView recyclerView;

    ProgressDialog dialog;


    public AllMenu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_all_menu, container, false);

        recyclerView=view.findViewById(R.id.allMenuRecyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        dialog=new ProgressDialog(getContext());
        dialog.setCanceledOnTouchOutside(false);
        dialog.setMessage("Loading...");
        dialog.show();


        AllMenuViewModel model=ViewModelProviders.of(this).get(AllMenuViewModel.class);

        model.getUserMutableLiveData().observe(this, new Observer<List<MainMenu>>() {
            @Override
            public void onChanged(List<MainMenu> mainMenus) {

                if (mainMenus.size()>0){
                    menuAdapter=new MenuAdapter(getContext(),mainMenus);
                    recyclerView.setAdapter(menuAdapter);

                    dialog.cancel();
                    dialog.dismiss();

                }else {
                    Toast.makeText(getContext(), "No Data Available...", Toast.LENGTH_SHORT).show();

                    dialog.cancel();
                    dialog.dismiss();
                }



            }
        });




        return view;
    }

}
