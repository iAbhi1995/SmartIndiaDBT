package com.smartindia.hackathon.biotechnology.Incubator.View;

import com.smartindia.hackathon.biotechnology.Incubator.Model.Data.IncubatorData;

/**
 * Created by ayush on 28-03-2017.
 */

public interface OnIncubatorsReceived {
    void onSuccess(IncubatorData incubatorData);
    void onFailure();
}
