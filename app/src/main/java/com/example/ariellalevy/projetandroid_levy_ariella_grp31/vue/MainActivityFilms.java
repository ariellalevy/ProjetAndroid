package com.example.ariellalevy.projetandroid_levy_ariella_grp31.vue;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.ariellalevy.projetandroid_levy_ariella_grp31.R;
import com.example.ariellalevy.projetandroid_levy_ariella_grp31.controler.ControllerFilms;
import com.example.ariellalevy.projetandroid_levy_ariella_grp31.model.HarryPotterFilms;

import java.util.List;

public class MainActivityFilms  extends AppCompatActivity {
    //Déclaration des variables.
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_characters_and_films);
        SharedPreferences sharedPreferences = this.getSharedPreferences("user_prefs", Context.MODE_PRIVATE);
        ControllerFilms controller = new ControllerFilms(this,sharedPreferences);
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

    public void showList(List<HarryPotterFilms> filmsList) {
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new AdapterFilms(filmsList);
        recyclerView.setAdapter(adapter);
    }
}
