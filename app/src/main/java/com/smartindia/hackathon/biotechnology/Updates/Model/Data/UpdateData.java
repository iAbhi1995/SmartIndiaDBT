package com.smartindia.hackathon.biotechnology.Updates.Model.Data;

import java.util.List;

public class UpdateData {
    private String message;
    private boolean success;
    private List<String> update;

    public UpdateData(String message, boolean success, List<String> update) {
        this.message = message;
        this.success = success;
        this.update = update;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public List<String> getUpdate() {
        return update;
    }
}