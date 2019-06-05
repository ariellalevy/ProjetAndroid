package com.example.ariellalevy.projetandroid_levy_ariella_grp31.controler;

import android.content.SharedPreferences;
import android.text.TextUtils;

import com.example.ariellalevy.projetandroid_levy_ariella_grp31.HarryPotterRestAPI;
import com.example.ariellalevy.projetandroid_levy_ariella_grp31.model.HarryPotterCharacters;
import com.example.ariellalevy.projetandroid_levy_ariella_grp31.vue.MainActivityCharacters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ControllerCharacters implements Callback<List<HarryPotterCharacters>> {

    static final String BASE_URL = "https://raw.githubusercontent.com/ariellalevy/ariellalevy.github.io/master/";
    private MainActivityCharacters view;
    private SharedPreferences sharedPreferences;

    public ControllerCharacters(MainActivityCharacters view, SharedPreferences sharedPreferences) {
        this.view = view;
        this.sharedPreferences = sharedPreferences;
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
            storeData(HarryPotterList);
            view.showList(HarryPotterList);
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<HarryPotterCharacters>> call, Throwable t) {
        List<HarryPotterCharacters> HarryPotterList = getDataFromCache();
        view.showList(HarryPotterList);
        t.printStackTrace();
    }

    private void storeData(List<HarryPotterCharacters> HarryPotterList) {
        Gson gson = new Gson();
        String HarryPotterListString = gson.toJson(HarryPotterList);
        sharedPreferences
                .edit()
                .putString("cle_string", HarryPotterListString)
                .apply();
    }

    private List<HarryPotterCharacters> getDataFromCache() {
        String HarryPotterListString = sharedPreferences.getString("cle_string", "");
        if(HarryPotterListString != null && !TextUtils.isEmpty(HarryPotterListString)){
            Type listType = new TypeToken<List<HarryPotterCharacters>>(){}.getType();
            List<HarryPotterCharacters> HarryPotterList = new Gson().fromJson(HarryPotterListString, listType);
            return HarryPotterList;
        }
        return new ArrayList<>();
    }
}