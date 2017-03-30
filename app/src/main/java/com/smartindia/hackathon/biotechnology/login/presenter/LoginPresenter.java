package com.smartindia.hackathon.biotechnology.login.presenter;

/**
 * Created by Abhishek on 28-03-2017.
 */

public interface LoginPresenter {

    void requestLogin( String name , String email,String user_type);
    void requestOtp(String otp);
}
