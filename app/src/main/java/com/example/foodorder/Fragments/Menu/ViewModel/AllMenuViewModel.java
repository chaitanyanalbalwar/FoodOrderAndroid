package com.example.foodorder.Fragments.Menu.ViewModel;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.android.volley.Request;
import com.android.volley.RequestQueue;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.foodorder.Fragments.Menu.Model.MainMenu;
import com.example.foodorder.Fragments.Menu.Model.SubMenu;
import com.example.foodorder.Util.AppController;
import com.example.foodorder.Util.Url;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AllMenuViewModel extends ViewModel {

   private MutableLiveData<List<MainMenu>> userLiveData;
   Context context;

    ArrayList<MainMenu> list;
    ArrayList<SubMenu> subMenuList;

    RequestQueue requestQueue;


    public MutableLiveData<List<MainMenu>> getUserMutableLiveData() {

        if(userLiveData==null){
            userLiveData=new MutableLiveData<List<MainMenu>>();

            getData();
        }
        return userLiveData;
    }


    private void  getData(){


        requestQueue = Volley.newRequestQueue(AppController.getAppContext());

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, Url.AllMenu, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        try{
                            // Loop through the array elements
                            for(int i=0;i<response.length();i++){
                                // Get current json object
                                JSONObject jsonObject = response.getJSONObject(i);

                                subMenuList=new ArrayList<>();

                                String id=jsonObject.getString("id");
                                String name=jsonObject.getString("name");
                                String shortCode=jsonObject.getString("shortCode");
                                String price=jsonObject.getString("price");
                                String description=jsonObject.getString("description");
                                String onlineDisplayName=jsonObject.getString("onlineDisplayName");
                                String avilable=jsonObject.getString("avilable");


                                JSONObject jsonObject1 = jsonObject.getJSONObject("cateogry");


                                String id1=jsonObject1.getString("id");
                                String name1=jsonObject1.getString("name");
                                String displayName=jsonObject1.getString("displayName");
                                String quality=jsonObject1.getString("quality");
                                String fileName=jsonObject1.getString("fileName");

                                SubMenu subMenu=new SubMenu(id1,name1,displayName,quality,fileName);
                                subMenuList.add(subMenu);


                                MainMenu mainMenu=new MainMenu(id,name,shortCode,price,description,onlineDisplayName,avilable,subMenuList);
                                list.add(mainMenu);

                            }
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
