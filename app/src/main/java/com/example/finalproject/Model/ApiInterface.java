package com.example.finalproject.Model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiInterface {
    @Headers({
            "X-RapidAPI-Host: omgvamp-hearthstone-v1.p.rapidapi.com",
            "X-RapidAPI-Key: 1e21567609mshacbe7fce23662c6p15b71djsn2464b632c33c"
    })
    @GET("cards")
    Call<HearthstoneCardPojo> getCards();
}
