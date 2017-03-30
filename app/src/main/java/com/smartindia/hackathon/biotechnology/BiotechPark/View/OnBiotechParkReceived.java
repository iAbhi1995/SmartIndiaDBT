package com.smartindia.hackathon.biotechnology.BiotechPark.View;

import com.smartindia.hackathon.biotechnology.BiotechPark.Model.Data.BiotechParkData;

/**
 * Created by ayush on 28-03-2017.
 */

public interface OnBiotechParkReceived {
    void onSuccess(BiotechParkData incubatorData);
    void onFailure();
}
