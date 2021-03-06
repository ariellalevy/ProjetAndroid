package com.example.ariellalevy.projetandroid_levy_ariella_grp31.vue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ariellalevy.projetandroid_levy_ariella_grp31.R;

public class HolderCharacters extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView txtFirstLine;
    public TextView txtFooter;
    public ImageView imageView;
    public View layout;
    public Animation animation;

    public HolderCharacters(View v) {
        super(v);
        layout = v;
        animation = AnimationUtils.loadAnimation(v.getContext(),R.anim.anim);
        v.setOnClickListener(this);
        txtFirstLine = (TextView) v.findViewById(R.id.firstLine);
        txtFooter = (TextView) v.findViewById(R.id.secondLine);
        imageView = (ImageView)v.findViewById(R.id.icon);
    }

    public void onClick(View v) {
        //Toast.makeText(v.getContext(), txtFirstLine.getText(), Toast.LENGTH_SHORT).show();
        FragementCharacter fragementCharacter = new FragementCharacter();
        v.startAnimation(animation);
        ((MainActivity)v.getContext()).addAgrument("donnee", txtFirstLine.getText(), fragementCharacter);
        ((MainActivity)v.getContext()).loadFragment(fragementCharacter);
    }
}