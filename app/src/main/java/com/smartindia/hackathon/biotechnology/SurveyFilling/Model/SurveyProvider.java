package com.smartindia.hackathon.biotechnology.SurveyFilling.Model;

import com.smartindia.hackathon.biotechnology.SurveyFilling.SurveyCallback;
import com.smartindia.hackathon.biotechnology.SurveyFilling.SurveyResponseCallback;

/**
 * Created by Abhishek on 29-03-2017.
 */

public interface SurveyProvider {

    void requestSurvey(String id, String type, String access_token, SurveyCallback surveyCallback);
    void requestSurveyPost(String id, String type, String access_token,String answer1, String answer2, String answer3,String answer4,SurveyResponseCallback responseCallback);

}
