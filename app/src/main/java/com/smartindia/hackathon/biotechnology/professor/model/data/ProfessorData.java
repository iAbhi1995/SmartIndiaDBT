package com.smartindia.hackathon.biotechnology.professor.model.data;

import java.util.List;

/**
 * Created by aman on 27/3/17.
 */

public class ProfessorData {
    private boolean success;
    private String message,type;

    List<ProfessorCityData> professorCityDataList;
    List<ProfessorTopicData> professorTopicDataList;
    List<ProfessorItemData> professorItemDataList;

    public ProfessorData(boolean success, String message, String type, List<ProfessorCityData> professorCityDataList, List<ProfessorTopicData> professorTopicDataList, List<ProfessorItemData> professorItemDataList) {
        this.success = success;
        this.message = message;
        this.type = type;
        this.professorCityDataList = professorCityDataList;
        this.professorTopicDataList = professorTopicDataList;
        this.professorItemDataList = professorItemDataList;
    }

    public String getType() {
        return type;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ProfessorCityData> getProfessorCityDataList() {
        return professorCityDataList;
    }

    public void setProfessorCityDataList(List<ProfessorCityData> professorCityDataList) {
        this.professorCityDataList = professorCityDataList;
    }

    public List<ProfessorTopicData> getProfessorTopicDataList() {
        return professorTopicDataList;
    }

    public void setProfessorTopicDataList(List<ProfessorTopicData> professorTopicDataList) {
        this.professorTopicDataList = professorTopicDataList;
    }

    public List<ProfessorItemData> getProfessorItemDataList() {
        return professorItemDataList;
    }

    public void setProfessorItemDataList(List<ProfessorItemData> professorItemDataList) {
        this.professorItemDataList = professorItemDataList;
    }
}
