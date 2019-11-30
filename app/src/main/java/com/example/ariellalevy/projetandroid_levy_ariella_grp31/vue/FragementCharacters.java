package com.example.ariellalevy.projetandroid_levy_ariella_grp31.vue;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ariellalevy.projetandroid_levy_ariella_grp31.R;
import com.example.ariellalevy.projetandroid_levy_ariella_grp31.controler.ControllerCharacters;
import com.example.ariellalevy.projetandroid_levy_ariella_grp31.model.HarryPotterCharacters;

import java.util.List;

public class FragementCharacters extends Fragment {
    private static final String TAG = "FragementCharacters";
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
        ControllerCharacters controller = new ControllerCharacters(this,sharedPreferences);
        controller.start();
        Log.d(TAG, "onCreateView: started.");
        return view;
    }

    public void showList(List<HarryPotterCharacters> charactersList) {
        recyclerView = view.findViewById(R.id.my_recycler_view);
        layoutManager = new LinearLayoutManager(thiscontext);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new AdapterCharacters(charactersList);
        recyclerView.setAdapter(adapter);
    }
}
