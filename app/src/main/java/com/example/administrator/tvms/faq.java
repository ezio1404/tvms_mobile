package com.example.administrator.tvms;


import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import android.widget.Button;

public class faq extends AppCompatActivity {
    Button b1,b2,b3;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.faqs);

        b1= findViewById(R.id.b1);
        b2= findViewById(R.id.b2);
        b3= findViewById(R.id.b3);

        b1.setOnClickListener(v->{
            startActivity(new Intent(this,pdf1.class));
        });
        b2.setOnClickListener(v->{
        startActivity(new Intent(this,pdf2.class));
        });
        b3.setOnClickListener(v->{
            startActivity(new Intent(this,pdf3.class));
        });

    }
}
