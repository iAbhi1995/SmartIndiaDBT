package com.smartindia.hackathon.biotechnology.BiotechPark;

import com.smartindia.hackathon.biotechnology.BiotechPark.Model.Data.BiotechParkData;


public interface BiotechParkCallback {
    void onSuccess(BiotechParkData incubatorData);
    void onFailure();
}
