package com.smartindia.hackathon.biotechnology.login.model.data;

/**
 * Created by Abhishek on 29-03-2017.
 */

public class ProfLogInData {
    private boolean success;
    private String message,access_token;

    public ProfLogInData(boolean success, String message, String access_token) {
        this.success = success;
        this.message = message;
        this.access_token = access_token;
    }

    public String getAccess_token() {
        return access_token;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }
}
