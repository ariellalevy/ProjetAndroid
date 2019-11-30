package com.example.ariellalevy.projetandroid_levy_ariella_grp31.vue;

import android.content.Intent;
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
import android.widget.TextView;
import android.widget.Toast;

import com.example.ariellalevy.projetandroid_levy_ariella_grp31.R;

public class FragementMenuPrincipal extends Fragment {
    private static final String TAG = "FragementMenuPrincipal";
    public ImageView imageView;
    public TextView txtFirstLine;
    public TextView txtSecondLine;

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragement_menu_principal, container, false);
        txtFirstLine = view.findViewById(R.id.firstLine);
        txtSecondLine = view.findViewById(R.id.secondLine);
        Log.d(TAG, "onCreateView: started.");

        txtFirstLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).loadFragment(new FragementFilms());
            }
        });

        txtSecondLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).loadFragment(new FragementCharacters());
            }
        });

        return view;
    }
}
