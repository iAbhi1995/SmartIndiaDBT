package com.smartindia.hackathon.biotechnology.SurveyUpload.Model.Data;

/**
 * Created by ayush on 28-03-2017.
 */

public class SureveyUploadData {
    private String message;
    private boolean success;


    public SureveyUploadData(String message, boolean success) {
        this.message = message;
        this.success = success;
    }


    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }
}
