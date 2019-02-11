package com.example.administrator.tvms;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

public class pdf1 extends AppCompatActivity {

    PDFView pdf;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdf1);
        pdf=findViewById(R.id.pdf1);
        pdf.fromAsset("IRR-RA_10586.pdf").load();
    }
}
