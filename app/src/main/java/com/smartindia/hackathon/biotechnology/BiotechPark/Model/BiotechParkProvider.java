package com.smartindia.hackathon.biotechnology.BiotechPark.Model;

import com.smartindia.hackathon.biotechnology.BiotechPark.View.OnBiotechParkReceived;

/**
 * Created by ayush on 28-03-2017.
 */

public interface BiotechParkProvider {

        void getBiotechPark(String type,String id, OnBiotechParkReceived OnBiotechParkReceived);


}
