package com.smartindia.hackathon.biotechnology.BiotechParkProduct.model;

import com.smartindia.hackathon.biotechnology.BiotechParkProduct.View.OnBiotechParkReceived;

/**
 * Created by ayush on 28-03-2017.
 */

public interface BiotechParkProvider {

        void getBiotechPark(String token,String type,String id, OnBiotechParkReceived OnBiotechParkReceived);


}
