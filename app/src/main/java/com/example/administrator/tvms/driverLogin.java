package com.example.administrator.tvms;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class driverLogin extends AppCompatActivity implements View.OnClickListener {

    EditText username, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.driver_login);

        username= (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        login = (Button) findViewById(R.id.login);

        login.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        if(v == login) {
//            startActivity(new Intent(this, driverNavigationDrawer.class));
        }
    }
}
