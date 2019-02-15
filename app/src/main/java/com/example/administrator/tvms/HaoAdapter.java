package com.example.administrator.tvms;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.sql.Array;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class HaoAdapter extends RecyclerView.Adapter<HaoAdapter.ViewHolder> {

    private static final String TAG = "HaoAdapter";

    private ArrayList<String> mImage= new ArrayList<>();
    private ArrayList<String> mHotlines= new ArrayList<>();
    private ArrayList<String> mAgency= new ArrayList<>();
    private Context mContext;

    public HaoAdapter(ArrayList<String> mImage, ArrayList<String> mHotlines, ArrayList<String> mAgency, Context context) {
        this.mImage = mImage;
        this.mHotlines = mHotlines;
        this.mAgency = mAgency;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
       View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.driver_hao_list_item,viewGroup,false);
       ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder( ViewHolder viewHolder, int i) {
        Log.d(TAG, "onBindViewHolder: Called");
        Glide.with(mContext).asBitmap().load(mImage.get(i)).into(viewHolder.image);

        viewHolder.hotline.setText(mHotlines.get(i));
        viewHolder.agency.setText(mAgency.get(i));

    }

    @Override
    public int getItemCount() {
        return mHotlines.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView image;
        TextView agency;
        TextView hotline;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            hotline = itemView.findViewById(R.id.hotline);
            agency = itemView.findViewById(R.id.agency);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
