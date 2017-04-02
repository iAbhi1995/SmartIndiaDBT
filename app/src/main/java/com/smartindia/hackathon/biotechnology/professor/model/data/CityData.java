package com.smartindia.hackathon.biotechnology.professor.model.data;

import java.util.List;

/**
 * Created by iket on 2/4/17.
 */

public class CityData {
    List<ProfessorCityData> city_list;
    List<ProfessorTopicData> topic_list;
    Boolean success;
    String message;

    public CityData(List<ProfessorCityData> city_list, List<ProfessorTopicData> topic_list, Boolean success, String message) {
        this.city_list = city_list;
        this.topic_list = topic_list;
        this.success = success;
        this.message = message;
    }

    public List<ProfessorCityData> getCity_list() {
        return city_list;
    }

    public List<ProfessorTopicData> getTopic_list() {
        return topic_list;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
