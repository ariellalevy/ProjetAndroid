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

public class Adapter extends RecyclerView.Adapter<Holder> {

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

    public Adapter(List<HarryPotterCharacters> Dataset) {
        values = Dataset;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        Holder vh = new Holder(v);
        return vh;
    }

    public Bitmap getBitmapFromURL(String src) {
        try {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void onBindViewHolder(Holder holder, final int position) {
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