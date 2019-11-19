package com.example.ariellalevy.projetandroid_levy_ariella_grp31.vue;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.ariellalevy.projetandroid_levy_ariella_grp31.R;
import com.example.ariellalevy.projetandroid_levy_ariella_grp31.controler.ControllerFilm;
import com.example.ariellalevy.projetandroid_levy_ariella_grp31.model.HarryPotterFilms;
import com.squareup.picasso.Picasso;

public class MainActivityFilm  extends AppCompatActivity {
    public ImageView imageView;
    public TextView txtFirstLine;
    public TextView txtSecondLine;
    public TextView txtTroisiemeLine;
    public TextView txtQuatriemeLine;
    public TextView txtCinquiemeLine;
    public VideoView videoView;
    public MediaController mediaController;
    public Uri uri;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_film);
        Intent activ = getIntent();
        String donnee = activ.getStringExtra("donnee");
        SharedPreferences sharedPreferences = this.getSharedPreferences("user_prefs", Context.MODE_PRIVATE);
        ControllerFilm controller = new ControllerFilm(this,sharedPreferences,donnee);
        controller.start();
        mediaController= new MediaController(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Intent mainActivity;
        int id = item.getItemId();
        switch (id){
            case R.id.film:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                mainActivity = new Intent(this, MainActivityFilms.class);
                this.startActivity(mainActivity);
                return true;
            case R.id.characters:
                mainActivity = new Intent(this, MainActivityCharacters.class);
                this.startActivity(mainActivity);
                return true;
            case R.id.home:
                mainActivity = new Intent(this, MainActivity.class);
                this.startActivity(mainActivity);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showFilm(HarryPotterFilms film) {
        imageView = (ImageView) findViewById(R.id.icon);
        txtFirstLine = (TextView) findViewById(R.id.firstLine);
        txtSecondLine = (TextView) findViewById(R.id.secondLine);
        txtTroisiemeLine = (TextView) findViewById(R.id.troisiemeLine);
        txtQuatriemeLine = (TextView) findViewById(R.id.quatriemeLine);
        txtCinquiemeLine = (TextView) findViewById(R.id.cinquiemeLine);
        videoView =(VideoView)findViewById(R.id.vdVw);
        Picasso.with(this).load(film.getImage()).into(imageView);
        txtFirstLine.setText(film.getName());
        txtSecondLine.setText("Year: " + film.getYear());
        txtTroisiemeLine.setText("Director: " + film.getDirector());
        txtQuatriemeLine.setText("Producer: " + film.getProducer());
        txtCinquiemeLine.setText("Resume: " + film.getResume());
        mediaController.setAnchorView(videoView);
        //uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.harrypotter1);
        this.showVideo(film);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
    }

    public void showVideo(HarryPotterFilms film){
        switch (film.getVideo()){
            case "harrypotter1":
                uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.harrypotter1);
                break;
            case "harrypotter2":
                uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.harrypotter2);
                break;
            case "harrypotter3":
                uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.harrypotter3);
                break;
            case "harrypotter4":
                uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.harrypotter4);
                break;
            case "harrypotter5":
                uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.harrypotter5);
                break;
            case "harrypotter6":
                uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.harrypotter6);
                break;
            case "harrypotter71":
                uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.harrypotter71);
                break;
            case "harrypotter72":
                uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.harrypotter72);
                break;
        }
    }
}
