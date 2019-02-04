package com.example.administrator.tvms;

import android.content.Context;
import android.content.SharedPreferences;

public class DriverSessionManager {
    SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public Context context;
    int PRIVATE_MODE =0;

    public DriverSessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("DRIVER LOGIN",PRIVATE_MODE);
    }

    public void createSession(){

    }
}
