package com.example.foodorder.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodorder.Adapter.ItemAdapter;
import com.example.foodorder.Model.ItemModel;
import com.example.foodorder.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemPage extends Fragment {


    RecyclerView recyclerView;

    ItemAdapter itemAdapter;
    ArrayList<ItemModel> itemModelArrayList;
    Button plus,minus;
    TextView qty;


    public ItemPage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_item_page, container, false);


        recyclerView=view.findViewById(R.id.recyclerView);

        plus=view.findViewById(R.id.plus);
        minus=view.findViewById(R.id.minus);
        qty=view.findViewById(R.id.qty);



        itemModelArrayList=new ArrayList<>();
        ItemModel itemModel=new ItemModel("Cheese","$ 0.30");
        ItemModel itemModel1=new ItemModel("Petty","$ 0.40");
        ItemModel itemModel2=new ItemModel("Becon","$ 0.50");

        itemModelArrayList.add(itemModel);
        itemModelArrayList.add(itemModel1);
        itemModelArrayList.add(itemModel2);


        itemAdapter=new ItemAdapter(getContext(),itemModelArrayList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(itemAdapter);


        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int totalQty= Integer.parseInt(qty.getText().toString());

                if (totalQty!=0){
                    totalQty=(totalQty)-1;

                    qty.setText(Integer.toString(totalQty));
                }else{
                    Toast.makeText(getContext(), "Please Add Item...", Toast.LENGTH_SHORT).show();
                }
            }
        });


        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int totalQty= Integer.parseInt(qty.getText().toString());

                totalQty=(totalQty)+1;
                qty.setText(Integer.toString(totalQty));

            }
        });

        return view;
    }

}
