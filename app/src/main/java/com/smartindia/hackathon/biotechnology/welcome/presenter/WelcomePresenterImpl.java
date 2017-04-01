package com.smartindia.hackathon.biotechnology.welcome.presenter;

import com.smartindia.hackathon.biotechnology.welcome.WelcomeCallBack;
import com.smartindia.hackathon.biotechnology.welcome.model.WelcomeProvider;
import com.smartindia.hackathon.biotechnology.welcome.model.data.WelcomeData;
import com.smartindia.hackathon.biotechnology.welcome.view.WelcomeView;


public class WelcomePresenterImpl implements WelcomePresenter {


    private WelcomeView welcomeView;
    private WelcomeProvider welcomeProvider;

    public WelcomePresenterImpl(WelcomeView welcomeView, WelcomeProvider welcomeProvider) {
        this.welcomeView = welcomeView;
        this.welcomeProvider = welcomeProvider;
    }

    @Override
    public void requestWelcomeData() {

        welcomeProvider.requestWelcomeData(new WelcomeCallBack() {
            @Override
            public void onSuccess(WelcomeData welcomeData) {
                if(welcomeData.isSuccess())
                {
                    welcomeView.setData(welcomeData.getPageDetails());
                    welcomeView.showMessage("Success");
                    welcomeView.showProgressBar(false);
                }
                else
                {
                    welcomeView.showMessage("Try Again Sometime Later");
                    welcomeView.showProgressBar(false);
                }
            }

            @Override
            public void onFailure() {
                    welcomeView.showMessage("Failed");
            }
        });

    }
}
