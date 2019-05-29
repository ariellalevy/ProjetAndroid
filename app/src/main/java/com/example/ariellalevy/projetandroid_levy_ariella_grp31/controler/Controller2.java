package com.example.ariellalevy.projetandroid_levy_ariella_grp31.controler;

import com.example.ariellalevy.projetandroid_levy_ariella_grp31.HarryPotterRestAPI;
import com.example.ariellalevy.projetandroid_levy_ariella_grp31.model.HarryPotterCharacters;
import com.example.ariellalevy.projetandroid_levy_ariella_grp31.vue.Main2Activity;

import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller2 implements Callback<HarryPotterCharacters> {
    static final String BASE_URL = "https://raw.githubusercontent.com/ariellalevy/ariellalevy.github.io/master/";
    private Main2Activity view;
    private SharedPreferences sharedPreferences;
    private String donnee;

    public Controller2(Main2Activity view, SharedPreferences sharedPreferences, String donnee) {
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
            //storeData(HarryPotterList);
            view.showCharacters(HarryPotter);
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<HarryPotterCharacters> call, Throwable t) {
        //List<HarryPotterCharacters> HarryPotterList = getDataFromCache();
        //view.showCharacters(HarryPotterList);
        t.printStackTrace();
    }

    /*private void storeData(List<HarryPotterCharacters> HarryPotterList) {
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
    }*/
}
