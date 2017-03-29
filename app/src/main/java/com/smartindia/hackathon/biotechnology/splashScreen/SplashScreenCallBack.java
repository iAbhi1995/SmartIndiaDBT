package com.smartindia.hackathon.biotechnology.splashScreen;

import com.smartindia.hackathon.biotechnology.splashScreen.model.data.SplashScreenData;

/**
 * Created by aman on 29/3/17.
 */

public interface SplashScreenCallBack {


    void onSuccess(SplashScreenData splashScreenData);
    void onFailure(String error);



}
