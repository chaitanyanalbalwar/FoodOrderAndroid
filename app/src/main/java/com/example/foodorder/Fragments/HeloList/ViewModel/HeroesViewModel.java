package com.example.foodorder.Fragments.HeloList.ViewModel;

import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.foodorder.Fragments.HeloList.Api;
import com.example.foodorder.Fragments.HeloList.Model.Hero;
import com.example.foodorder.Fragments.Restourant.Model.RestoModel;
import com.example.foodorder.Fragments.Restourant.RestoGridViewAdapter;
import com.example.foodorder.Util.AppController;
import com.example.foodorder.Util.Url;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HeroesViewModel extends ViewModel {

    private MutableLiveData<List<Hero>> heroList;

    ArrayList<Hero> list;

    RequestQueue requestQueue;

    public LiveData<List<Hero>> getHeroes() {
        //if the list is null
        if (heroList == null) {
            heroList = new MutableLiveData<List<Hero>>();
          //  loadHeroes();

            getData();
        }

        //finally we will return the list
        return heroList;
    }

    private void loadHeroes() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<List<Hero>> call = api.getHeroes();


        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {

                //finally we are setting the list to our MutableLiveData
                heroList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {

            }
        });
    }


    private void getData(){



        requestQueue = Volley.newRequestQueue(AppController.getAppContext());

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, "https://simplifiedcoding.net/demos/marvel/", null,
                new com.android.volley.Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        try{

                            list=new ArrayList<>();
                            // Loop through the array elements
                            for(int i=0;i<response.length();i++){
                                // Get current json object
                                JSONObject jsonObject = response.getJSONObject(i);

                                String name=jsonObject.getString("name");
                                String realname=jsonObject.getString("realname");
                                String team=jsonObject.getString("team");
                                String firstappearance=jsonObject.getString("firstappearance");
                                String createdby=jsonObject.getString("createdby");
                                String publisher=jsonObject.getString("publisher");
                                String imageurl=jsonObject.getString("imageurl");
                                String bio=jsonObject.getString("bio");

                                Hero hero=new Hero(name,realname,team,firstappearance,createdby,publisher,imageurl,bio);
                                list.add(hero);

                            }

                            heroList.setValue(list);

                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                },
                new com.android.volley.Response.ErrorListener(){
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
