package com.example.administrator.tvms;

import android.app.AlertDialog;
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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class enforcer_services_frag  extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    Button btn_nnp, btn_rnp, btn_ns, btn_nrp, btn_rrp, btn_LTOservices;
    Button btn_verify, btn_clearance, btn_CTS;
    Button btn_addPlateNo, btn_requestClearance, btn_requestCTS;
    EditText mPlateNo, clearance_plateNo;
    EditText cts_plateNo, cts_address, cts_desc;
    Spinner spinnerAgency;
    ArrayList<Service> services = new ArrayList<>();
    EnforcerSessionManager enforcerSessionManager;
    private static String URL_ADDCLEARANCE="http://192.168.1.51/tvms/addclearanceenf.php";
    private static String URL_LOADAGENCY="http://192.168.1.51/tvms/loadAgency.php";
    private ServicesDropdownAdapter adapter;
    private String catId;
    private String enforcer_id;
    private String  ClearancePlateNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enforcer_services_frag);


        btn_LTOservices = findViewById(R.id.btn_LTOservices);
        btn_verify = findViewById(R.id.btn_verify);
        btn_clearance = findViewById(R.id.btn_clearance);
//        btn_CTS = findViewById(R.id.btn_CTS);

        btn_LTOservices.setOnClickListener(this);
        btn_verify.setOnClickListener(this);
        btn_clearance.setOnClickListener(this);
//        btn_CTS.setOnClickListener(this);


        enforcerSessionManager=new EnforcerSessionManager(this);
        enforcerSessionManager.checkLogin();
        HashMap <String,String> user= enforcerSessionManager.getUserDetail();
        //String username=user.get(driverSessionManager.DRIVER_EMAIL);
        enforcer_id =user.get(enforcerSessionManager.ENF_ID);

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_LTOservices) {

//            Toast.makeText(this,"shit",Toast.LENGTH_LONG).show();
            AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
            mBuilder.setTitle(getString(R.string.stringLTO));
            View mView = getLayoutInflater().inflate(R.layout.enforcer_lto_services, null);
            btn_nnp = mView.findViewById(R.id.btn_nnp);
            btn_rnp = mView.findViewById(R.id.btn_rnp);
            btn_ns = mView.findViewById(R.id.btn_ns);
            btn_nrp = mView.findViewById(R.id.btn_nrp);
            btn_rrp = mView.findViewById(R.id.btn_rrp);

            btn_nnp.setOnClickListener(v1 -> {
                Uri uri = Uri.parse("smsto:2600");
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO, uri);
                smsIntent.putExtra("sms_body", "LTO NEW NON PRO");
                startActivity(smsIntent);
            });
            btn_rnp.setOnClickListener(v1 -> {
                Uri uri = Uri.parse("smsto:2600");
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO, uri);
                smsIntent.putExtra("sms_body", "LTO RENEW NON PRO");
                startActivity(smsIntent);
            });
            btn_ns.setOnClickListener(v1 -> {
                Uri uri = Uri.parse("smsto:2600");
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO, uri);
                smsIntent.putExtra("sms_body", "LTO NEW STUDENT");
                startActivity(smsIntent);
            });
            btn_nrp.setOnClickListener(v1 -> {
                Uri uri = Uri.parse("smsto:2600");
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO, uri);
                smsIntent.putExtra("sms_body", "LTO NEW REG PRIVATE");
                startActivity(smsIntent);
            });
            btn_rrp.setOnClickListener(v1 -> {
                Uri uri = Uri.parse("smsto:2600");
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO, uri);
                smsIntent.putExtra("sms_body", "LTO RENEW REG PRIVATE");
                startActivity(smsIntent);
            });
            mBuilder.setPositiveButton("Ok",null);
            mBuilder.setView(mView);
            AlertDialog dialog = mBuilder.create();
            dialog.show();

        }
        if (v.getId() == R.id.btn_verify) {
            Toast.makeText(this, "shit", Toast.LENGTH_LONG).show();
            AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
            mBuilder.setTitle("Verify PlateNo");
            View mView = getLayoutInflater().inflate(R.layout.enforcer_verify, null);
            mPlateNo = mView.findViewById(R.id.mPlateNo);
            btn_addPlateNo = mView.findViewById(R.id.btn_addPlateNo);

            String plateNo = mPlateNo.getText().toString();
            btn_addPlateNo.setOnClickListener(v1 -> {
                Uri uri = Uri.parse("smsto:2600");
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO, uri);
                smsIntent.putExtra("sms_body", "LTO VEHICLE " + plateNo);
                startActivity(smsIntent);
            });
            mBuilder.setPositiveButton("Cancel",null);
            mBuilder.setView(mView);
            AlertDialog dialog = mBuilder.create();
            dialog.show();


        }
        if (v.getId() == R.id.btn_clearance) {
//            Toast.makeText(this,"shit",Toast.LENGTH_LONG).show();
            AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
            mBuilder.setTitle("Vehicle Clearance");
            View mView = getLayoutInflater().inflate(R.layout.enforcer_clearance, null);
//            clearance_plateNo = mView.findViewById(R.id.clearance_plateNo);
//            btn_requestClearance = mView.findViewById(R.id.btn_requestClearance);

            clearance_plateNo=mView.findViewById(R.id.clearance_plateNo);

            btn_requestClearance = mView.findViewById(R.id.btn_requestClearance);
            // spinnerAgency.setOnItemSelectedListener(this);
            spinnerAgency = mView.findViewById(R.id.spinAgency);

            loadAgency();

            populateSpinner();

            //
            ClearancePlateNo =clearance_plateNo.getText().toString();
            btn_requestClearance.setOnClickListener(v1 -> {
                addClearance();
                // addClearance();
                //code here to send request to the agency
                //missing list of agency
            });
            mBuilder.setPositiveButton("Cancel",null);
            mBuilder.setView(mView);
            AlertDialog dialog = mBuilder.create();
            dialog.show();
        }
