package com.example.ariellalevy.projetandroid_levy_ariella_grp31;

import com.example.ariellalevy.projetandroid_levy_ariella_grp31.model.HarryPotterCharacters;
import com.example.ariellalevy.projetandroid_levy_ariella_grp31.model.HarryPotterFilms;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HarryPotterRestAPI {
    @GET("characters.json")
    Call<List<HarryPotterCharacters>> getCharactersList();
    @GET("{character}.json")
    Call<HarryPotterCharacters> getCharacters(@Path("character") String user);
    @GET("films.json")
    Call<List<HarryPotterFilms>> getFilmsList();
    @GET("{film}.json")
    Call<HarryPotterFilms> getFilm(@Path("film") String user);

}