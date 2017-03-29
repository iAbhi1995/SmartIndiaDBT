package com.smartindia.hackathon.biotechnology.request.model.data;

/**
 * Created by aman on 27/3/17.
 */

public class RequestDataDetails {
    private String skillName;
    private String companyName;
    private String appliedOn;
    private String appliedStatus;
    private String comment;

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAppliedOn() {
        return appliedOn;
    }

    public void setAppliedOn(String appliedOn) {
        this.appliedOn = appliedOn;
    }

    public String getAppliedStatus() {
        return appliedStatus;
    }

    public void setAppliedStatus(String appliedStatus) {
        this.appliedStatus = appliedStatus;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public RequestDataDetails(String skillName, String companyName, String appliedOn, String appliedStatus, String comment) {

        this.skillName = skillName;
        this.companyName = companyName;
        this.appliedOn = appliedOn;
        this.appliedStatus = appliedStatus;
        this.comment = comment;
    }
}
