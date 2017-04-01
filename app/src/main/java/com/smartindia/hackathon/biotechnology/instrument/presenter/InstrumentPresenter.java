package com.smartindia.hackathon.biotechnology.instrument.presenter;

import com.smartindia.hackathon.biotechnology.instrument.InstrumentCallBack;

/**
 * Created by aman on 2/4/17.
 */

public interface InstrumentPresenter {


    void request_Instrument(String token, String type, String id);
}
