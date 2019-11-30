package com.example.ariellalevy.projetandroid_levy_ariella_grp31.controler;

import com.example.ariellalevy.projetandroid_levy_ariella_grp31.HarryPotterRestAPI;
import com.example.ariellalevy.projetandroid_levy_ariella_grp31.model.HarryPotterCharacters;
import com.example.ariellalevy.projetandroid_levy_ariella_grp31.vue.FragementCharacter;

import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ControllerCharacter implements Callback<HarryPotterCharacters> {
    static final String BASE_URL = "https://raw.githubusercontent.com/ariellalevy/ariellalevy.github.io/master/";
    private FragementCharacter view;
    private SharedPreferences sharedPreferences;
    private String donnee;

    public ControllerCharacter(FragementCharacter view, SharedPreferences sharedPreferences, String donnee) {
        this.view = view;
        this.sharedPreferences = sharedPreferences;
        this.donnee = donnee;
    }

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        HarryPotterRestAPI harryPotterRestAPI = retrofit.create(HarryPotterRestAPI.class);

        Call<HarryPotterCharacters> call = harryPotterRestAPI.getCharacters(donnee);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<HarryPotterCharacters> call, Response<HarryPotterCharacters> response) {
        if(response.isSuccessful()) {
            HarryPotterCharacters HarryPotter = response.body();
            storeData(HarryPotter);
            view.showCharacters(HarryPotter);
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<HarryPotterCharacters> call, Throwable t) {
        HarryPotterCharacters HarryPotter = getDataFromCache();
        view.showCharacters(HarryPotter);
        t.printStackTrace();
    }

    private void storeData(HarryPotterCharacters HarryPotterList) {
        Gson gson = new Gson();
        String HarryPotterListString = gson.toJson(HarryPotterList);
        sharedPreferences
                .edit()
                .putString("cle_string" + donnee, HarryPotterListString)
                .apply();
    }

    private HarryPotterCharacters getDataFromCache() {
        String HarryPotterListString = sharedPreferences.getString("cle_string"  + donnee, "");
        if(HarryPotterListString != null && !TextUtils.isEmpty(HarryPotterListString)){
            Type listType = new TypeToken<HarryPotterCharacters>(){}.getType();
            HarryPotterCharacters HarryPotter = new Gson().fromJson(HarryPotterListString, listType);
            return HarryPotter;
        }
        return new HarryPotterCharacters();
    }
}
