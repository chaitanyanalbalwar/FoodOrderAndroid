package com.example.foodorder.HotelList.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.foodorder.HotelList.Model.HotelNameModel;
import com.example.foodorder.HotelList.Repo.HotelListRepo;

import java.util.List;

public class HotelListViewModel extends ViewModel {

    private MutableLiveData<List<HotelNameModel>> mList;
    HotelListRepo mRepo;

    public void init(){
        if (mList!=null){
            return;
        }
        mRepo=HotelListRepo.getInstance();
        mList=mRepo.getHotelList();

    }

    public LiveData<List<HotelNameModel>> getHotelList(){
        return mList;
    }
}
