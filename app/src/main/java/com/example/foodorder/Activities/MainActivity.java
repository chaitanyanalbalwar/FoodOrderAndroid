package com.example.foodorder.Activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.foodorder.Fragments.MainFragment;
import com.example.foodorder.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

    public static final String MyPREFERENCES = "FoodOrder";
    SharedPreferences sp;
    SharedPreferences.Editor editor;


    ListView menulistview;
    protected DrawerLayout drawer;
    FrameLayout frameLayout;
    ImageView userImage;
    TextView username, email;
    private ArrayList<String> mitms;
    private ArrayAdapter mStringAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        editor = sp.edit();


        menulistview = findViewById(R.id.menuList);


        mitms = new ArrayList<>();
        mitms.add("Home");
        mitms.add("Order History");
        mitms.add("Track Order");
        mitms.add("Logout");

        mStringAdaptor = new ArrayAdapter<String>(this, R.layout.drawer_list_item, mitms);
        menulistview.setAdapter(mStringAdaptor);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        init();

    }

    private void init() {

        frameLayout = findViewById(R.id.frameLayout);
        userImage = findViewById(R.id.userImage);
        username = findViewById(R.id.userName);
        email = findViewById(R.id.userEmail);

        menulistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Class fragmentClass = null;
                Fragment fragment = null;

                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                String name = parent.getItemAtPosition(position).toString();


                if (name.equalsIgnoreCase("Home")) {
                    fragment = new MainFragment();
                } else if (name.equalsIgnoreCase("Logout")){


                    editor.clear();
                    editor.commit();

                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }



                if (fragment != null) {
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.frameLayout, fragment);
                    ft.commit();
                }
                drawer.closeDrawer(GravityCompat.START);
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

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




    public void clearLogin(){

        // clear pref every 5 min .

        if (sp.getLong("ExpiredDate", -1) > System.currentTimeMillis()) {

        } else {

            editor.clear();
            editor.apply();
        }
    }
}
