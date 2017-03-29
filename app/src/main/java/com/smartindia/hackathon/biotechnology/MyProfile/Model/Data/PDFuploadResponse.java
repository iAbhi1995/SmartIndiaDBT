package com.smartindia.hackathon.biotechnology.MyProfile.Model.Data;

/**
 * Created by Abhishek on 28-03-2017.
 */

public class PDFuploadResponse {
    private boolean success;
    private String error;

    public PDFuploadResponse(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}