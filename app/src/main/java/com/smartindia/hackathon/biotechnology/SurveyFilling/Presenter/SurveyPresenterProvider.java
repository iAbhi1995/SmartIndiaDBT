package com.smartindia.hackathon.biotechnology.SurveyFilling.Presenter;

import com.smartindia.hackathon.biotechnology.SurveyFilling.Model.Data.SurveyData;
import com.smartindia.hackathon.biotechnology.SurveyFilling.Model.Data.SurveyResponse;
import com.smartindia.hackathon.biotechnology.SurveyFilling.Model.SurveyProvider;
import com.smartindia.hackathon.biotechnology.SurveyFilling.SurveyCallback;
import com.smartindia.hackathon.biotechnology.SurveyFilling.SurveyResponseCallback;
import com.smartindia.hackathon.biotechnology.SurveyFilling.View.SurveyView;

/**
 * Created by Abhishek on 29-03-2017.
 */


public class SurveyPresenterProvider implements SurveyPresenter {
    private SurveyProvider surveyProvider;
    private SurveyView surveyView;

    public SurveyPresenterProvider(SurveyProvider surveyProvider, SurveyView surveyView) {
        this.surveyProvider = surveyProvider;
        this.surveyView = surveyView;
    }

    @Override
    public void requestSurvey(String id, String type, String access_token) {
        surveyView.showLoading(true);
        surveyProvider.requestSurvey(id, type, access_token, new SurveyCallback() {
            @Override
            public void onSuccess(SurveyData surveyData) {
                if (surveyData.isSuccess()) {
                    surveyView.showLoading(false);
                    surveyView.onSurveyReceived(surveyData);
                } else {
                    surveyView.showLoading(false);
                    surveyView.showMessage("Error! Try again");
                }
            }

            @Override
            public void onFailure() {
                surveyView.showLoading(false);
                surveyView.showMessage("Something went wrong!");
            }
        });
    }

    @Override
    public void requestSurveyPost(String id, String type, String access_token, String answer1, String answer2, String answer3, String answer4) {
        surveyView.showLoading(true);
        surveyProvider.requestSurveyPost(id, type, access_token,answer1,answer2,answer3,answer4, new SurveyResponseCallback() {
            @Override
            public void onSuccess(SurveyResponse surveyResponse) {
                if (surveyResponse.isSuccess()) {
                    surveyView.showLoading(false);
                    surveyView.onSurveyPosted(surveyResponse);
                } else {
                    surveyView.showLoading(false);
                    surveyView.showMessage("Error! Try again");
                }
            }

            @Override
            public void onFailure() {
                surveyView.showLoading(false);
                surveyView.showMessage("Something went wrong!");
            }
        });
    }
}