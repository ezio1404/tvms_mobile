package com.example.administrator.tvms;

import android.app.DownloadManager;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class DriverServer {
    private Context mContext;
    private static final String TAG = "DriverServer";
    public DriverServer() {
    }

    public DriverServer(Context mContext) {
        this.mContext = mContext;
    }

    public void loginDriver(String mUrl, Driver driver) {
        RequestQueue queue = Volley.newRequestQueue(mContext);
        StringRequest request = new StringRequest(Request.Method.POST,mUrl,response->{
            Log.d(TAG, response);
        },error -> {
            Toast.makeText(mContext, "An error occured", Toast.LENGTH_SHORT).show();
        }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("driver_email", driver.getDriver_email());
                map.put("driver_password", driver.getDriver_password());
                return map;
            }
        };
        queue.add(request);
    }
}