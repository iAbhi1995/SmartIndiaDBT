package com.smartindia.hackathon.biotechnology.instrument.presenter;

import com.smartindia.hackathon.biotechnology.instrument.InstrumentCallBack;
import com.smartindia.hackathon.biotechnology.instrument.model.Instrument_Provider;
import com.smartindia.hackathon.biotechnology.instrument.model.data.InstrumentData;
import com.smartindia.hackathon.biotechnology.instrument.view.InstrumentView;
import com.smartindia.hackathon.biotechnology.productDesc.model.data.InsturmentData;

/**
 * Created by aman on 1/4/17.
 */

public class InstrumentProviderImpl implements InstrumentPresenter {

    private InstrumentView instrumentView;
    private Instrument_Provider instrumentProvider;

    public InstrumentProviderImpl(InstrumentView instrumentView, Instrument_Provider instrumentProvider) {
        this.instrumentView = instrumentView;
        this.instrumentProvider = instrumentProvider;
    }


    @Override
    public void request_Instrument(String token, String type, String id) {
        instrumentProvider.request_Instrument(token, type, id, new InstrumentCallBack() {
            @Override
            public void onSuccess(InstrumentData instrumentData) {
                if(instrumentData.isSuccess())
                {
                    instrumentView.showProgressBar(false);
                    instrumentView.onCheck(instrumentData);
                }
                else
                {
                    instrumentView.showProgressBar(false);
                    instrumentView.showMessage(instrumentData.getMessage());
                }
            }

            @Override
            public void onFailure() {
                instrumentView.showProgressBar(false);
                instrumentView.showMessage("UNABLE TO CONNECT");

            }
        });
    }
}
