package com.example.ariellalevy.projetandroid_levy_ariella_grp31.controler;

import com.example.ariellalevy.projetandroid_levy_ariella_grp31.HarryPotterRestAPI;
import com.example.ariellalevy.projetandroid_levy_ariella_grp31.model.HarryPotterCharacters;
import com.example.ariellalevy.projetandroid_levy_ariella_grp31.vue.MainActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller implements Callback<List<HarryPotterCharacters>> {

    static final String BASE_URL = "https://raw.githubusercontent.com/ariellalevy/ariellalevy.github.io/master/";
    private MainActivity view;

    public Controller(MainActivity view) {
        this.view = view;
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

        Call<List<HarryPotterCharacters>> call =  harryPotterRestAPI.getCharactersList();
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<List<HarryPotterCharacters>> call, Response<List<HarryPotterCharacters>> response) {
        if(response.isSuccessful()) {
            List<HarryPotterCharacters> HarryPotterList = response.body();
            view.showList(HarryPotterList);
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<HarryPotterCharacters>> call, Throwable t) {
        t.printStackTrace();
    }
}