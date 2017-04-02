package com.smartindia.hackathon.biotechnology.SurveyViewerInstitute.Model.Data;


import java.util.List;

public class ResultData {
    private String message;
    private boolean success;
    private List<SurveyResultDetails> surveyResultDetailsList;

    public ResultData(String message, boolean success, List<SurveyResultDetails> surveyResultDetailsList) {
        this.message = message;
        this.success = success;
        this.surveyResultDetailsList = surveyResultDetailsList;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public List<SurveyResultDetails> getSurveyResultDetailsList() {
        return surveyResultDetailsList;
    }
}
