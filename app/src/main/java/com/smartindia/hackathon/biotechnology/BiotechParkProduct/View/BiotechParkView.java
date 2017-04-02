package com.smartindia.hackathon.biotechnology.BiotechParkProduct.View;

import com.smartindia.hackathon.biotechnology.BiotechParkProduct.model.data.BiotechParkData;

/**
 * Created by ayush on 28-03-2017.
 */

public interface BiotechParkView {

    void showMessage(String error);

    void showProgressBar(boolean show);

    void OnDataReceived(BiotechParkData biotechParkData);

}
