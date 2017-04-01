package com.smartindia.hackathon.biotechnology.professor.model.data;

/**
 * Created by aman on 1/4/17.
 */

public class SurveyItemData {
    private String title,topic,desc,id;

    public String getTitle() {
        return title;
    }

    public String getTopic() {
        return topic;
    }

    public String getDesc() {
        return desc;
    }

    public String getId() {
        return id;
    }

    public SurveyItemData(String title, String topic, String desc, String id) {

        this.title = title;
        this.topic = topic;
        this.desc = desc;
        this.id = id;
    }
}
