package com.smartindia.hackathon.biotechnology.MyProfile.Model.Data;

public class MyProfileData {
    private String message;
    private boolean success;


    public MyProfileData(String message, boolean success) {
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
