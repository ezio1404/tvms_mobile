package com.example.administrator.tvms;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class driver_services_frag extends AppCompatActivity implements View.OnClickListener{
    Button btn_nnp,btn_rnp,btn_ns,btn_nrp,btn_rrp,btn_LTOservices;
    Button btn_verify,btn_clearance,btn_CTS;
    Button btn_addPlateNo;
    EditText mPlateNo;
    public Activity c;
    public Dialog d;
    @Nullable


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.driver_services_frag);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.driver_lto);

        btn_LTOservices= findViewById(R.id.btn_LTOservices);
        btn_verify= findViewById(R.id.btn_verify);
        btn_clearance= findViewById(R.id.btn_clearance);
        btn_CTS= findViewById(R.id.btn_CTS);

        btn_nnp= findViewById(R.id.btn_nnp);
        btn_rnp= findViewById(R.id.btn_rnp);
        btn_ns= findViewById(R.id.btn_ns);
        btn_nrp= findViewById(R.id.btn_nrp);
        btn_rrp= findViewById(R.id.btn_rrp);


        btn_LTOservices.setOnClickListener(this);
        btn_verify.setOnClickListener(this);
        btn_clearance.setOnClickListener(this);
        btn_CTS.setOnClickListener(this);

        btn_nnp.setOnClickListener(this);
        btn_rnp.setOnClickListener(this);
        btn_ns.setOnClickListener(this);
        btn_nrp.setOnClickListener(this);
        btn_rrp.setOnClickListener(this);



    }



    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_LTOservices){
            AlertDialog.Builder mBuilder = new AlertDialog.Builder(driver_services_frag.this);
            View mView=getLayoutInflater().inflate(R.layout.driver_lto,null);
            Uri uri = Uri.parse("smsto:2600");
            Intent smsIntent = new Intent(Intent.ACTION_SENDTO,uri);
            String sms = null;
            switch(v.getId()){
                case R.id.btn_nnp:
                    sms="LTO NEW NON PRO";
//                    smsIntent.putExtra("sms_body","LTO NEW NON PRO");
                    break;
                case R.id.btn_rnp:
                    sms="LTO RENEW NON PRO";
//                    smsIntent.putExtra("sms_body","LTO RENEW NON PRO");
                    break;
                case R.id.btn_ns:
                    sms="LTO NEW STUDENT";
//                    smsIntent.putExtra("sms_body","LTO NEW STUDENT");
                    break;
                case R.id.btn_nrp:
                    sms="LTO NEW REG PRIVATE";
//                    smsIntent.putExtra("sms_body","LTO NEW REG PRIVATE");
                    break;
                case R.id.btn_rrp:
                    sms="LTO RENEW REG PRIVATE";
//                    smsIntent.putExtra("sms_body","LTO RENEW REG PRIVATE");
                    break;
            }
            mBuilder.setView(mView);
            AlertDialog dialog = mBuilder.create();
            dialog.show();
            smsIntent.putExtra("sms_body",sms);
            startActivity(smsIntent);
        }
        if(v.getId()==R.id.btn_verify){
            AlertDialog.Builder mBuilder = new AlertDialog.Builder(driver_services_frag.this);
            View mView=getLayoutInflater().inflate(R.layout.driver_verify,null);

            btn_addPlateNo=mView.findViewById(R.id.btn_addPlateNo);
            mPlateNo=mView.findViewById(R.id.mPlateNo);
            String plateNo=mPlateNo.getText().toString().trim();
            btn_addPlateNo.setOnClickListener(v1 -> {
                Uri uri = Uri.parse("smsto:2600");
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO,uri);
                smsIntent.putExtra("sms_body","LTO VEHICLE "+plateNo);
                startActivity(smsIntent);
            });
            mBuilder.setView(mView);
            AlertDialog dialog = mBuilder.create();
            dialog.show();


        }
        if(v.getId()==R.id.btn_clearance){

        }
        if(v.getId()==R.id.btn_CTS){

        }
    }

}
