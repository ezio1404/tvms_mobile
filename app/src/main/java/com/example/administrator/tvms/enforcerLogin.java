package com.example.administrator.tvms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class enforcerLogin extends AppCompatActivity implements View.OnClickListener {

    EditText username, password;
    Button login;
    private static String URL_LOGIN="http://192.168.1.51/tvms/loginDriver.php";
    EnforcerSessionManager enforcerSessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enforcer_login);
        username= findViewById(R.id.username);
        password = findViewById(R.id.password);
        enforcerSessionManager = new EnforcerSessionManager(this);
        login = findViewById(R.id.login);

        login.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.login) {
            String username,password;

            username=this.username.getText().toString().trim();
            password=this.password.getText().toString().trim();

            login(username,password);

        }
    }

    private void login(String username, String password) {
        StringRequest stringRequest =new StringRequest(Request.Method.POST, URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success=jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("login");
                            if(success.equals("1")){
                                for (int i = 0;i <jsonArray.length();i++){
                                        JSONObject object = jsonArray.getJSONObject(i);
                                    String username = object.getString("enforcer_email").trim();
                                    int id = object.getInt("enforcer_id");
                                    Toast.makeText(enforcerLogin.this,"Success Login. \nEmail:"+username,Toast.LENGTH_SHORT).show();

                                    enforcerSessionManager.createSession(username,id);
                                    Intent intent = new Intent(enforcerLogin.this,enforcerMain.class);
                                    intent.putExtra("enforcer_email",username);
                                    intent.putExtra("enforcer_id",id);
                                    startActivity(intent);
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(enforcerLogin.this,"Error "+e.toString(),Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(enforcerLogin.this,"Error "+error.toString(),Toast.LENGTH_SHORT).show();

                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String>  params= new HashMap<>();
                params.put("enforcer_email",username);
                params.put("enforcer_password",password);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
