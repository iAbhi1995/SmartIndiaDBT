package com.smartindia.hackathon.biotechnology.professor.model.data;

/**
 * Created by aman on 1/4/17.
 */

public class SurveyItemData {
    private String title,topic,desc,id,q1,q2;

    public SurveyItemData(String title, String topic, String desc, String id, String q1, String q2) {
        this.title = title;
        this.topic = topic;
        this.desc = desc;
        this.id = id;
        this.q1 = q1;
        this.q2 = q2;
    }

    public String getQ1() {
        return q1;
    }

    public String getQ2() {
        return q2;
    }

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

}
