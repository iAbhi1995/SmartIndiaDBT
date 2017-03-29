package com.smartindia.hackathon.biotechnology.login.view;

import com.smartindia.hackathon.biotechnology.login.model.data.LoginData;

/**
 * Created by Abhishek on 28-03-2017.
 */

public interface LoginView {

    void showProgressBar(boolean show);
    void showMessage(String message);
    void onLoginVerified(LoginData loginData);
}
