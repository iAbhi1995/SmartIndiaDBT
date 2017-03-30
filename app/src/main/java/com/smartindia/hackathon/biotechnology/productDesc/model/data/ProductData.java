package com.smartindia.hackathon.biotechnology.productDesc.model.data;

import java.util.List;

/**
 * Created by aman on 29/3/17.
 */

public class ProductData {
    private boolean success;
    private String message;
    private BiotechParkData biotechParkData;
    private IncubatorsData incubatorsData;
    private InsturmentData insturmentData;
    private ResearchPaperData researchPaperData;
    private ProfileData profileData;
    private SurveyData surveyData;

    public ProductData(boolean success, String message, BiotechParkData biotechParkData, IncubatorsData incubatorsData, InsturmentData insturmentData,
                       ResearchPaperData researchPaperData, ProfileData profileData, SurveyData surveyData) {
        this.success = success;
        this.message = message;
        this.biotechParkData = biotechParkData;
        this.incubatorsData = incubatorsData;
        this.insturmentData = insturmentData;
        this.researchPaperData = researchPaperData;
        this.profileData = profileData;
        this.surveyData = surveyData;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public BiotechParkData getBiotechParkData() {
        return biotechParkData;
    }

    public IncubatorsData getIncubatorsData() {
        return incubatorsData;
    }

    public InsturmentData getInsturmentData() {
        return insturmentData;
    }

    public ResearchPaperData getResearchPaperData() {
        return researchPaperData;
    }

    public ProfileData getProfileData() {
        return profileData;
    }

    public SurveyData getSurveyData() {
        return surveyData;
    }
}