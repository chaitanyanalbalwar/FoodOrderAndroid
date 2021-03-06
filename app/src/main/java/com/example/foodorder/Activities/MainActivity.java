package com.example.foodorder.Activities;


import android.os.Build;
import android.os.Bundle;

import com.example.foodorder.Fragments.Categeorymenu.CategeoryMenuFragment;
import com.example.foodorder.Fragments.HeloList.HeroListFragment;
import com.example.foodorder.Fragments.Menu.AllMenu;
import com.example.foodorder.Fragments.LayoutList;
import com.example.foodorder.Fragments.Restourant.RestourantList;
import com.example.foodorder.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.annotation.NonNull;
import android.view.MenuItem;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.Menu;


public class MainActivity extends AppCompatActivity  {

   Toolbar toolbar;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void init() {

        toolbar=findViewById(R.id.toolbar);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_home);

        toolbar.setTitle("Home");
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    toolbar.setTitle("Home");
                    fragment = new RestourantList();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_gifts:
                    toolbar.setTitle("");
                    fragment = new AllMenu();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_cart:
                    toolbar.setTitle("");
                    fragment = new CategeoryMenuFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_profile:
                    toolbar.setTitle("Profile");
                    return true;

            }


            return false;
        }
    };



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finishAffinity();
        finish();
    }
}
