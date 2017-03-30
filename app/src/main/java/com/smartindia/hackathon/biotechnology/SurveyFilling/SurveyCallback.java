package com.smartindia.hackathon.biotechnology.SurveyFilling;

import com.smartindia.hackathon.biotechnology.SurveyFilling.Model.Data.SurveyData;

/**
 * Created by Abhishek on 29-03-2017.
 */

public interface SurveyCallback {
    void onSuccess(SurveyData surveyData);
    void onFailure();
}
