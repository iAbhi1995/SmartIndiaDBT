package com.smartindia.hackathon.biotechnology.splashScreen.presenter;

import com.smartindia.hackathon.biotechnology.splashScreen.SplashScreenCallBack;
import com.smartindia.hackathon.biotechnology.splashScreen.model.SplashScreenProvider;
import com.smartindia.hackathon.biotechnology.splashScreen.model.data.SplashScreenData;
import com.smartindia.hackathon.biotechnology.splashScreen.view.SplashScreenActivity;
import com.smartindia.hackathon.biotechnology.splashScreen.view.SplashScreenView;

/**
 * Created by aman on 29/3/17.
 */

public class SplashScreenPresenterImpl implements SplashScreenPresenter {

    private static final String LOG_TAG = "SplashScreenActivity";
    private SplashScreenProvider splashScreenProvider;
    private SplashScreenView splashScreenView;

    public SplashScreenPresenterImpl(SplashScreenActivity splashScreenView,
                                     SplashScreenProvider retrofitSplashScreenProvider) {
        this.splashScreenView = splashScreenView;
        this.splashScreenProvider = retrofitSplashScreenProvider;
    }


    @Override
    public void requestSplash()
    {

        splashScreenView.showProgressBar(true);
        splashScreenProvider.requestSplash(new SplashScreenCallBack() {
            @Override
            public void onSuccess(SplashScreenData splashScreenData) {


                if(splashScreenData.isSuccess())
                {

                    splashScreenView.success();
                    splashScreenView.hideProgressBar();
                }
                else
                {
                    splashScreenView.showMessage(splashScreenData.getMessage());
                    splashScreenView.hideProgressBar();

                }
            }

            @Override
            public void onFailure(String error) {

                //splashScreenView.hideProgressBar();
                splashScreenView.showMessage("No Internet Connection");


            }
        });


    }





























}
