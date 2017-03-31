package com.smartindia.hackathon.biotechnology.welcome;


import com.smartindia.hackathon.biotechnology.welcome.model.data.WelcomeData;

public interface WelcomeCallBack {

    void onSuccess(WelcomeData welcomeData);
    void onFailure();
}
