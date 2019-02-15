package com.example.administrator.tvms;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class driver_hao_frag extends AppCompatActivity {
    private static final String TAG = "driver_hao_frag";

    private ArrayList<String> mHotlines = new ArrayList<>();
    private ArrayList<String> mAgency = new ArrayList<>();
    private ArrayList<String> mImageUrl = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.driver_hao_frag);

        Log.d(TAG, "onCreate: started");
        initImageBitmaps();

    }

    private void initImageBitmaps(){

        mImageUrl.add("re/drawable/citom");
        mHotlines.add("253-9211");
        mAgency.add("CITOM for vehicle accidents");

        mImageUrl.add("re/drawable/citom");
        mHotlines.add("253-2181");
        mAgency.add("CITOM Board Office");

        mImageUrl.add("re/drawable/citom");
        mHotlines.add("253-9211");
        mAgency.add("Communication Center");

        mImageUrl.add("re/drawable/citom");
        mHotlines.add(" 255-1409");
        mAgency.add("Office of the Traffic Director");

        mImageUrl.add("re/drawable/citom");
        mHotlines.add("255-6872");
        mAgency.add("Legal Section");

        mImageUrl.add("re/drawable/citom");
        mHotlines.add("256-2626");
        mAgency.add("Control Section");

        mImageUrl.add("re/drawable/citom");
        mHotlines.add("254-9985");
        mAgency.add("Traffic Education");

        mImageUrl.add("re/drawable/citom");
        mHotlines.add("254-0995");
        mAgency.add("Planning Section");

        mImageUrl.add("re/drawable/citom");
        mHotlines.add("254-8453");
        mAgency.add("Traffic Violation Bureau");

        mImageUrl.add("re/drawable/citom");
        mHotlines.add("254-9985");
        mAgency.add("Traffic Engineering Section");

        initRecyclerView();
    }

    private void initRecyclerView(){
        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        HaoAdapter adapter = new HaoAdapter(mImageUrl,mHotlines,mAgency,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
