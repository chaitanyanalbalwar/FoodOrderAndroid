package com.example.foodorder.HotelList.Repo;

import androidx.lifecycle.MutableLiveData;

import com.example.foodorder.HotelList.Model.HotelNameModel;

import java.util.ArrayList;
import java.util.List;

public class HotelListRepo {

    public static HotelListRepo instance;
    private ArrayList<HotelNameModel> nameList;

    public static HotelListRepo getInstance(){

        if (instance==null){
            instance=new HotelListRepo();
        }
        return instance;
    }

    public MutableLiveData<List<HotelNameModel>>  getHotelList(){

        nameList= new ArrayList<>();

        sethotelList();

        MutableLiveData<List<HotelNameModel>> list=new MutableLiveData<>();
        list.setValue(nameList);
        return list;
    }

    private void sethotelList() {

        HotelNameModel first=new HotelNameModel("first","https://images.pexels.com/photos/257360/pexels-photo-257360.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500");
        HotelNameModel second=new HotelNameModel("second","https://cdn.pixabay.com/photo/2017/02/01/22/02/mountain-landscape-2031539__340.jpg");
        HotelNameModel third=new HotelNameModel("US Burger","https://r-cf.bstatic.com/images/hotel/max1024x768/646/64605386.jpg");
        HotelNameModel Fourth=new HotelNameModel("Ambica Hotspot","https://pix10.agoda.net/hotelImages/43909/-1/b32fd19f6a62588b37a604b151f48312.jpg?s=1024x768");

        nameList.add(first);
        nameList.add(second);
        nameList.add(third);
        nameList.add(Fourth);
    }
}
