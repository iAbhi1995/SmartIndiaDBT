package com.smartindia.hackathon.biotechnology.instrument.model;

import com.smartindia.hackathon.biotechnology.instrument.InstrumentCallBack;

/**
 * Created by aman on 1/4/17.
 */

public interface Instrument_Provider {

    void request_Instrument(String token, String type, String id, InstrumentCallBack instrumentCallBack);
}
