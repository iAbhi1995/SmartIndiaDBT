package com.smartindia.hackathon.biotechnology.login.model.data;

public class OTPdata {

    private boolean success;
    private String message;
    private String access_token;

    public OTPdata(boolean success, String message, String access_token) {
        this.success = success;
        this.message = message;
        this.access_token = access_token;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getAccess_token() {
        return access_token;
    }
}