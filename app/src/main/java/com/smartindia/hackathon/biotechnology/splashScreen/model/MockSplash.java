package com.smartindia.hackathon.biotechnology.splashScreen.model;

import android.os.Handler;
import android.util.Log;

import com.smartindia.hackathon.biotechnology.splashScreen.SplashScreenCallBack;
import com.smartindia.hackathon.biotechnology.splashScreen.model.data.SplashScreenData;

/**
 * Created by aman on 29/3/17.
 */

public class MockSplash implements SplashScreenProvider {

    @Override
    public void requestSplash( final SplashScreenCallBack splashScreenCallBack) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                splashScreenCallBack.onSuccess(getMockData());
                Log.d("Mock", "1");


            }
        }, 500);
    }

        SplashScreenData getMockData(){

            SplashScreenData splashScreenData = new SplashScreenData("Received",true);
            return splashScreenData;

        }
    }

