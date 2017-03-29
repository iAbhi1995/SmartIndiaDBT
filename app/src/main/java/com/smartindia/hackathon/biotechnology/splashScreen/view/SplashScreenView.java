package com.smartindia.hackathon.biotechnology.splashScreen.view;

import com.smartindia.hackathon.biotechnology.splashScreen.model.data.SplashScreenData;

/**
 * Created by aman on 29/3/17.
 */

public interface SplashScreenView {


    void showMessage(String message);

    void showProgressBar(boolean show);

    void hideProgressBar();

    void version_check(SplashScreenData splashScreenData);










}
