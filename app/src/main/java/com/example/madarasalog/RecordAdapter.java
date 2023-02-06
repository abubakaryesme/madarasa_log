package com.example.madarasalog;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class RecordAdapter extends BaseAdapter {
    private Context context;
    private final ArrayList<RecordLog> records;
    public RecordAdapter(Context context, ArrayList<RecordLog> records) {
        this.context = context;
        this.records = records;
    }

    @Override
    public int getCount() {
        return records.size();
    }

    @Override
    public Object getItem(int position) {
        return records.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.single_item, parent, false);
        }
        RecordLog currentItem = (RecordLog) getItem(position);
        TextView date = (TextView)
                convertView.findViewById(R.id.txt_date);
        TextView sabak_lines = (TextView)
                convertView.findViewById(R.id.txt_lines);
        TextView sabak_sipara = (TextView)
                convertView.findViewById(R.id.txt_sipara);
        TextView sabki = (TextView)
                convertView.findViewById(R.id.txt_sabaqi);
        TextView manzil = (TextView)
                convertView.findViewById(R.id.txt_manzil);
        date.setText(currentItem.getDate());
        sabak_lines.setText(currentItem.getSabakLine().toString());
        sabak_sipara.setText(currentItem.getSabakSipara().toString());
        sabki.setText(currentItem.getSabki().toString());
        manzil.setText(currentItem.getManzil().toString());
        return convertView;
    }
}

