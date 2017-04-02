package com.smartindia.hackathon.biotechnology.request.model.data;

public class RequestDataDetails {
    private String topic;
    private String name;
    private String stipend;
    private String duration;


    public RequestDataDetails(String topic, String name, String stipend, String duration) {
        this.topic = topic;
        this.name = name;
        this.stipend = stipend;
        this.duration = duration;
    }

    public String getTopic() {
        return topic;
    }

    public String getName() {
        return name;
    }

    public String getStipend() {
        return stipend;
    }

    public String getDuration() {
        return duration;
    }
}
