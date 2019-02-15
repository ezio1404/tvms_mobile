package com.example.administrator.tvms;

import android.content.Intent;
import android.se.omapi.Session;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.HashMap;

public class driverMain extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private TextView username;
    DriverSessionManager driverSessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.driver_main);
        Intent intent=getIntent();

//        String extraUsername=intent.getStringExtra("driver_email");

        String extraUsername=intent.getStringExtra("driver_email");

        driverSessionManager=new DriverSessionManager(this);
        driverSessionManager.checkLogin();
        HashMap <String,String> user= driverSessionManager.getUserDetail();
        String username=user.get(driverSessionManager.DRIVER_EMAIL);
        String id=user.get(driverSessionManager.DRIVER_ID);

        Toast.makeText(driverMain.this,"Username : "+username +"id" +id ,Toast.LENGTH_SHORT);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new driver_homepage_frag()).commit();
            navigationView.setCheckedItem(R.id.nav_vr);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_vr:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new driver_vr_frag()).commit();
                break;
            case R.id.nav_vp:
                Intent vpIntent = new Intent(this, driver_vp_frag.class);
                startActivity(vpIntent);
                break;
//            case R.id.nav_inquire:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                        new driver_inquiry_frag()).commit();
//                break;
            case R.id.nav_eh:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                        new driver_hao_frag()).commit();
                Intent haoIntent = new Intent(this, driver_hao_frag.class);
                startActivity(haoIntent);

                break;
            case R.id.nav_settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new driver_settings_frag()).commit();
                break;
            case R.id.nav_services:
                Intent serviceIntent = new Intent(this, driver_services_frag.class);
                startActivity(serviceIntent);
                break;
            case R.id.nav_faqs:
                Intent fqs = new Intent(this, faq.class);
                startActivity(fqs);
                break;
            case R.id.nav_logout:
                driverSessionManager.logout();
                break;

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}