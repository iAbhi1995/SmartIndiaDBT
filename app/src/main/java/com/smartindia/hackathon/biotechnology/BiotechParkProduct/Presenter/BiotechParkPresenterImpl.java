package com.smartindia.hackathon.biotechnology.BiotechParkProduct.Presenter;

import com.smartindia.hackathon.biotechnology.BiotechParkProduct.model.data.BiotechParkData;
import com.smartindia.hackathon.biotechnology.BiotechParkProduct.model.BiotechParkProvider;
import com.smartindia.hackathon.biotechnology.BiotechParkProduct.View.BiotechParkView;
import com.smartindia.hackathon.biotechnology.BiotechParkProduct.View.OnBiotechParkReceived;

/**
 * Created by ayush on 28-03-2017.
 */

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
        biotechParkProvider.getBiotechPark(type,id, new OnBiotechParkReceived() {
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
