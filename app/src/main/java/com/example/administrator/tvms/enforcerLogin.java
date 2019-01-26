package com.example.administrator.tvms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class enforcerLogin extends AppCompatActivity implements View.OnClickListener {

    EditText username, password;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enforcer_login);
        username= findViewById(R.id.username);
        password = findViewById(R.id.password);

        login = findViewById(R.id.login);

        login.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.login) {
            startActivity(new Intent(this, enforcer_violator_frag.class));
        }
    }
}
