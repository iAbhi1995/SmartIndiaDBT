package com.smartindia.hackathon.biotechnology.login.model;

import com.smartindia.hackathon.biotechnology.login.LoginCallBack;

/**
 * Created by Abhishek on 28-03-2017.
 */

public interface LoginProvider {

    void requestLogin(String name, String email,String user_type, LoginCallBack loginCallBack);
}
