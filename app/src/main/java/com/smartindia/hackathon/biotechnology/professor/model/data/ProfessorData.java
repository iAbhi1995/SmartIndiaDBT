package com.smartindia.hackathon.biotechnology.professor.model.data;

import java.util.List;

/**
 * Created by aman on 27/3/17.
 */

public class ProfessorData {
    private boolean success;
    private String message;
    List<ProfessorCityData> professorCityDataList;
    List<ProfessorCollegeData> professorCollegeDataList;
    List<ProfessorTopicData> professorTopicDataList;
    List<ProfessorItemData> professorItemDataList;

    public ProfessorData(boolean success, String message, List<ProfessorCityData> professorCityDataList,
                         List<ProfessorCollegeData> professorCollegeDataList,
                         List<ProfessorTopicData> professorTopicDataList,
                         List<ProfessorItemData> professorItemDataList) {
        this.success = success;
        this.message = message;
        this.professorCityDataList = professorCityDataList;
        this.professorCollegeDataList = professorCollegeDataList;
        this.professorTopicDataList = professorTopicDataList;
        this.professorItemDataList = professorItemDataList;
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

    public List<ProfessorCollegeData> getProfessorCollegeDataList() {
        return professorCollegeDataList;
    }

    public void setProfessorCollegeDataList(List<ProfessorCollegeData> professorCollegeDataList) {
        this.professorCollegeDataList = professorCollegeDataList;
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
