package com.example.ariellalevy.projetandroid_levy_ariella_grp31;

import com.example.ariellalevy.projetandroid_levy_ariella_grp31.model.HarryPotterCharacters;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface HarryPotterRestAPI {
    @GET("characters.json")
    Call<List<HarryPotterCharacters>> getCharactersList();
}