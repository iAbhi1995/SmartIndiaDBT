package com.smartindia.hackathon.biotechnology.setInternship.model.data;

/**
 * Created by aman on 29/3/17.
 */

public class SetInternshipData {
    private boolean success;
    private String message;

    public SetInternshipData(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
