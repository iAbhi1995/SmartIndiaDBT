package com.smartindia.hackathon.biotechnology.welcome.api;

import com.smartindia.hackathon.biotechnology.helper.Urls;
import com.smartindia.hackathon.biotechnology.welcome.model.data.WelcomeData;

import retrofit2.Call;
import retrofit2.http.GET;


public interface WelcomeApi {

    @GET(Urls.WELCOME)
    Call<WelcomeData> requestWelcomeData();
}
