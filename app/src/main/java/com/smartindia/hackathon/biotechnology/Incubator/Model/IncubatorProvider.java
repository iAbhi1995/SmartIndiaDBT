package com.smartindia.hackathon.biotechnology.Incubator.Model;

import com.smartindia.hackathon.biotechnology.Incubator.View.OnIncubatorsReceived;

/**
 * Created by ayush on 28-03-2017.
 */

public interface IncubatorProvider {

        void getIncubators(String type,String id, OnIncubatorsReceived OnIncubatorReceived);


}
