package com.smartindia.hackathon.biotechnology.professor.model.data;

import java.util.List;

/**
 * Created by aman on 27/3/17.
 */

public class ProfessorData {
    private boolean success;
    private String message,type;
    List<InstitutionItemData>institutionItemDataList;
    List<FacilityItemData> facilityItemDataList;
    List<ProfessorCityData> city_list;
    List<ProfessorTopicData> topic_list;
    List<ProfessorItemData> professorItemDataList;
    List<SurveyItemData> surveyItemDataList;
List<ResearchItemData> researchItemDataList;

    public ProfessorData(boolean success, String message, String type, List<InstitutionItemData> institutionItemDataList, List<FacilityItemData> facilityItemDataList, List<ProfessorCityData> city_list, List<ProfessorTopicData> topic_list, List<ProfessorItemData> professorItemDataList, List<SurveyItemData> surveyItemDataList,
                         List<ResearchItemData> researchItemDataList) {
        this.success = success;
        this.message = message;
        this.type = type;
        this.institutionItemDataList = institutionItemDataList;
        this.facilityItemDataList = facilityItemDataList;
        this.city_list = city_list;
        this.topic_list = topic_list;
        this.professorItemDataList = professorItemDataList;
        this.surveyItemDataList = surveyItemDataList;
        this.researchItemDataList = researchItemDataList;
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

    public List<FacilityItemData> getFacilityItemDataList() {
        return facilityItemDataList;
    }

    public List<ProfessorCityData> getCity_list() {
        return city_list;
    }

    public List<ProfessorTopicData> getTopic_list() {
        return topic_list;
    }

    public List<ProfessorItemData> getProfessorItemDataList() {
        return professorItemDataList;
    }

    public List<SurveyItemData> getSurveyItemDataList() {
        return surveyItemDataList;
    }

    public List<ResearchItemData> getResearchItemDataList() {
        return researchItemDataList;
    }
}
