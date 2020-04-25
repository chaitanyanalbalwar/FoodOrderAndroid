package com.example.foodorder.Fragments.Tax.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.foodorder.Fragments.Restourant.Model.RestoModel;
import com.example.foodorder.Fragments.Tax.Model.OrderType;
import com.example.foodorder.Fragments.Tax.Model.TaxModel;
import com.example.foodorder.Fragments.Tax.Model.TaxType;
import com.example.foodorder.Util.AppController;
import com.example.foodorder.Util.Url;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TaxViewModel extends ViewModel {

    private MutableLiveData<List<TaxModel>> mutableLiveData;

    ArrayList<TaxModel> list;

    ArrayList<OrderType> orderTypeArrayList;
    ArrayList<TaxType> taxTypeArrayList;

    RequestQueue requestQueue;

    public MutableLiveData<List<TaxModel>> getMutableLiveData(){

        if (mutableLiveData==null){
            mutableLiveData=new MutableLiveData<List<TaxModel>>();

            getData();
        }
        return mutableLiveData;
    }



    private void getData(){

        requestQueue = Volley.newRequestQueue(AppController.getAppContext());

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, Url.Tax, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        list=new ArrayList<>();

                        try{
                            // Loop through the array elements
                            for(int i=0;i<response.length();i++){

                                taxTypeArrayList=new ArrayList<>();
                                orderTypeArrayList=new ArrayList<>();

                                // Get current json object
                                JSONObject jsonObject = response.getJSONObject(i);

                                String id=jsonObject.getString("id");
                                String taxTitle=jsonObject.getString("taxTitle");
                                String displayName=jsonObject.getString("displayName");
                                String taxAmount=jsonObject.getString("taxAmount");
                                String taxDesc=jsonObject.getString("taxDescription");


                                JSONObject jsonObject1=jsonObject.getJSONObject("taxType");

                                String tId=jsonObject1.getString("id");
                                String taxType=jsonObject1.getString("taxType");

                                TaxType taxType1=new TaxType(tId,taxType);
                                taxTypeArrayList.add(taxType1);

                                JSONObject jsonObject2=jsonObject.getJSONObject("orderType");

                                String oId=jsonObject2.getString("id");
                                String orderType=jsonObject2.getString("taxType");

                                OrderType orderType1=new OrderType(oId,orderType);
                                orderTypeArrayList.add(orderType1);


                                TaxModel tm=new TaxModel(id,taxTitle,displayName,taxAmount,taxDesc,taxTypeArrayList,orderTypeArrayList);
                                list.add(tm);

                            }

                            mutableLiveData.setValue(list);

                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
                        // Do something when error occurred

                        error.printStackTrace();

                    }
                }
        );

        // Add JsonArrayRequest to the RequestQueue
        requestQueue.add(jsonArrayRequest);
    }
}
