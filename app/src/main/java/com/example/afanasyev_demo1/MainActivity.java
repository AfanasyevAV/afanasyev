package com.example.afanasyev_demo1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNav;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.bottomNav);

        bottomNav.setOnNavigationItemSelectedListener(this);
        bottomNav.setSelectedItemId(R.id.item1);


    }
    Rooms firstFragment = new Rooms();
    Other secondFragment = new Other();
    Other thirdFragment = new Other();
    Settings fourthfragment = new Settings();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item1:
                getSupportFragmentManager().beginTransaction().replace(R.id.placeholder, firstFragment).commit();
                return true;


            case R.id.item2:
                getSupportFragmentManager().beginTransaction().replace(R.id.placeholder, secondFragment).commit();
                return true;

            case R.id.item3:
                getSupportFragmentManager().beginTransaction().replace(R.id.placeholder, thirdFragment).commit();
                return true;

            case R.id.item4:
                getSupportFragmentManager().beginTransaction().replace(R.id.placeholder, fourthfragment).commit();
                return true;

        }
        return false;
    }

}