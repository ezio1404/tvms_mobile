package com.example.administrator.tvms;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class driverLogin extends AppCompatActivity implements View.OnClickListener {

    EditText username, password;
    Button login;
    TextView log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.driver_login);

        username= (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        login = (Button) findViewById(R.id.login);

        login.setOnClickListener(this);
        log= findViewById(R.id.btn_log_enf);
        log.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.login) {
           String username,password;
           String URL = "http://localhost:8082/tvms/loginDriver.php";
            username=this.username.getText().toString();
            password=this.password.getText().toString();
            RequestQueue RQ= Volley.newRequestQueue(driverLogin.this);
            StringRequest SR = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.d("Response", response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    String response="error";
                    Log.d("Error.Response", response);
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String>  params = new HashMap<String, String>();
                    params.put("driver_email", username);
                    params.put("driver_password", password);
                    return super.getParams();
                }
            };


            startActivity(new Intent(this, driverMain.class));
        }
        if(v.getId() == R.id.btn_log_enf){
            startActivity(new Intent(this,enforcerLogin.class));
        }
    }
}




