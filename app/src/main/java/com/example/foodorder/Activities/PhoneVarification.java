package com.example.foodorder.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.foodorder.R;

import java.util.concurrent.TimeUnit;

public class PhoneVarification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_varification);


        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                Intent i = new Intent(PhoneVarification.this, PhoneVarified.class);
                startActivity(i);

                finish();
            }
        }, 6000);
    }
}
