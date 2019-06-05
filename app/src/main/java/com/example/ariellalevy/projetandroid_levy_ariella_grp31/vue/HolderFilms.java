package com.example.ariellalevy.projetandroid_levy_ariella_grp31.vue;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ariellalevy.projetandroid_levy_ariella_grp31.R;

public class HolderFilms extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView txtFirstLine;
    public TextView txtFooter;
    public ImageView imageView;
    public View layout;
    public Animation animation;

    public HolderFilms(View v) {
        super(v);
        layout = v;
        animation = AnimationUtils.loadAnimation(v.getContext(),R.anim.anim);
        v.setOnClickListener(this);
        txtFirstLine = (TextView) v.findViewById(R.id.firstLine);
        txtFooter = (TextView) v.findViewById(R.id.secondLine);
        imageView = (ImageView)v.findViewById(R.id.icon);
    }

    public void onClick(View v) {
        Toast.makeText(v.getContext(), txtFirstLine.getText(), Toast.LENGTH_SHORT).show();
        v.startAnimation(animation);
        Intent main2Activity = new Intent(v.getContext(), MainActivityFilm.class);
        main2Activity.putExtra("donnee", txtFirstLine.getText());
        v.getContext().startActivity(main2Activity);

    }
}
