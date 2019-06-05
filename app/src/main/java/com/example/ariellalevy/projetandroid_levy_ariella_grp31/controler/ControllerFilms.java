package com.example.ariellalevy.projetandroid_levy_ariella_grp31.controler;

import android.content.SharedPreferences;
import android.text.TextUtils;

import com.example.ariellalevy.projetandroid_levy_ariella_grp31.HarryPotterRestAPI;
import com.example.ariellalevy.projetandroid_levy_ariella_grp31.model.HarryPotterCharacters;
import com.example.ariellalevy.projetandroid_levy_ariella_grp31.model.HarryPotterFilms;
import com.example.ariellalevy.projetandroid_levy_ariella_grp31.vue.MainActivityCharacters;
import com.example.ariellalevy.projetandroid_levy_ariella_grp31.vue.MainActivityFilms;
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

public class ControllerFilms implements Callback<List<HarryPotterFilms>> {
    static final String BASE_URL = "https://raw.githubusercontent.com/ariellalevy/ariellalevy.github.io/master/";
    private MainActivityFilms view;
    private SharedPreferences sharedPreferences;

    public ControllerFilms(MainActivityFilms view, SharedPreferences sharedPreferences) {
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
        Call<List<HarryPotterFilms>> call =  harryPotterRestAPI.getFilmsList();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<HarryPotterFilms>> call, Response<List<HarryPotterFilms>> response) {
        if(response.isSuccessful()) {
            List<HarryPotterFilms> HarryPotterList = response.body();
            storeData(HarryPotterList);
            view.showList(HarryPotterList);
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<HarryPotterFilms>> call, Throwable t) {
        List<HarryPotterFilms> HarryPotterList = getDataFromCache();
        view.showList(HarryPotterList);
        t.printStackTrace();
    }

    private void storeData(List<HarryPotterFilms> HarryPotterList) {
        Gson gson = new Gson();
        String HarryPotterListString = gson.toJson(HarryPotterList);
        sharedPreferences
                .edit()
                .putString("cle_string2", HarryPotterListString)
                .apply();
    }

    private List<HarryPotterFilms> getDataFromCache() {
        String HarryPotterListString = sharedPreferences.getString("cle_string2", "");
        if(HarryPotterListString != null && !TextUtils.isEmpty(HarryPotterListString)){
            Type listType = new TypeToken<List<HarryPotterFilms>>(){}.getType();
            List<HarryPotterFilms> HarryPotterList = new Gson().fromJson(HarryPotterListString, listType);
            return HarryPotterList;
        }
        return new ArrayList<>();
    }
}
