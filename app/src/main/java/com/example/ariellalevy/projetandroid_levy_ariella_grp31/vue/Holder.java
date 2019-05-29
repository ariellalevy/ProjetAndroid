package com.example.ariellalevy.projetandroid_levy_ariella_grp31.vue;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ariellalevy.projetandroid_levy_ariella_grp31.R;

public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView txtFirstLine;
    public TextView txtFooter;
    public ImageView imageView;
    public View layout;

    public Holder(View v) {
        super(v);
        layout = v;
        v.setOnClickListener(this);
        txtFirstLine = (TextView) v.findViewById(R.id.firstLine);
        txtFooter = (TextView) v.findViewById(R.id.secondLine);
        imageView = (ImageView)v.findViewById(R.id.icon);
    }

    public void onClick(View v) {
        Toast.makeText(v.getContext(), txtFirstLine.getText(), Toast.LENGTH_SHORT).show();
        Intent main2Activity = new Intent(v.getContext(), Main2Activity.class);
        main2Activity.putExtra("donnee", txtFirstLine.getText());
        v.getContext().startActivity(main2Activity);

    }
}