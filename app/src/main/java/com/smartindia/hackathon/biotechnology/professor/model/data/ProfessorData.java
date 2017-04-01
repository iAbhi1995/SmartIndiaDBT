package com.smartindia.hackathon.biotechnology.professor.model.data;

import java.util.List;

/**
 * Created by aman on 27/3/17.
 */

public class ProfessorData {
    private boolean success;
    private String message,type;
    List<InstitutionItemData>institutionItemDataList;
    List<ProfessorCityData> professorCityDataList;
    List<ProfessorTopicData> professorTopicDataList;
    List<ProfessorItemData> professorItemDataList;
    List<SurveyItemData> surveyItemDataList;

    public ProfessorData(boolean success, String message, List<ProfessorCityData> professorCityDataList, List<ProfessorTopicData> professorTopicDataList,
                         List<ProfessorItemData> professorItemDataList) {
        this.success = success;
        this.message = message;
        this.type = type;
        this.institutionItemDataList = institutionItemDataList;
        this.professorCityDataList = professorCityDataList;
        this.professorTopicDataList = professorTopicDataList;
        this.professorItemDataList = professorItemDataList;
        this.surveyItemDataList = surveyItemDataList;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getType() {
        return type;
    }

    public List<InstitutionItemData> getInstitutionItemDataList() {
        return institutionItemDataList;
    }

    public List<ProfessorCityData> getProfessorCityDataList() {
        return professorCityDataList;
    }

    public List<ProfessorTopicData> getProfessorTopicDataList() {
        return professorTopicDataList;
    }

    public List<ProfessorItemData> getProfessorItemDataList() {
        return professorItemDataList;
    }

    public List<SurveyItemData> getSurveyItemDataList() {
        return surveyItemDataList;
    }
}
