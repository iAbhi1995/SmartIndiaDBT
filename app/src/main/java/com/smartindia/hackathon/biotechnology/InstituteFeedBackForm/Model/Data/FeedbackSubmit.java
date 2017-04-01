package com.smartindia.hackathon.biotechnology.InstituteFeedBackForm.Model.Data;

public class FeedbackSubmit {
    private String message;
    private boolean success;

    public FeedbackSubmit(String message, boolean success) {
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