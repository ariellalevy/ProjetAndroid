package com.example.ariellalevy.projetandroid_levy_ariella_grp31.vue;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ariellalevy.projetandroid_levy_ariella_grp31.R;

public class Holder extends RecyclerView.ViewHolder {
    public TextView txtFirstLine;
    public TextView txtFooter;
    public ImageView imageView;
    public View layout;

    public Holder(View v) {
        super(v);
        layout = v;
        txtFirstLine = (TextView) v.findViewById(R.id.firstLine);
        txtFooter = (TextView) v.findViewById(R.id.secondLine);
        imageView = (ImageView)v.findViewById(R.id.icon);
    }
}