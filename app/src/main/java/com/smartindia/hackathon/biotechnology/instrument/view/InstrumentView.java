package com.smartindia.hackathon.biotechnology.instrument.view;

import com.smartindia.hackathon.biotechnology.instrument.model.data.InstrumentData;

/**
 * Created by aman on 1/4/17.
 */

public interface InstrumentView {

    void showProgressBar(boolean show);
    void showMessage(String error);
    void onCheck(InstrumentData instrumentData);
}
