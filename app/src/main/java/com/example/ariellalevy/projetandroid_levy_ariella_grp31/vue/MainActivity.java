package com.example.ariellalevy.projetandroid_levy_ariella_grp31.vue;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ariellalevy.projetandroid_levy_ariella_grp31.R;
import com.example.ariellalevy.projetandroid_levy_ariella_grp31.controler.ControllerFilm;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    //aide: https://github.com/mitchtabian/Fragments

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        loadFragment(new FragementMenuPrincipal());
    }

    public boolean loadFragment(Fragment fragment){
        if(fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container,fragment)
                    .commit();

            return true;
        }
        return false;
    }

    public void addAgrument(String key, CharSequence value, Fragment fragment){
        Bundle args = new Bundle();
        args.putCharSequence(key, value);
        fragment.setArguments(args);
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
        //Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();

        switch (id){
            case R.id.film:
                //((MainActivity)mViewPager.getContext()).setViewPager(3);
                loadFragment(new FragementFilms ());
                return true;
            case R.id.characters:
                //((MainActivity)mViewPager.getContext()).setViewPager(1);
                loadFragment(new FragementCharacters());
                return true;
            case R.id.home:
                mainActivity = new Intent(this, MainActivity.class);
                this.startActivity(mainActivity);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onNavigationItemSelected(MenuItem menuItem) {
        Fragment fragment = null;
        switch(menuItem.getItemId()){
            case R.id.home:
                fragment = new FragementMenuPrincipal();
                break;
            case R.id.film:
                fragment = new FragementFilms();
                break;
            case R.id.characters:
                fragment = new FragementCharacters();
                break;
        }
        return loadFragment(fragment);
    }
}
