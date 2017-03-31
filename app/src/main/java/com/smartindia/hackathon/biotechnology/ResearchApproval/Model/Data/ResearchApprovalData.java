package com.smartindia.hackathon.biotechnology.ResearchApproval.Model.Data;


public class ResearchApprovalData {
  private boolean success;
    private String message;

    public ResearchApprovalData(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
