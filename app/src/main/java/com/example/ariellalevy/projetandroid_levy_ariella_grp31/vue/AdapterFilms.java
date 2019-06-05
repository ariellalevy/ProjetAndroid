package com.example.ariellalevy.projetandroid_levy_ariella_grp31.vue;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ariellalevy.projetandroid_levy_ariella_grp31.R;
import com.example.ariellalevy.projetandroid_levy_ariella_grp31.model.HarryPotterCharacters;
import com.example.ariellalevy.projetandroid_levy_ariella_grp31.model.HarryPotterFilms;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterFilms extends RecyclerView.Adapter<HolderFilms>{

    public Context context;
    private List<HarryPotterFilms> values;

    public void add(int position, HarryPotterFilms item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void xdremove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    public AdapterFilms(List<HarryPotterFilms> Dataset) {
        values = Dataset;
    }

    @Override
    public HolderFilms onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        HolderFilms vh = new HolderFilms(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(HolderFilms holder, final int position) {
        final HarryPotterFilms currentFilm = values.get(position);
        holder.txtFirstLine.setText(currentFilm.getName());
        holder.txtFooter.setText("Year: " + currentFilm.getYear());
        context = holder.imageView.getContext();
        Picasso.with(context).load(currentFilm.getImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return values.size();
    }
}
