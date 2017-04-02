package com.smartindia.hackathon.biotechnology.BiotechPark.Presenter;

import com.smartindia.hackathon.biotechnology.BiotechPark.BiotechParkCallback;
import com.smartindia.hackathon.biotechnology.BiotechPark.Model.BiotechParkProvider;
import com.smartindia.hackathon.biotechnology.BiotechPark.Model.Data.BiotechParkData;
import com.smartindia.hackathon.biotechnology.BiotechPark.View.BiotechParkView;

public class BiotechParkPresenterImpl implements BiotechParkPresenter{
    private BiotechParkView biotechParkView;
    private BiotechParkProvider biotechParkProvider;

    public BiotechParkPresenterImpl(BiotechParkView biotechParkView, BiotechParkProvider biotechParkProvider) {
        this.biotechParkView = biotechParkView;
        this.biotechParkProvider=biotechParkProvider;
    }

    @Override
    public void getBiotechPark(String type, String id) {

        biotechParkView.showProgressBar(true);
        biotechParkProvider.getBiotechPark(type, id, new BiotechParkCallback() {
            @Override
            public void onSuccess(BiotechParkData biotechParkData) {
                if(biotechParkData.isSuccess())
                {
                    biotechParkView.showProgressBar(false);
                    biotechParkView.OnDataReceived(biotechParkData);
                }
                else
                {
                    biotechParkView.showProgressBar(false);
                    biotechParkView.showMessage(biotechParkData.getMessage());
                }

            }

            @Override
            public void onFailure() {
                biotechParkView.showProgressBar(false);
                biotechParkView.showMessage("No Internet Connection");

            }
        });



    }
}
