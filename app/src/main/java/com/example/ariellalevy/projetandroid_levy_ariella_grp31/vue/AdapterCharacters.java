package com.example.ariellalevy.projetandroid_levy_ariella_grp31.vue;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ariellalevy.projetandroid_levy_ariella_grp31.R;
import com.example.ariellalevy.projetandroid_levy_ariella_grp31.model.HarryPotterCharacters;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class AdapterCharacters extends RecyclerView.Adapter<HolderCharacters> {

    public  Context context;
    private List<HarryPotterCharacters> values;

    public void add(int position, HarryPotterCharacters item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void xdremove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    public AdapterCharacters(List<HarryPotterCharacters> Dataset) {
        values = Dataset;
    }

    @Override
    public HolderCharacters onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        HolderCharacters vh = new HolderCharacters(v);
        return vh;
    }

    public void onBindViewHolder(HolderCharacters holder, final int position) {
        final HarryPotterCharacters currentCharacters = values.get(position);
        holder.txtFirstLine.setText(currentCharacters.getName());
        holder.txtFooter.setText("Actor: " + currentCharacters.getActor());
        context = holder.imageView.getContext();
        Picasso.with(context).load(currentCharacters.getImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return values.size();
    }
}