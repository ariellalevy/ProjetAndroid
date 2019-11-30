package com.example.ariellalevy.projetandroid_levy_ariella_grp31.vue;

import android.content.Context;
import android.content.Intent;
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
import com.example.ariellalevy.projetandroid_levy_ariella_grp31.controler.ControllerCharacter;
import com.example.ariellalevy.projetandroid_levy_ariella_grp31.controler.ControllerCharacters;
import com.example.ariellalevy.projetandroid_levy_ariella_grp31.model.HarryPotterCharacters;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FragementCharacter extends Fragment {
    private static final String TAG = "FragementCharacter";
    //Déclaration des variables.
    public ImageView imageView;
    public TextView txtFirstLine;
    public TextView txtSecondLine;
    public TextView txtTroisiemeLine;
    public TextView txtQuatriemeLine;
    public TextView txtCinquiemeLine;
    public TextView txtSixemeLine;
    public TextView txtSeptiemeLine;
    public TextView txtHuitiemeLine;
    public TextView txtNeuviemeLine;
    public TextView txtDixemeLine;
    public TextView txtOnziemeLine;
    private View view;
    private Context thiscontext;
    private SharedPreferences sharedPreferences;
    String donnee;


    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        view  = inflater.inflate(R.layout.fragement_character, container, false);
        thiscontext = container.getContext();
        Bundle bundle=this.getArguments();
        if(bundle != null){
            donnee=bundle.getString("donnee");
        }
        Toast.makeText(getActivity(), donnee, Toast.LENGTH_SHORT).show();
        sharedPreferences = this.getActivity().getSharedPreferences("user_prefs", Context.MODE_PRIVATE);
        ControllerCharacter controller = new ControllerCharacter(this,sharedPreferences,donnee);
        controller.start();
        Log.d(TAG, "onCreateView: started.");
        return view;
    }

    public void showCharacters(HarryPotterCharacters characters) {
        imageView = view.findViewById(R.id.icon);
        txtFirstLine = view.findViewById(R.id.firstLine);
        txtSecondLine = view.findViewById(R.id.secondLine);
        txtTroisiemeLine = view.findViewById(R.id.troisiemeLine);
        txtQuatriemeLine = view.findViewById(R.id.quatriemeLine);
        txtCinquiemeLine = view.findViewById(R.id.cinquiemeLine);
        txtSixemeLine = view.findViewById(R.id.sixemeLine);
        txtSeptiemeLine = view.findViewById(R.id.septiemeLine);
        txtHuitiemeLine = view.findViewById(R.id.huitiemeLine);
        txtNeuviemeLine = view.findViewById(R.id.neuviemeLine);
        txtDixemeLine = view.findViewById(R.id.dixemeLine);
        txtOnziemeLine = view.findViewById(R.id.onziemeLine);
        Picasso.with(thiscontext).load(characters.getImage()).into(imageView);
        txtFirstLine.setText(characters.getName());
        txtSecondLine.setText("Actor: " + characters.getActor());
        txtTroisiemeLine.setText("Species: " + characters.getSpecies());
        txtQuatriemeLine.setText("Gender: " + characters.getGender());
        txtCinquiemeLine.setText("Date of birthday: " + characters.getDateOfBirth());
        txtSixemeLine.setText("Ancestry: " + characters.getAncestry());
        txtSeptiemeLine.setText("House: " + characters.getHouse());
        txtHuitiemeLine.setText("Patronus: " + characters.getPatronus());
        txtNeuviemeLine.setText("Hair color: " + characters.getHairColour());
        txtDixemeLine.setText("Eye Color: " + characters.getEyeColour());
        txtOnziemeLine.setText("Résumé: " + characters.getResumer());
    }
}
