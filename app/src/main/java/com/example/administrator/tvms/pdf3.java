package com.example.administrator.tvms;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

public class pdf3 extends AppCompatActivity {

    PDFView pdf;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdf3);
        pdf=findViewById(R.id.pdf3);
        pdf.fromAsset("RA_8749.pdf").load();
    }
}
