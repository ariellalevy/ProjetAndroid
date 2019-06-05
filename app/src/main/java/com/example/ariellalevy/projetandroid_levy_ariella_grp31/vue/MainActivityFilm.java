package com.example.ariellalevy.projetandroid_levy_ariella_grp31.vue;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_film);
        Intent activ = getIntent();
        String donnee = activ.getStringExtra("donnee");
        SharedPreferences sharedPreferences = this.getSharedPreferences("user_prefs", Context.MODE_PRIVATE);
        ControllerFilm controller = new ControllerFilm(this,sharedPreferences,donnee);
        controller.start();
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
        Picasso.with(this).load(film.getImage()).into(imageView);
        txtFirstLine.setText(film.getName());
        txtSecondLine.setText("Year: " + film.getYear());
        txtTroisiemeLine.setText("Director: " + film.getDirector());
        txtQuatriemeLine.setText("Producer: " + film.getProducer());
        txtCinquiemeLine.setText("Resume: " + film.getResume());
    }
}
