package com.example.ariellalevy.projetandroid_levy_ariella_grp31.vue;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.ariellalevy.projetandroid_levy_ariella_grp31.R;
import com.example.ariellalevy.projetandroid_levy_ariella_grp31.controler.ControllerCharacter;
import com.example.ariellalevy.projetandroid_levy_ariella_grp31.controler.ControllerFilm;
import com.example.ariellalevy.projetandroid_levy_ariella_grp31.controler.ControllerFilms;
import com.example.ariellalevy.projetandroid_levy_ariella_grp31.model.HarryPotterFilms;
import com.squareup.picasso.Picasso;

public class FragementFilm extends Fragment {
    private static final String TAG = "FragementFilm";
    public ImageView imageView;
    public TextView txtFirstLine;
    public TextView txtSecondLine;
    public TextView txtTroisiemeLine;
    public TextView txtQuatriemeLine;
    public TextView txtCinquiemeLine;
    public VideoView videoView;
    public MediaController mediaController;
    public Uri uri;
    private View view;
    private Context thiscontext;
    private SharedPreferences sharedPreferences;
    String donnee;


    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        view  = inflater.inflate(R.layout.fragement_film, container, false);
        thiscontext = container.getContext();
        Bundle bundle=this.getArguments();
        if(bundle != null){
            donnee=bundle.getString("donnee");
        }
        Toast.makeText(getActivity(), donnee, Toast.LENGTH_SHORT).show();
        sharedPreferences = this.getActivity().getSharedPreferences("user_prefs", Context.MODE_PRIVATE);
        ControllerFilm controller = new ControllerFilm(this,sharedPreferences,donnee);
        controller.start();
        Log.d(TAG, "onCreateView: started.");
        return view;
    }

    public void showFilm(HarryPotterFilms film) {
        imageView = view.findViewById(R.id.icon);
        txtFirstLine = view.findViewById(R.id.firstLine);
        txtSecondLine = view.findViewById(R.id.secondLine);
        txtTroisiemeLine = view.findViewById(R.id.troisiemeLine);
        txtQuatriemeLine = view.findViewById(R.id.quatriemeLine);
        txtCinquiemeLine = view.findViewById(R.id.cinquiemeLine);
        Picasso.with(thiscontext).load(film.getImage()).into(imageView);
        txtFirstLine.setText(film.getName());
        txtSecondLine.setText("Year: " + film.getYear());
        txtTroisiemeLine.setText("Director: " + film.getDirector());
        txtQuatriemeLine.setText("Producer: " + film.getProducer());
        txtCinquiemeLine.setText("Resume: " + film.getResume());
        videoView = view.findViewById(R.id.vdVw);
        MediaController mediaController = new MediaController(getContext());
        videoView.setMediaController(mediaController);
        this.showVideo(film);
        videoView.setVideoURI(uri);
        mediaController.setAnchorView(videoView);
        videoView.start();
    }

    public void showVideo(HarryPotterFilms film){
        switch (film.getVideo()){
            case "harrypotter1":
                uri = Uri.parse("android.resource://" + thiscontext.getPackageName() + "/" + R.raw.harrypotter1);
                break;
            case "harrypotter2":
                uri = Uri.parse("android.resource://" + thiscontext.getPackageName() + "/" + R.raw.harrypotter2);
                break;
            case "harrypotter3":
                uri = Uri.parse("android.resource://" + thiscontext.getPackageName() + "/" + R.raw.harrypotter3);
                break;
            case "harrypotter4":
                uri = Uri.parse("android.resource://" + thiscontext.getPackageName() + "/" + R.raw.harrypotter4);
                break;
            case "harrypotter5":
                uri = Uri.parse("android.resource://" + thiscontext.getPackageName() + "/" + R.raw.harrypotter5);
                break;
            case "harrypotter6":
                uri = Uri.parse("android.resource://" + thiscontext.getPackageName() + "/" + R.raw.harrypotter6);
                break;
            case "harrypotter71":
                uri = Uri.parse("android.resource://" + thiscontext.getPackageName() + "/" + R.raw.harrypotter71);
                break;
            case "harrypotter72":
                uri = Uri.parse("android.resource://" + thiscontext.getPackageName() + "/" + R.raw.harrypotter72);
                break;
        }
    }
}
