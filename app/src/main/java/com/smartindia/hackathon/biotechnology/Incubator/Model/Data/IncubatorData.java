package com.smartindia.hackathon.biotechnology.Incubator.Model.Data;

import java.util.List;

/**
 * Created by ayush on 28-03-2017.
 */

public class IncubatorData {
    private IncubatorDetails incubatorDetails;
    private String message;
    private boolean success;

    public IncubatorData(IncubatorDetails incubatorDetails, String message, boolean success) {
        this.incubatorDetails = incubatorDetails;
        this.message = message;
        this.success = success;
    }

    public IncubatorDetails getIncubatorDetails() {
        return incubatorDetails;
    }
    public String getMessage() {
        return message;
    }
    public boolean isSuccess() {
        return success;
    }
}
