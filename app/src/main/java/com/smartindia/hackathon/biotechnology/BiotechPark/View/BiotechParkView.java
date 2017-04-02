package com.smartindia.hackathon.biotechnology.BiotechPark.View;

import com.smartindia.hackathon.biotechnology.BiotechPark.Model.Data.BiotechParkData;

public interface BiotechParkView {

    void showMessage(String error);

    void showProgressBar(boolean show);

    void OnDataReceived(BiotechParkData incubatorData);

}
