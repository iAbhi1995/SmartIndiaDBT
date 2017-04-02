package com.smartindia.hackathon.biotechnology.SurveyViewerInstitute;


import com.smartindia.hackathon.biotechnology.SurveyViewerInstitute.Model.Data.ResultData;

public interface SurveyViewerCallback {

    void onFailure();

    void onSuccess(ResultData body);
}
