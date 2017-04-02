package com.smartindia.hackathon.biotechnology.BiotechParkProduct.model;

import com.smartindia.hackathon.biotechnology.BiotechParkProduct.model.data.BiotechParkData;
import com.smartindia.hackathon.biotechnology.BiotechParkProduct.View.OnBiotechParkReceived;

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