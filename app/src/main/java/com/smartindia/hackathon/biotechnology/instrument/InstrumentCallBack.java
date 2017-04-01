package com.smartindia.hackathon.biotechnology.instrument;

import com.smartindia.hackathon.biotechnology.instrument.model.data.InstrumentData;
import com.smartindia.hackathon.biotechnology.productDesc.model.data.InsturmentData;

/**
 * Created by aman on 1/4/17.
 */

public interface InstrumentCallBack {


    void onSuccess(InstrumentData instrumentData);
    void onFailure();
}
