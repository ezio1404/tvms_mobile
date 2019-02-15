package com.example.administrator.tvms;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ServicesDropdownAdapter extends ArrayAdapter<Service> {

//    private List<Service> serviceList;

    public ServicesDropdownAdapter(Context context, int resource, List<Service> list) {
        super(context, resource, list);
    }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        Service service = getItem(position);

        TextView textView = (TextView) super.getView(position, convertView, parent);

        textView.setTextColor(Color.BLACK);
      //  textView.setText(convert)
        assert service != null;
        textView.setText(service.getAgency_name());

        return textView;
    }

    @Override
    public View getDropDownView(int position, View convertView,  ViewGroup parent) {
        Service service = getItem(position);
        TextView textView = (TextView) super.getDropDownView(position, convertView, parent);

        textView.setTextColor(Color.BLACK);

        assert service != null;
        textView.setText(service.getAgency_name());

        return textView;
    }
}
