package com.example.ariellalevy.projetandroid_levy_ariella_grp31.vue;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ariellalevy.projetandroid_levy_ariella_grp31.R;
import com.example.ariellalevy.projetandroid_levy_ariella_grp31.controler.Controller;
import com.example.ariellalevy.projetandroid_levy_ariella_grp31.model.HarryPotterCharacters;

import java.util.List;

public class MainActivity extends Activity {

    //Déclaration des variables.
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences = this.getSharedPreferences("user_prefs", Context.MODE_PRIVATE);
        Controller controller = new Controller(this,sharedPreferences);
        controller.start();
    }

    public void showList(List<HarryPotterCharacters> charactersList) {
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(charactersList);
        recyclerView.setAdapter(adapter);
    }

    protected void onListItemClick(ListView l, View v, int position, long id){
        Toast.makeText(getApplicationContext(), "teste", Toast.LENGTH_SHORT).show();
        Intent main2Activity = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(main2Activity);
    }
}