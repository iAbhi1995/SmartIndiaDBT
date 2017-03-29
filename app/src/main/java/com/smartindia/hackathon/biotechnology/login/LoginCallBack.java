package com.smartindia.hackathon.biotechnology.login;

import com.smartindia.hackathon.biotechnology.login.model.data.LoginData;

public interface LoginCallBack
    {
    void onSuccess(LoginData loginData);
    void onFailure();
    }
