package com.smartindia.hackathon.biotechnology.BiotechPark.Model;

import com.smartindia.hackathon.biotechnology.BiotechPark.BiotechParkCallback;

public interface BiotechParkProvider {

        void getBiotechPark(String type, String id, BiotechParkCallback BiotechParkCallback);


}
