package com.example.foodorder.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.foodorder.R;

public class PhoneNumber extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number);


        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                Intent i = new Intent(PhoneNumber.this, PhoneVarification.class);
                startActivity(i);

                finish();


            }
        }, 6000);
    }
}
