package com.example.ariellalevy.projetandroid_levy_ariella_grp31;

import com.example.ariellalevy.projetandroid_levy_ariella_grp31.model.HarryPotterCharacters;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HarryPotterRestAPI {
    @GET("{user}.json")
    Call<List<HarryPotterCharacters>> getCharactersList(@Path("user") String user);
    Call<HarryPotterCharacters> getCharacters(@Path("user") String user);
}