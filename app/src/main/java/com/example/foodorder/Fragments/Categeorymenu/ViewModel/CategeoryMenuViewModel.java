package com.example.foodorder.Fragments.Categeorymenu.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.foodorder.Fragments.Categeorymenu.Model.CategeoryModel;
import com.example.foodorder.Fragments.Restourant.Model.RestoModel;
import com.example.foodorder.Util.AppController;
import com.example.foodorder.Util.Url;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CategeoryMenuViewModel extends ViewModel {

    private MutableLiveData<List<CategeoryModel>> mutableLiveData;

    ArrayList<CategeoryModel> list;

    RequestQueue requestQueue;

    public MutableLiveData<List<CategeoryModel>> getMutableLiveData(){

        if (mutableLiveData==null){
            mutableLiveData=new MutableLiveData<List<CategeoryModel>>();
            getData();
        }
        return mutableLiveData;
    }

    private void getData() {

        requestQueue = Volley.newRequestQueue(AppController.getAppContext());

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, Url.CategeogyMenu, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        list=new ArrayList<>();

                        try{
                            // Loop through the array elements
                            for(int i=0;i<response.length();i++){
                                // Get current json object
                                JSONObject jsonObject = response.getJSONObject(i);

                                String id=jsonObject.getString("id");
                                String name=jsonObject.getString("name");
                                String displayName=jsonObject.getString("displayName");
                                String quality=jsonObject.getString("quality");
                                String fileName=jsonObject.getString("fileName");

                                if (name!="null"){
                                    CategeoryModel restoModel1=new CategeoryModel(id,name,displayName,quality,fileName);
                                    list.add(restoModel1);
                                }
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
