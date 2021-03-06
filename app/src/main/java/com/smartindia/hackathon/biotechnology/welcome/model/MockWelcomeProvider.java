package com.smartindia.hackathon.biotechnology.welcome.model;

import android.os.Handler;

import com.smartindia.hackathon.biotechnology.welcome.WelcomeCallBack;
import com.smartindia.hackathon.biotechnology.welcome.model.data.PageDetails;
import com.smartindia.hackathon.biotechnology.welcome.model.data.WelcomeData;

import java.util.ArrayList;
import java.util.List;


public class MockWelcomeProvider implements WelcomeProvider {
    
    @Override
    public void requestWelcomeData(final WelcomeCallBack welcomeCallBack) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                welcomeCallBack.onSuccess(getMockPageDetails());
            }
        },500);

    }

    private WelcomeData getMockPageDetails(){
        List<PageDetails> welcomeDetailsList = new ArrayList<>();

            PageDetails welcomeDetails = new PageDetails
                    ("1","INTERESTED IN BIOTECNOLOGY?","1");

            welcomeDetailsList.add(welcomeDetails);

        welcomeDetails = new PageDetails
                ("2","HAVING PROBLEM IN ACCESSING R&D FACILITIES?","0");
        welcomeDetailsList.add(welcomeDetails);

        welcomeDetails = new PageDetails
                ("3","COME ON \n WELCOME TO DBT PORTAL","0");
        welcomeDetailsList.add(welcomeDetails);
        WelcomeData welcomeData = new WelcomeData(true,"Success",welcomeDetailsList);

        return welcomeData;

    }

}
