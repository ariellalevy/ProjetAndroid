package com.example.ariellalevy.projetandroid_levy_ariella_grp31.vue;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ariellalevy.projetandroid_levy_ariella_grp31.R;
import com.example.ariellalevy.projetandroid_levy_ariella_grp31.controler.ControllerFilm;

public class MainActivity extends AppCompatActivity {
    public ImageView imageView;
    public TextView txtFirstLine;
    public TextView txtSecondLine;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtFirstLine = (TextView) findViewById(R.id.firstLine);
        txtSecondLine = (TextView) findViewById(R.id.secondLine);
        txtFirstLine.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainActivity = new Intent(v.getContext(), MainActivityFilms.class);
                v.getContext().startActivity(mainActivity);
            }
        });
        txtSecondLine.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainActivity = new Intent(v.getContext(), MainActivityCharacters.class);
                v.getContext().startActivity(mainActivity);
            }
        });
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
}
