package com.smartindia.hackathon.biotechnology.login.presenter;

import android.util.Log;

import com.smartindia.hackathon.biotechnology.login.LoginCallBack;
import com.smartindia.hackathon.biotechnology.login.ProfLoginCallBack;
import com.smartindia.hackathon.biotechnology.login.SignUpCallBack;
import com.smartindia.hackathon.biotechnology.login.model.LoginProvider;
import com.smartindia.hackathon.biotechnology.login.model.data.LoginData;
import com.smartindia.hackathon.biotechnology.login.model.data.ProfLogInData;
import com.smartindia.hackathon.biotechnology.login.model.data.SignUpResultData;
import com.smartindia.hackathon.biotechnology.login.view.LoginView;
import com.smartindia.hackathon.biotechnology.login.view.SignUpView;

public class LoginPresenterImpl implements LoginPresenter {

    private LoginView loginView;
    private LoginProvider loginProvider;
//    private OTPProvider otpProvider;
//    private OTPView otpView;
    private SignUpView signUpView;

    public LoginPresenterImpl(LoginProvider loginProvider, LoginView loginView) {
        this.loginProvider = loginProvider;
        this.loginView = loginView;
    }

    public LoginPresenterImpl(LoginProvider loginProvider, SignUpView signUpView) {
        this.loginProvider = loginProvider;
        this.signUpView = signUpView;
    }

    @Override
    public void requestLogin(String name, String email, String user_type) {
        loginView.showProgressBar(true);
        loginProvider.requestLogin(name, email, user_type, new LoginCallBack() {
            @Override
            public void onSuccess(LoginData loginData) {
                if (loginData.isSuccess()) {
                    loginView.onLoginVerified(loginData);
                    loginView.showProgressBar(false);
                    Log.d("Presenter", "suc");
                } else {
                    loginView.showProgressBar(false);
                    loginView.showMessage(loginData.getMessage());
                    loginView.signOutonError();
                }
            }

            @Override
            public void onFailure() {
                loginView.showProgressBar(false);
                loginView.showMessage("Something went wrong!Please Login Again");
                loginView.signOutonError();
                Log.d("Presenter", "fail");

            }
        });
    }

    @Override
    public void requestSignUp(String userName, String email) {
        signUpView.showProgressBar(true);
        loginProvider.requestSignUp(userName, email, new SignUpCallBack() {
            @Override
            public void onSuccess(SignUpResultData signUpResultData) {
                if(signUpResultData.isSuccess()){
                    Log.d("abhi","OnSucess");
                    signUpView.showProgressBar(false);
                    signUpView.onSignUpVerified(signUpResultData);
                }
                else
                {
                    signUpView.showProgressBar(false);
                    signUpView.showMessage(signUpResultData.getMessage());
                }
            }

            @Override
            public void onFailure() {
                signUpView.showProgressBar(false);
                signUpView.showMessage("Something Went wrong Try Again!");
            }
        });
    }

    @Override
    public void requestProfLogin(String email, String password) {
        loginView.showProgressBar(true);
        loginProvider.requestProfLogin(email, password, new ProfLoginCallBack() {
            @Override
            public void onSuccess(ProfLogInData profLogInData) {
                if(profLogInData.isSuccess())
                {
                 loginView.showProgressBar(false);
                    loginView.onProfessorLoginVerified(profLogInData);
                }
                else
                {
                    loginView.showProgressBar(false);
                    loginView.showMessage(profLogInData.getMessage());
                }
            }

            @Override
            public void onFailure() {
                loginView.showProgressBar(false);
                loginView.showMessage("Connection Error");
            }
        });
    }
}
