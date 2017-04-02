package com.smartindia.hackathon.biotechnology.BiotechParkProduct.View;

import com.smartindia.hackathon.biotechnology.BiotechParkProduct.model.data.BiotechParkData;

/**
 * Created by ayush on 28-03-2017.
 */

public interface OnBiotechParkReceived {

    void onSuccess(BiotechParkData biotechParkData);
    void onFailure();
}
