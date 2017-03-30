package com.smartindia.hackathon.biotechnology.BiotechPark.Model;

import com.smartindia.hackathon.biotechnology.BiotechPark.Model.Data.BiotechParkData;
import com.smartindia.hackathon.biotechnology.BiotechPark.Model.Data.BiotechParkDetails;
import com.smartindia.hackathon.biotechnology.BiotechPark.View.OnBiotechParkReceived;

/**
 * Created by ayush on 28-03-2017.
 */

public class MockDataProviderBiotechPark implements BiotechParkProvider{

    @Override
    public void getBiotechPark(String type,String id, OnBiotechParkReceived OnBiotechParkReceived)
        {
        BiotechParkDetails biotechParkDetails =new BiotechParkDetails("Palan","Anogram","Maharashtra","Mumbai","Opposite Sbi Bank,Pandri,Mumbai","www.palan.in","Mr. Lokesh Choubey","Mumbai-491001");
        BiotechParkData biotechParkData=new BiotechParkData(biotechParkDetails,"",true);
            OnBiotechParkReceived.onSuccess(biotechParkData);
            OnBiotechParkReceived.onFailure();
    }
}