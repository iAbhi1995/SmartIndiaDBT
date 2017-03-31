package com.smartindia.hackathon.biotechnology.applyInternship.Model.Data;

public class ApplyInternData {
   private String message;
    private boolean success;

    public ApplyInternData(String message, boolean success) {
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
