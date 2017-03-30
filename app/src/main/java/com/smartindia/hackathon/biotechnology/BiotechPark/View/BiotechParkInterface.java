package com.smartindia.hackathon.biotechnology.BiotechPark.View;

import com.smartindia.hackathon.biotechnology.BiotechPark.Model.Data.BiotechParkData;

/**
 * Created by ayush on 28-03-2017.
 */

public interface BiotechParkInterface {

    void showMessage(String error);

    void showProgressBar(boolean show);

    void OnDataReceived(BiotechParkData incubatorData);

}
