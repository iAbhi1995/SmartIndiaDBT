package com.smartindia.hackathon.biotechnology.Incubator.Presenter;

import com.smartindia.hackathon.biotechnology.Incubator.Model.Data.IncubatorData;
import com.smartindia.hackathon.biotechnology.Incubator.Model.IncubatorProvider;
import com.smartindia.hackathon.biotechnology.Incubator.View.IncubatorsInterface;
import com.smartindia.hackathon.biotechnology.Incubator.View.OnIncubatorsReceived;

/**
 * Created by ayush on 28-03-2017.
 */

public class IncubatorsPresenterImpl implements IncubatorsPresenter{
    private IncubatorsInterface incubatorsInterface;
    private IncubatorProvider incubatorProvider;

    public IncubatorsPresenterImpl(IncubatorsInterface incubatorsInterface,IncubatorProvider incubatorProvider) {
        this.incubatorsInterface=incubatorsInterface;
        this.incubatorProvider=incubatorProvider;
    }

    @Override
    public void getIncubator(String type, String id) {

        incubatorsInterface.showProgressBar(true);
        incubatorProvider.getIncubators(type,id, new OnIncubatorsReceived() {
            @Override
            public void onSuccess(IncubatorData incubatorData) {
                if(incubatorData.isSuccess())
                {
                    incubatorsInterface.showProgressBar(false);
                    incubatorsInterface.OnDataReceived(incubatorData);
                }
                else
                {
                    incubatorsInterface.showProgressBar(false);
                    incubatorsInterface.showMessage(incubatorData.getMessage());
                }

            }

            @Override
            public void onFailure() {
                incubatorsInterface.showProgressBar(false);
                incubatorsInterface.showMessage("No Internet Connection");

            }
        });



    }
}
