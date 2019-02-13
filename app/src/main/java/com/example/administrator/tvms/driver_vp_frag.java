package com.example.administrator.tvms;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class driver_vp_frag extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private VP_adapter mExampleAdapter;
    private ArrayList<VPItem> mExampleList;
    private RequestQueue mRequestQueue;


    private static String URL_VP="http://localhost:80/tvms/getAllVP.php";

    private static String URL_AGENCY="http://localhost:8080/tvms/getAllAgency.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.driver_vp_frag);


        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mExampleList = new ArrayList<>();
        mRequestQueue = Volley.newRequestQueue(this);
        parseJSON();
        mRecyclerView.setAdapter(mExampleAdapter);
    }

    private void parseJSON() {
        JsonObjectRequest request= new JsonObjectRequest(Request.Method.GET, URL_VP, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONArray jsonArray = response.getJSONArray("violation");


                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject violationsAndPenalties = jsonArray.getJSONObject(i);
                        String ordinanceNo = violationsAndPenalties.getString("ordinanceNo");
                        String articleNo = violationsAndPenalties.getString("articleNo");
                        String desc = violationsAndPenalties.getString("violation");
                        String penalty = violationsAndPenalties.getString("penalty");

                        mExampleList.add(new VPItem(ordinanceNo, articleNo, desc,penalty));
                    }
                    mExampleAdapter = new VP_adapter(driver_vp_frag.this, mExampleList);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mRequestQueue.add(request);
    }



}
