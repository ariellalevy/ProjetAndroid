package com.example.ariellalevy.projetandroid_levy_ariella_grp31;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class Holder extends RecyclerView.ViewHolder {
    public TextView txtFirstLine;
    public TextView txtFooter;
    public View layout;

    public Holder(View v) {
        super(v);
        layout = v;
        txtFirstLine = (TextView) v.findViewById(R.id.firstLine);
        txtFooter = (TextView) v.findViewById(R.id.secondLine);
    }
}