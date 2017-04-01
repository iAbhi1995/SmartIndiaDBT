package com.smartindia.hackathon.biotechnology.professor.model.data;

/**
 * Created by aman on 1/4/17.
 */

public class ResearchItemData {

    private String topic;
    private String companyName;
    private String location;
    private String startDate;
    private String duration;
    private String stipend;
    private String applyBy;
    private String id;

    public ResearchItemData(String topic, String companyName, String location, String startDate,
                            String duration, String stipend, String applyBy, String id) {
        this.topic = topic;
        this.companyName = companyName;
        this.location = location;
        this.startDate = startDate;
        this.duration = duration;
        this.stipend = stipend;
        this.applyBy = applyBy;
        this.id = id;
    }


    public String getTopic() {
        return topic;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getLocation() {
        return location;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getDuration() {
        return duration;
    }

    public String getStipend() {
        return stipend;
    }

    public String getApplyBy() {
        return applyBy;
    }

    public String getId() {
        return id;
    }
}
