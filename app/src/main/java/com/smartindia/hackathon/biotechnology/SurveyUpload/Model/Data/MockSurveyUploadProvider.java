package com.smartindia.hackathon.biotechnology.SurveyUpload.Model.Data;

import com.smartindia.hackathon.biotechnology.SurveyUpload.Model.SurveyUploadProvider;
import com.smartindia.hackathon.biotechnology.SurveyUpload.View.OnSurveyUploadCallBack;

/**
 * Created by ayush on 29-03-2017.
 */

public class MockSurveyUploadProvider implements SurveyUploadProvider {
    @Override
    public void requestUpload(String uri, String survey_title, String survey_scale, String survey_description, String survey_question1, String survey_question2, String survey_question3, String survey_question4, OnSurveyUploadCallBack onSurveyUploadCallBack) {
        SureveyUploadData sureveyUploadData = new SureveyUploadData("Success",true);
        onSurveyUploadCallBack.onSuccess(sureveyUploadData);
    }
}