//        if (v.getId() == R.id.btn_CTS) {
//            Toast.makeText(this, "shit", Toast.LENGTH_LONG).show();
//            AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
//            mBuilder.setTitle("Clamping/Towing Service");
//            View mView = getLayoutInflater().inflate(R.layout.enforcer_cts, null);
//            cts_plateNo = mView.findViewById(R.id.cts_plateNo);
//            cts_address = mView.findViewById(R.id.cts_address);
//            cts_desc = mView.findViewById(R.id.cts_desc);
//            btn_requestCTS = mView.findViewById(R.id.btn_requestCTS);
////            String mPlateNo,address,desc;
//            String mPlateNo = cts_plateNo.getText().toString();
//            String address = cts_address.getText().toString();
//            String desc = cts_desc.getText().toString();
//            btn_requestCTS.setOnClickListener(v1 -> {
//                //code here to send request to the agency
//                //missing list of agency
//            });
//            mBuilder.setPositiveButton("Cancel",null);
//            mBuilder.setView(mView);
//            AlertDialog dialog = mBuilder.create();
//            dialog.show();
//        }
    }
    private void populateSpinner() {

        // String [] items = new String[]{};
        adapter = new ServicesDropdownAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, services);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerAgency.setAdapter(adapter);
        spinnerAgency.setOnItemSelectedListener(this);
    }
    private void loadAgency() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LOADAGENCY,
                response -> {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        String success = jsonObject.getString("success");
                        JSONArray jsonArray = jsonObject.getJSONArray("load");
                        if(success.equals("1")){
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject object = jsonArray.getJSONObject(i);
                                Service s = new Service();
                                s.setAgency_id(object.getString("agency_id"));
                                s.setAgency_name(object.getString("agency_name"));
                                services.add(s);
                            }
                        }
                    }

                    catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(enforcer_services_frag.this,"Error "+e.toString(),Toast.LENGTH_SHORT).show();

                    }
                }
                , error -> Toast.makeText(enforcer_services_frag.this,"Error "+error.toString(),Toast.LENGTH_SHORT).show());

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    private void addClearance() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_ADDCLEARANCE,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject jsonObject;
                        try {
                            jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            if(success.equals("1")){
                                Toast.makeText(enforcer_services_frag.this, "Successfully added to Clearance", Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(enforcer_services_frag.this, "Error." + e.toString(), Toast.LENGTH_SHORT).show();

                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(enforcer_services_frag.this, "Error!" + error.toString(), Toast.LENGTH_SHORT).show();

                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String>  params= new HashMap<>();
                params.put("agency_id",catId);
                params.put("enforcer_id",enforcer_id);
                params.put("plate_no", ClearancePlateNo);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Service s = adapter.getItem(position);
        catId = s.getAgency_id();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
