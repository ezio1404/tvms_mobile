package com.example.administrator.tvms;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

public class pdf2 extends AppCompatActivity {
    PDFView pdf;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdf2);
        pdf=findViewById(R.id.pdf2);
        pdf.fromAsset("IRR_RA-10666.pdf").load();
    }
}
