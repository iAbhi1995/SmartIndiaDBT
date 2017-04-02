package com.smartindia.hackathon.biotechnology.ResearchPaper.Model.Data;

public class ResearchPaperData {
    private boolean success;
    private String message,DATA;


    public ResearchPaperData(boolean success, String message, String data) {
        this.success = success;
        this.message = message;

        DATA = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getDATA() {
        return DATA;
    }
}
