package com.smartindia.hackathon.biotechnology.BiotechPark.Presenter;

import com.smartindia.hackathon.biotechnology.BiotechPark.Model.Data.BiotechParkData;
import com.smartindia.hackathon.biotechnology.BiotechPark.Model.BiotechParkProvider;
import com.smartindia.hackathon.biotechnology.BiotechPark.View.BiotechParkInterface;
import com.smartindia.hackathon.biotechnology.BiotechPark.View.OnBiotechParkReceived;

/**
 * Created by ayush on 28-03-2017.
 */

public class BiotechParkPresenterImpl implements BiotechParkPresenter{
    private BiotechParkInterface biotechParkInterface;
    private BiotechParkProvider biotechParkProvider;

    public BiotechParkPresenterImpl(BiotechParkInterface biotechParkInterface,BiotechParkProvider biotechParkProvider) {
        this.biotechParkInterface=biotechParkInterface;
        this.biotechParkProvider=biotechParkProvider;
    }

    @Override
    public void getBiotechPark(String type, String id) {

        biotechParkInterface.showProgressBar(true);
        biotechParkProvider.getBiotechPark(type,id, new OnBiotechParkReceived() {
            @Override
            public void onSuccess(BiotechParkData biotechParkData) {
                if(biotechParkData.isSuccess())
                {
                    biotechParkInterface.showProgressBar(false);
                    biotechParkInterface.OnDataReceived(biotechParkData);
                }
                else
                {
                    biotechParkInterface.showProgressBar(false);
                    biotechParkInterface.showMessage(biotechParkData.getMessage());
                }

            }

            @Override
            public void onFailure() {
                biotechParkInterface.showProgressBar(false);
                biotechParkInterface.showMessage("No Internet Connection");

            }
        });



    }
}
