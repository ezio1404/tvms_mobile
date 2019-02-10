package com.example.administrator.tvms;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

public class DriverSessionManager {
    SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public Context context;
    int PRIVATE_MODE =0;

    private static final String PREF_NAME="DRIVER LOGIN";
    private static final String LOGIN="IS_LOGIN";
    public static final String DRIVER_EMAIL="driver_email";
    public static final String DRIVER_PASS="driver_password";
    public static final String DRIVER_ID="driver_id";


    public DriverSessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public void createSession(String username,int id){
        editor.putBoolean(LOGIN,true);
        editor.putString(DRIVER_EMAIL,username);
        editor.putString(DRIVER_ID, String.valueOf(id));
        editor.apply();
    }

    public boolean isLoggin(){
        return sharedPreferences.getBoolean(LOGIN,false);
    }
    public void checkLogin(){
        if(!this.isLoggin()){
            Intent i = new Intent(context,driverLogin.class);
            context.startActivity(i);
            ((driverMain)context).finish();
        }
    }

    public HashMap<String, String> getUserDetail(){
        HashMap<String, String> user = new  HashMap<>();
        user.put(DRIVER_EMAIL,sharedPreferences.getString(DRIVER_EMAIL,null));
        user.put(DRIVER_PASS,sharedPreferences.getString(DRIVER_PASS,null));
        user.put(DRIVER_ID,sharedPreferences.getString(DRIVER_ID,null));

        return user;
    }

    public void logout(){
        editor.clear();
        editor.commit();
        Intent i = new Intent(context,driverLogin.class);
        context.startActivity(i);
        ((driverMain)context).finish();
    }
}
