package com.example.ariellalevy.projetandroid_levy_ariella_grp31.vue;

import com.example.ariellalevy.projetandroid_levy_ariella_grp31.R;
import com.example.ariellalevy.projetandroid_levy_ariella_grp31.controler.ControllerCharacter;
import com.example.ariellalevy.projetandroid_levy_ariella_grp31.model.HarryPotterCharacters;

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

import com.squareup.picasso.Picasso;

public class MainActivityCharacter extends AppCompatActivity {
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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_character);
        Intent activ = getIntent();
        String donnee = activ.getStringExtra("donnee");
        SharedPreferences sharedPreferences = this.getSharedPreferences("user_prefs", Context.MODE_PRIVATE);
        ControllerCharacter controller = new ControllerCharacter(this,sharedPreferences,donnee);
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

    public void showCharacters(HarryPotterCharacters characters) {
        imageView = (ImageView) findViewById(R.id.icon);
        txtFirstLine = (TextView) findViewById(R.id.firstLine);
        txtSecondLine = (TextView) findViewById(R.id.secondLine);
        txtTroisiemeLine = (TextView) findViewById(R.id.troisiemeLine);
        txtQuatriemeLine = (TextView) findViewById(R.id.quatriemeLine);
        txtCinquiemeLine = (TextView) findViewById(R.id.cinquiemeLine);
        txtSixemeLine = (TextView) findViewById(R.id.sixemeLine);
        txtSeptiemeLine = (TextView) findViewById(R.id.septiemeLine);
        txtHuitiemeLine = (TextView) findViewById(R.id.huitiemeLine);
        txtNeuviemeLine = (TextView) findViewById(R.id.neuviemeLine);
        txtDixemeLine = (TextView) findViewById(R.id.dixemeLine);
        Picasso.with(this).load(characters.getImage()).into(imageView);
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
    }
}