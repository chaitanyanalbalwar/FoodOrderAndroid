package com.example.foodorder.Fragments.Restourant.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.foodorder.Fragments.Restourant.Model.RestoModel;
import com.example.foodorder.Util.AppController;
import com.example.foodorder.Util.Url;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RestoViewModel extends ViewModel {

   private MutableLiveData<List<RestoModel>> userLiveData;
    ArrayList<RestoModel> list;

    RequestQueue requestQueue;

    public MutableLiveData<List<RestoModel>> getUserMutableLiveData() {

        if(userLiveData==null){
            userLiveData=new MutableLiveData<List<RestoModel>>();
            getData();
        }
        return userLiveData;
    }



    private void getData(){

        requestQueue = Volley.newRequestQueue(AppController.getAppContext());

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, Url.RestoList, null,
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
                                String fileName=jsonObject.getString("fileName");

                                if (name!="null"){
                                    RestoModel restoModel1=new RestoModel(id,name,displayName,fileName);
                                    list.add(restoModel1);
                                }
                            }

                            userLiveData.setValue(list);

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
