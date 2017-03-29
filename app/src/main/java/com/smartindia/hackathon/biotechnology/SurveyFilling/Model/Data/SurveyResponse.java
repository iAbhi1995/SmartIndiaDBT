package com.smartindia.hackathon.biotechnology.SurveyFilling.Model.Data;

/**
 * Created by Abhishek on 29-03-2017.
 */

public class SurveyResponse {
    private boolean success;
    private String message;

    public SurveyResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
