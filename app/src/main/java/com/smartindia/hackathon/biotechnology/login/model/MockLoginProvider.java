package com.smartindia.hackathon.biotechnology.login.model;

import android.os.Handler;

import com.smartindia.hackathon.biotechnology.login.LoginCallBack;
import com.smartindia.hackathon.biotechnology.login.ProfLoginCallBack;
import com.smartindia.hackathon.biotechnology.login.SignUpCallBack;
import com.smartindia.hackathon.biotechnology.login.model.data.LoginData;
import com.smartindia.hackathon.biotechnology.login.model.data.ProfLogInData;
import com.smartindia.hackathon.biotechnology.login.model.data.SignUpResultData;

public class MockLoginProvider implements LoginProvider {

    @Override
    public void requestLogin(String name, String email, String user_type, final LoginCallBack loginCallBack) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loginCallBack.onSuccess(getMockLoginData());
            }
        }, 500);
    }

    @Override
    public void requestSignUp(String name, String email, final SignUpCallBack signUpCallBack) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                signUpCallBack.onSuccess(getMockSignUpData());
            }
        }, 500);
    }

    @Override
    public void requestProfLogin(String email, String password, final ProfLoginCallBack profLoginCallBack) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                profLoginCallBack.onSuccess(getMockProfLoginData());
            }
        }, 500);
    }

    @Override
    public void handleBackButton() {

    }

    public ProfLogInData getMockProfLoginData()
    {
        ProfLogInData profLogInData=new ProfLogInData(true,"success","A0101");
        return profLogInData;
    }
    public SignUpResultData getMockSignUpData(){
        SignUpResultData signUpResultData = new SignUpResultData("Succcess", true);
        return signUpResultData;
    }
    public LoginData getMockLoginData() {
        LoginData loginData = new LoginData("A01A2", "Success", true);
        return loginData;
    }
}
