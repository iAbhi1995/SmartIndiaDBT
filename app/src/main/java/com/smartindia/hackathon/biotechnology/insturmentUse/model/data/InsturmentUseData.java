package com.smartindia.hackathon.biotechnology.insturmentUse.model.data;

/**
 * Created by aman on 30/3/17.
 */

public class InsturmentUseData {
    private boolean success;
   private String message;

    public InsturmentUseData(boolean success, String message) {
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
