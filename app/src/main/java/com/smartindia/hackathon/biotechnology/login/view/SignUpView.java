package com.smartindia.hackathon.biotechnology.login.view;

import com.smartindia.hackathon.biotechnology.login.model.data.SignUpResultData;

public interface SignUpView  {
    void showProgressBar(boolean show);
    void showMessage(String message);
    void handlingBackButton();
    void onSignUpVerified(SignUpResultData signUpResultData);
}
