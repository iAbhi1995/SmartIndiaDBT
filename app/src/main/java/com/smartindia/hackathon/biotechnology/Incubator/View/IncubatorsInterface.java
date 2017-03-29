package com.smartindia.hackathon.biotechnology.Incubator.View;

import com.smartindia.hackathon.biotechnology.Incubator.Model.Data.IncubatorData;

/**
 * Created by ayush on 28-03-2017.
 */

public interface IncubatorsInterface {

    void showMessage(String error);

    void showProgressBar(boolean show);

    void OnDataReceived(IncubatorData incubatorData);

}
