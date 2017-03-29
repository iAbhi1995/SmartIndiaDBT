package com.smartindia.hackathon.biotechnology.SurveyUpload.Model;

import android.net.Uri;

import com.smartindia.hackathon.biotechnology.SurveyUpload.View.OnSurveyUploadCallBack;

/**
 * Created by ayush on 28-03-2017.
 */

public interface SurveyUploadProvider {
    void requestUpload(String access_token,String type,String uri, String survey_title, String survey_scale, String survey_description, String survey_question1, String
            survey_question2,String survey_question3, String survey_question4, OnSurveyUploadCallBack onSurveyUploadCallBack);
}
