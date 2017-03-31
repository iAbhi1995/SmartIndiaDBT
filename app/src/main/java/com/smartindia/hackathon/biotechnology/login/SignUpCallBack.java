package com.smartindia.hackathon.biotechnology.login;

import com.smartindia.hackathon.biotechnology.login.model.data.SignUpResultData;

public interface SignUpCallBack {
    void onSuccess(SignUpResultData signUpResultData);
    void onFailure();
}
