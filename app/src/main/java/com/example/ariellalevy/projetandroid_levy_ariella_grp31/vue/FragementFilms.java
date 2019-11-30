package com.example.ariellalevy.projetandroid_levy_ariella_grp31.vue;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ariellalevy.projetandroid_levy_ariella_grp31.R;
import com.example.ariellalevy.projetandroid_levy_ariella_grp31.controler.ControllerCharacters;
import com.example.ariellalevy.projetandroid_levy_ariella_grp31.controler.ControllerFilms;
import com.example.ariellalevy.projetandroid_levy_ariella_grp31.model.HarryPotterFilms;

import java.util.List;

public class FragementFilms extends Fragment {
    private static final String TAG = "FragementFilms";
    //Déclaration des variables.
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private View view;
    private Context thiscontext;

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        view  = inflater.inflate(R.layout.fragement_characters_and_films, container, false);
        thiscontext = container.getContext();
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("user_prefs", Context.MODE_PRIVATE);
        ControllerFilms controller = new ControllerFilms(this,sharedPreferences);
        controller.start();
        Log.d(TAG, "onCreateView: started.");
        return view;
    }

    public void showList(List<HarryPotterFilms> filmsList) {
        recyclerView = view.findViewById(R.id.my_recycler_view);
        layoutManager = new LinearLayoutManager(thiscontext);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new AdapterFilms(filmsList);
        recyclerView.setAdapter(adapter);
    }
}
