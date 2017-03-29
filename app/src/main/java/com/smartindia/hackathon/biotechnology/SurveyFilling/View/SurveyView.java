package com.smartindia.hackathon.biotechnology.SurveyFilling.View;

import com.smartindia.hackathon.biotechnology.SurveyFilling.Model.Data.SurveyData;
import com.smartindia.hackathon.biotechnology.SurveyFilling.Model.Data.SurveyResponse;

/**
 * Created by Abhishek on 29-03-2017.
 */

public interface SurveyView {
    void showMessage(String message);
    void showLoading(boolean show);

    void onSurveyPosted(SurveyResponse surveyResponse);

    void onSurveyReceived(SurveyData surveyData);
}
