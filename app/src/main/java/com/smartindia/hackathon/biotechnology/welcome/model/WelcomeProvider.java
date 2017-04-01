package com.smartindia.hackathon.biotechnology.welcome.model;


import com.smartindia.hackathon.biotechnology.welcome.WelcomeCallBack;

public interface WelcomeProvider {

    void requestWelcomeData(WelcomeCallBack welcomeCallBack);
}
