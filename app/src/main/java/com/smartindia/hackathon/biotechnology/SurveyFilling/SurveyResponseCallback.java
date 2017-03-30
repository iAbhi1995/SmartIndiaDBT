package com.smartindia.hackathon.biotechnology.SurveyFilling;

import com.smartindia.hackathon.biotechnology.SurveyFilling.Model.Data.SurveyResponse;

/**
 * Created by Abhishek on 29-03-2017.
 */

public interface SurveyResponseCallback {
    void onSuccess(SurveyResponse response);
    void onFailure();
}
