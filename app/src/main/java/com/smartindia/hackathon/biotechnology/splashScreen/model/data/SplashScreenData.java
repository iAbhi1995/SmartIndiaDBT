package com.smartindia.hackathon.biotechnology.splashScreen.model.data;

/**
 * Created by aman on 29/3/17.
 */

public class SplashScreenData {

    private boolean success;
    private String message;

    public SplashScreenData( String message, boolean success) {
        this.success = success;
        this.message = message;

    }



    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }












}
