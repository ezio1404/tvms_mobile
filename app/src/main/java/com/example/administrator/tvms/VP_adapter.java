package com.example.administrator.tvms;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class VP_adapter extends RecyclerView.Adapter<VP_adapter.VPViewHolder> {
    private Context mContext;
    private ArrayList<VPItem> mVPlist;

    public VP_adapter(Context context, ArrayList<VPItem> VPlist) {
        mContext = context;
        mVPlist = VPlist;
    }

    @Override
    public VPViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.vp_list_item, parent, false);
        return new VPViewHolder(v);
    }

    @Override
    public void onBindViewHolder(VPViewHolder holder, int position) {
        VPItem currentItem = mVPlist.get(position);



        int id=currentItem.getId();
        String ordinanceNo=currentItem.getOrdinanceNo();
        String articleNo=currentItem.getArticleNo();
        String violation=currentItem.getVioaltion();
        float penalty=currentItem.getPenalty();


        holder.ordinanceNo.setText(ordinanceNo);
        holder.articleNo.setText(articleNo);
        holder.violation.setText(violation);
        holder.penalty.setText((int) penalty);


    }

    @Override
    public int getItemCount() {
        return mVPlist.size();
    }

    public class VPViewHolder extends RecyclerView.ViewHolder {
        int id;
        public TextView ordinanceNo;
        public TextView articleNo;
        public TextView violation;
        public TextView penalty;

        public VPViewHolder(View itemView) {
            super(itemView);
            TextView ordinanceNo = (TextView)itemView.findViewById(R.id.ordinanceNo);
            TextView articleNo = (TextView)itemView.findViewById(R.id.articleNo);
            TextView violation = (TextView)itemView.findViewById(R.id.violation);
            TextView penalty = (TextView)itemView.findViewById(R.id.penalty);
        }
    }
}