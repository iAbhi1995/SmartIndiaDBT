package com.smartindia.hackathon.biotechnology.login.model.data;

/**
 * Created by Abhishek on 28-03-2017.
 */

public class LoginData {
    private boolean success;
    private String message;
    private String access_token;

    public LoginData(String access_token, String message, boolean success) {
        this.access_token = access_token;
        this.message = message;
        this.success = success;
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
