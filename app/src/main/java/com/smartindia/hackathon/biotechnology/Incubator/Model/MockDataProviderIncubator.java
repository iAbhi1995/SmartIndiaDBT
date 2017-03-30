package com.smartindia.hackathon.biotechnology.Incubator.Model;

import com.smartindia.hackathon.biotechnology.Incubator.Model.Data.IncubatorData;
import com.smartindia.hackathon.biotechnology.Incubator.Model.Data.IncubatorDetails;
import com.smartindia.hackathon.biotechnology.Incubator.View.OnIncubatorsReceived;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayush on 28-03-2017.
 */

public class MockDataProviderIncubator implements IncubatorProvider{

    @Override
    public void getIncubators(String type,String id, OnIncubatorsReceived OnIncubatorReceived)
        {
        IncubatorDetails incubatorDetails =new IncubatorDetails("Palan","Anogram","Maharashtra","Mumbai","Opposite Sbi Bank,Pandri,Mumbai","www.palan.in","Mr. Lokesh Choubey","Mumbai-491001");

        IncubatorData incubatorData=new IncubatorData(incubatorDetails,"",true);
            OnIncubatorReceived.onSuccess(incubatorData);
//            OnIncubatorReceived.onFailure();
    }
}


