package com.smartindia.hackathon.biotechnology.professor.model.data;

/**
 * Created by aman on 27/3/17.
 */

public class ProfessorTopicData {

    private String topic;
    private String topicId;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public ProfessorTopicData(String topic, String topicId) {

        this.topic = topic;
        this.topicId = topicId;
    }
}
