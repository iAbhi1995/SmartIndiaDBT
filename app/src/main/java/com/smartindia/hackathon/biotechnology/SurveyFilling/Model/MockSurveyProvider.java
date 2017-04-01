package com.smartindia.hackathon.biotechnology.SurveyFilling.Model;

import android.os.Handler;

import com.smartindia.hackathon.biotechnology.SurveyFilling.Model.Data.SurveyData;
import com.smartindia.hackathon.biotechnology.SurveyFilling.Model.Data.SurveyResponse;
import com.smartindia.hackathon.biotechnology.SurveyFilling.SurveyCallback;
import com.smartindia.hackathon.biotechnology.SurveyFilling.SurveyResponseCallback;

public class MockSurveyProvider implements SurveyProvider{
    private SurveyData mockSurveyData;
    private SurveyResponse mockSurveyPost;

    @Override
    public void requestSurvey(String id, String type, String access_token, final SurveyCallback surveyCallback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                surveyCallback.onSuccess(getMockSurveyData());
            }
        }, 500);
    }

    @Override
    public void requestSurveyPost(String id, String type, String access_token, String answer1, String answer2, String answer3, String answer4, final SurveyResponseCallback responseCallback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                responseCallback.onSuccess(getMockSurveyPost());
            }
        }, 500);
    }

    public SurveyData getMockSurveyData() {
        mockSurveyData=new SurveyData("Survey for Diabetes","Diabetes is incresing day by day ,youths are also affected by this.","Do you eat sugar directly","Are you in the age group of 20-40",
          "Is your sugar level btw 1.2 -7.9","Do you get pain in your heart regularly",true);
        return mockSurveyData;
    }

    public SurveyResponse getMockSurveyPost() {
        mockSurveyPost=new SurveyResponse(true,"Success");
        return mockSurveyPost;
    }
}
