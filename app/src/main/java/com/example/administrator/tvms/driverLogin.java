package com.example.administrator.tvms;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class driverLogin extends AppCompatActivity implements View.OnClickListener {

    EditText username, password;
    Button login;
    TextView log;
    private static String URL_LOGIN="http://localhost:8080/tvms/loginDriver.php";
    DriverSessionManager driverSessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.driver_login);

        driverSessionManager = new DriverSessionManager(this);

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

            username=this.username.getText().toString().trim();
            password=this.password.getText().toString().trim();

//            login(username,password);

            startActivity(new Intent(this, driverMain.class));
        }
        if(v.getId() == R.id.btn_log_enf){
            startActivity(new Intent(this,enforcerLogin.class));
        }
    }

    private void login(String username, String password) {
        StringRequest stringRequest =new StringRequest(Request.Method.POST, URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success=jsonObject.getString("Success");
                            JSONArray jsonArray = jsonObject.getJSONArray("Driver login");
                            if(success.equals("1")){
                                for (int i = 0;i <jsonArray.length();i++){
                                    String username = jsonObject.getString("driver_email");
                                    int id = Integer.parseInt(jsonObject.getString("driver_id"));
                                   // Toast.makeText(driverLogin.this,"Success Login. \nEmail:"+username,Toast.LENGTH_SHORT).show();
                                   driverSessionManager.createSession(username,id);
                                    Intent intent = new Intent(driverLogin.this,driverMain.class);
                                   intent.putExtra("driver_email",username);
                                    intent.putExtra("driver_id",id);
                                   startActivity(intent);
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(driverLogin.this,"Error "+e.toString(),Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(driverLogin.this,"Error "+error.toString(),Toast.LENGTH_SHORT).show();

                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String>  params= new HashMap<>();
                params.put("driver_email",username);
                params.put("driver_password",password);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}




