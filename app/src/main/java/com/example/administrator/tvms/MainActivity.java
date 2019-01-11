package com.example.administrator.tvms;

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

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                    new driver_hompage_frag()).commit();
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
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new driver_vp_frag()).commit();
                break;
            case R.id.nav_inquire:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new driver_inquiry_frag()).commit();
                break;
            case R.id.nav_eh:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new driver_hao_frag()).commit();
                break;
            case R.id.nav_settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new driver_settings_frag()).commit();
                break;
//            case R.id.nav_faqs:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                        new driverFaq()).commit();

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