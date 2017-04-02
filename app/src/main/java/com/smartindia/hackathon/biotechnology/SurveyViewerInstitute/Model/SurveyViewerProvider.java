package com.smartindia.hackathon.biotechnology.SurveyViewerInstitute.Model;


import com.smartindia.hackathon.biotechnology.SurveyViewerInstitute.SurveyViewerCallback;

public interface SurveyViewerProvider {
    void requestSurveyResult(String access_token, final SurveyViewerCallback surveyViewerCallback);

}
