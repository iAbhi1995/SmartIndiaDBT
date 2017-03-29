package com.smartindia.hackathon.biotechnology.splashScreen.api;

import com.smartindia.hackathon.biotechnology.helper.Urls;
import com.smartindia.hackathon.biotechnology.splashScreen.model.data.SplashScreenData;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by aman on 29/3/17.
 */

public interface SplashScreenRequestApi {



    @GET(Urls.REQUEST_SPLASH_SCREEN)
    Call<SplashScreenData> requestSplash();








}
