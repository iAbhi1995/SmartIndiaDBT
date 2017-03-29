package com.smartindia.hackathon.biotechnology.login.model;

import android.os.Handler;

import com.smartindia.hackathon.biotechnology.login.LoginCallBack;
import com.smartindia.hackathon.biotechnology.login.model.data.LoginData;

/**
 * Created by Abhishek on 28-03-2017.
 */

public class MockLoginProvider implements LoginProvider{

    @Override
    public void requestLogin(String name, String email,String user_type,final LoginCallBack loginCallBack) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loginCallBack.onSuccess(getMockLoginData());
            }
        },500);
    }
/*
    @Override
    public void requestOtp(String otp) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                otpCallBack.onSuccess(getMockLoginData());
            }
        },500);
    }

    private OTPdata getMockOTPData() {
        OTPdata otpData=new OTPdata("Success","Logged in");
        return otpData;
    }*/

    public LoginData getMockLoginData()
    {
        LoginData loginData = new LoginData("A01A2","Success",true);
        return  loginData;
    }

}
