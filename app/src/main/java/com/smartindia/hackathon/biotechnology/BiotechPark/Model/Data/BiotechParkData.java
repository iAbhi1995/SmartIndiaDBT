package com.smartindia.hackathon.biotechnology.BiotechPark.Model.Data;

/**
 * Created by ayush on 28-03-2017.
 */

public class BiotechParkData {
    private BiotechParkDetails incubatorDetails;
    private String message;
    private boolean success;

    public BiotechParkData(BiotechParkDetails incubatorDetails, String message, boolean success) {
        this.incubatorDetails = incubatorDetails;
        this.message = message;
        this.success = success;
    }

    public BiotechParkDetails getIncubatorDetails() {
        return incubatorDetails;
    }
    public String getMessage() {
        return message;
    }
    public boolean isSuccess() {
        return success;
    }
}
