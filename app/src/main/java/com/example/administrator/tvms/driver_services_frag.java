package com.example.administrator.tvms;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class driver_services_frag extends AppCompatActivity implements View.OnClickListener{
    Button btn_nnp,btn_rnp,btn_ns,btn_nrp,btn_rrp,btn_LTOservices;
    Button btn_verify,btn_clearance,btn_CTS;
    Button btn_addPlateNo,btn_requestClearance,btn_requestCTS;
    EditText mPlateNo,clearance_plateNo;
    EditText cts_plateNo,cts_address,cts_desc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.driver_services_frag);


        btn_LTOservices= findViewById(R.id.btn_LTOservices);
        btn_verify= findViewById(R.id.btn_verify);
        btn_clearance= findViewById(R.id.btn_clearance);
        btn_CTS= findViewById(R.id.btn_CTS);
////
//        btn_nnp= findViewById(R.id.btn_nnp);
//        btn_rnp= findViewById(R.id.btn_rnp);
//        btn_ns= findViewById(R.id.btn_ns);
//        btn_nrp= findViewById(R.id.btn_nrp);
//        btn_rrp= findViewById(R.id.btn_rrp);


        btn_LTOservices.setOnClickListener(this);
        btn_verify.setOnClickListener(this);
        btn_clearance.setOnClickListener(this);
        btn_CTS.setOnClickListener(this);
//
//        btn_nnp.setOnClickListener(this);
//        btn_rnp.setOnClickListener(this);
//        btn_ns.setOnClickListener(this);
//        btn_nrp.setOnClickListener(this);
//        btn_rrp.setOnClickListener(this);



    }



    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_LTOservices){

//            Toast.makeText(this,"shit",Toast.LENGTH_LONG).show();
            AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
            mBuilder.setTitle("LTO Services");
            View mView=getLayoutInflater().inflate(R.layout.lto_services,null);
            btn_nnp= mView.findViewById(R.id.btn_nnp);
            btn_rnp= mView.findViewById(R.id.btn_rnp);
            btn_ns= mView.findViewById(R.id.btn_ns);
            btn_nrp= mView.findViewById(R.id.btn_nrp);
            btn_rrp= mView.findViewById(R.id.btn_rrp);

            btn_nnp.setOnClickListener(v1 -> {
                Uri uri = Uri.parse("smsto:2600");
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO,uri);
                smsIntent.putExtra("sms_body","LTO NEW NON PRO");
                startActivity(smsIntent);
            });
            btn_rnp.setOnClickListener(v1 -> {
                Uri uri = Uri.parse("smsto:2600");
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO,uri);
                smsIntent.putExtra("sms_body","LTO RENEW NON PRO");
                startActivity(smsIntent);
            });
            btn_ns.setOnClickListener(v1 -> {
                Uri uri = Uri.parse("smsto:2600");
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO,uri);
                smsIntent.putExtra("sms_body","LTO NEW STUDENT");
                startActivity(smsIntent);
            });
            btn_nrp.setOnClickListener(v1 -> {
                Uri uri = Uri.parse("smsto:2600");
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO,uri);
                smsIntent.putExtra("sms_body","LTO NEW REG PRIVATE");
                startActivity(smsIntent);
            });
            btn_rrp.setOnClickListener(v1 -> {
                Uri uri = Uri.parse("smsto:2600");
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO,uri);
                smsIntent.putExtra("sms_body","LTO RENEW REG PRIVATE");
                startActivity(smsIntent);
            });
            mBuilder.setView(mView);
            AlertDialog dialog = mBuilder.create();
            dialog.show();

        }
        if(v.getId()==R.id.btn_verify){
            Toast.makeText(this,"shit",Toast.LENGTH_LONG).show();
            AlertDialog.Builder mBuilder = new AlertDialog.Builder(driver_services_frag.this);
            mBuilder.setTitle("Verify PlateNo");
            View mView=getLayoutInflater().inflate(R.layout.driver_verify,null);
            mPlateNo=mView.findViewById(R.id.mPlateNo);
            btn_addPlateNo=mView.findViewById(R.id.btn_addPlateNo);

            String plateNo=mPlateNo.getText().toString();
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
//            Toast.makeText(this,"shit",Toast.LENGTH_LONG).show();
            AlertDialog.Builder mBuilder = new AlertDialog.Builder(driver_services_frag.this);
            mBuilder.setTitle("Vehicle Clearance");
            View mView=getLayoutInflater().inflate(R.layout.driver_clearance,null);
            clearance_plateNo=mView.findViewById(R.id.clearance_plateNo);
            btn_requestClearance = mView.findViewById(R.id.btn_requestClearance);

            String mPlateNo=clearance_plateNo.getText().toString();
            btn_requestClearance.setOnClickListener(v1 -> {
                    //code here to send request to the agency
                    //missing list of agency
            });

        }
        if(v.getId()==R.id.btn_CTS){
            Toast.makeText(this,"shit",Toast.LENGTH_LONG).show();
            AlertDialog.Builder mBuilder = new AlertDialog.Builder(driver_services_frag.this);
            mBuilder.setTitle("Clamping/Towing Service");
            View mView=getLayoutInflater().inflate(R.layout.driver_cts,null);
            cts_plateNo=mView.findViewById(R.id.cts_plateNo);
            cts_address = mView.findViewById(R.id.cts_address);
            cts_desc=mView.findViewById(R.id.cts_desc);
            btn_requestCTS=mView.findViewById(R.id.btn_requestCTS);
//            String mPlateNo,address,desc;
            String mPlateNo=cts_plateNo.getText().toString();
            String address=cts_address.getText().toString();
            String desc=cts_desc.getText().toString();
            btn_requestCTS.setOnClickListener(v1 -> {
                //code here to send request to the agency
                //missing list of agency
            });
        }
    }

}
