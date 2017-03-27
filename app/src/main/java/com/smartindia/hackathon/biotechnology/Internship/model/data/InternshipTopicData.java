package com.smartindia.hackathon.biotechnology.Internship.model.data;

/**
 * Created by aman on 27/3/17.
 */

public class InternshipTopicData {


    private String topic;
    private String topicId;

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public InternshipTopicData(String topic, String topicId) {
        this.topic = topic;
        this.topicId = topicId;
    }
}
