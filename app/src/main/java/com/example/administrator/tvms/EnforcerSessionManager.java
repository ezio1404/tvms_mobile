package com.example.administrator.tvms;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

public class EnforcerSessionManager {
    SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public Context context;
    int PRIVATE_MODE =0;

    private static final String PREF_NAME="ENFORCER LOGIN";
    private static final String LOGIN="IS_LOGIN";
    public static final String ENF_EMAIL="enforcer_email";
    public static final String ENF_PASS="enforcer_password";
    public static final String ENF_ID="enforcer_id";

    public EnforcerSessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public void createSession(String username,int id){
        editor.putBoolean(LOGIN,true);
        editor.putString(ENF_EMAIL,username);
        editor.putString(ENF_ID, String.valueOf(id));
        editor.apply();
    }

    public boolean isLoggin(){
        return sharedPreferences.getBoolean(LOGIN,false);
    }
    public void checkLogin(){
        if(!this.isLoggin()){
            Intent i = new Intent(context,enforcerLogin.class);
            context.startActivity(i);
            ((enforcerMain)context).finish();
        }
    }

    public HashMap<String, String> getUserDetail(){
        HashMap<String, String> user = new  HashMap<>();
        user.put(ENF_EMAIL,sharedPreferences.getString(ENF_EMAIL,null));
        user.put(ENF_PASS,sharedPreferences.getString(ENF_PASS,null));
        user.put(ENF_ID,sharedPreferences.getString(ENF_ID,null));
        return user;
    }

    public void logout(){
        editor.clear();
        editor.commit();
        Intent i = new Intent(context,enforcerLogin.class);
        context.startActivity(i);
        ((enforcerMain)context).finish();
    }

}
