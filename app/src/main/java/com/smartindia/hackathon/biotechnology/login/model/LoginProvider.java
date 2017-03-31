package com.smartindia.hackathon.biotechnology.login.model;

import com.smartindia.hackathon.biotechnology.login.LoginCallBack;
import com.smartindia.hackathon.biotechnology.login.ProfLoginCallBack;
import com.smartindia.hackathon.biotechnology.login.SignUpCallBack;

/**
 * Created by Abhishek on 28-03-2017.
 */

public interface LoginProvider {

    void requestLogin(String name, String email, String user_type, LoginCallBack loginCallBack);
    void requestSignUp(String name, String email, SignUpCallBack signUpCallBack);
    void requestProfLogin(String email, String password, ProfLoginCallBack profLoginCallBack);

    void handleBackButton();
}
