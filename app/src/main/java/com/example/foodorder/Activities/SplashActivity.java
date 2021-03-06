package com.example.foodorder.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.foodorder.Activities.Login.LoginActivity;
import com.example.foodorder.Fragments.Menu.Model.MainMenu;
import com.example.foodorder.R;

public class SplashActivity extends AppCompatActivity {

    public static final String MyPREFERENCES = "FoodOrder";
    SharedPreferences sp;
    SharedPreferences.Editor editor;

    private static int SPLASH_TIME_OUT = 500;
    Boolean success;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {

                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(i);


                /*Intent i = new Intent(SplashActivity.this, PhoneNumber.class);
                startActivity(i);*/

                    finish();

                }
            }, SPLASH_TIME_OUT);




        /*sp = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        editor = sp.edit();

        success = sp.getBoolean("Splash", false);*/

       /* if (success == true) {

        } else {


        }*/
    }

}
