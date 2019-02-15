package com.example.administrator.tvms;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.HashMap;

public class enforcerMain extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    EnforcerSessionManager enforcerSessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enforcer_main);
d
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        enforcerSessionManager=new EnforcerSessionManager(this);
        enforcerSessionManager.checkLogin();
        HashMap<String,String> user= enforcerSessionManager.getUserDetail();
        String username=user.get(enforcerSessionManager.ENF_EMAIL);
        String id=user.get(enforcerSessionManager.ENF_ID);

        Toast.makeText(enforcerMain.this,"Username : "+username +"id" +id ,Toast.LENGTH_SHORT);



        drawer = findViewById(R.id.drawer_layout_enf);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new enforcer_homepage_frag()).commit();
            navigationView.setCheckedItem(R.id.nav_violator);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_violator:
                Intent gIntent = new Intent(this, enforcer_violator_frag.class);
                startActivity(gIntent);
                break;
            case R.id.nav_vp:
                Intent vpIntent = new Intent(this, enforcer_vp_frag.class);
                startActivity(vpIntent);
                break;

            case R.id.nav_eh:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new enforcer_hao_frag()).commit();
                break;
            case R.id.nav_settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new enforcer_settings_frag()).commit();
                break;
            case R.id.nav_services:
                Intent enfIntent= new Intent(this,enforcer_services_frag.class);
                startActivity(enfIntent);
            case R.id.nav_logout:
                enforcerSessionManager.logout();
                break;
            case R.id.nav_faqs:
                Intent fqs = new Intent(this, faq.class);
                startActivity(fqs);

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