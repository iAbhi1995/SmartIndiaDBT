package com.smartindia.hackathon.biotechnology.login.model.data;

public class SignUpResultData {
    private String message;
    private boolean success;

    public SignUpResultData(String message, boolean success) {
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
