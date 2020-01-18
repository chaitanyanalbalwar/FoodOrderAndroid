package com.example.foodorder.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.foodorder.R;

public class LoginActivity extends AppCompatActivity {


    public static final String MyPREFERENCES = "FoodOrder";
    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        sp = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        editor = sp.edit();
    }
}
