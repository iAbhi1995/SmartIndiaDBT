package com.smartindia.hackathon.biotechnology.login.presenter;

import com.smartindia.hackathon.biotechnology.login.LoginCallBack;
import com.smartindia.hackathon.biotechnology.login.OTPCallBack;
import com.smartindia.hackathon.biotechnology.login.model.LoginProvider;
import com.smartindia.hackathon.biotechnology.login.model.OTPProvider;
import com.smartindia.hackathon.biotechnology.login.model.data.LoginData;
import com.smartindia.hackathon.biotechnology.login.model.data.OTPdata;
import com.smartindia.hackathon.biotechnology.login.view.LoginView;
import com.smartindia.hackathon.biotechnology.login.view.OTPView;

public class LoginPresenterImpl implements LoginPresenter {

    private LoginView loginView;
    private LoginProvider loginProvider;
    private OTPProvider otpProvider;
    private OTPView otpView;

    public LoginPresenterImpl(LoginProvider loginProvider, LoginView loginView) {
        this.loginProvider = loginProvider;
        this.loginView = loginView;
    }

    public LoginPresenterImpl(OTPProvider otpProvider, OTPView otpView) {
        this.otpProvider = otpProvider;
        this.otpView = otpView;
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

                } else {
                    loginView.showProgressBar(false);
                    loginView.showMessage(loginData.getMessage());
                }
            }

            @Override
            public void onFailure() {
                loginView.showProgressBar(false);
                loginView.showMessage("Something went wrong");
            }
        });
    }

    @Override
    public void requestOtp(String otp) {
        otpView.showProgressBar(true);
        otpProvider.requestOtp(otp, new OTPCallBack() {
            @Override
            public void onSuccess(OTPdata otPdata) {
                if (otPdata.isSuccess()) {
                    otpView.onOTPVerified(otPdata);
                    otpView.showProgressBar(false);

                } else {
                    otpView.showProgressBar(false);
                    otpView.showMessage(otPdata.getMessage());

                }
            }

            @Override
            public void onFailure() {
                loginView.showProgressBar(false);
                loginView.showMessage("Something went wrong");
            }
        });
    }
}
