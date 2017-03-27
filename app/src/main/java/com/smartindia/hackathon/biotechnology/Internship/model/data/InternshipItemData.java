package com.smartindia.hackathon.biotechnology.Internship.model.data;

/**
 * Created by aman on 27/3/17.
 */

public class InternshipItemData {
    private String topic;
    private String companyName;
    private String location;
    private String startDate;
    private String duration;
    private String stipend;
    private String applyBy;


    public InternshipItemData(String topic, String companyName, String location, String startDate, String duration, String stipend, String applyBy) {
        this.topic = topic;
        this.companyName = companyName;
        this.location = location;
        this.startDate = startDate;
        this.duration = duration;
        this.stipend = stipend;
        this.applyBy = applyBy;
    }


    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getStipend() {
        return stipend;
    }

    public void setStipend(String stipend) {
        this.stipend = stipend;
    }

    public String getApplyBy() {
        return applyBy;
    }

    public void setApplyBy(String applyBy) {
        this.applyBy = applyBy;
    }
}
