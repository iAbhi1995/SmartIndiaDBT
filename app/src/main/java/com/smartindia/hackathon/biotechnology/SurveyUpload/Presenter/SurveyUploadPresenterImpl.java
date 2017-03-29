package com.smartindia.hackathon.biotechnology.SurveyUpload.Presenter;

import android.util.Log;

import com.smartindia.hackathon.biotechnology.SurveyUpload.Model.Data.SureveyUploadData;
import com.smartindia.hackathon.biotechnology.SurveyUpload.Model.RetrofitSurveyUploadProvider;
import com.smartindia.hackathon.biotechnology.SurveyUpload.Model.SurveyUploadProvider;
import com.smartindia.hackathon.biotechnology.SurveyUpload.View.OnSurveyUploadCallBack;
import com.smartindia.hackathon.biotechnology.SurveyUpload.View.SurveyUploadView;
import com.smartindia.hackathon.biotechnology.SurveyUpload.View.Survey_Upload;

/**
 * Created by ayush on 28-03-2017.
 */

public class SurveyUploadPresenterImpl implements SurveyUploadPresenter {

    SurveyUploadView surveyUploadView;
    SurveyUploadProvider surveyUploadProvider;

    public SurveyUploadPresenterImpl(SurveyUploadView surveyUploadView, SurveyUploadProvider surveyUploadProvider)
    {
        this.surveyUploadView = surveyUploadView;
        this.surveyUploadProvider = surveyUploadProvider;
    }


    @Override
    public void requestUpload(String access_token,String type,String uri,String survey_title, String survey_scale, String survey_description, String survey_question1,
                              String survey_question2, String survey_question3, String survey_question4)
    {

        surveyUploadView.showLoading(true);
        surveyUploadProvider.requestUpload(access_token,type,uri, survey_title, survey_scale, survey_description, survey_question1, survey_question2, survey_question3, survey_question4, new OnSurveyUploadCallBack() {

            @Override
            public void onSuccess(SureveyUploadData sureveyUploadData) {
                if (sureveyUploadData.isSuccess()) {
                    surveyUploadView.showLoading(false);
                    surveyUploadView.onSurveyUploadVerified();
                } else {
                    surveyUploadView.showLoading(false);
                    surveyUploadView.showMessage(sureveyUploadData.getMessage());

                }
            }

            @Override
            public void onFailure(String error) {
                surveyUploadView.showLoading(false);
                surveyUploadView.showMessage("Failed");
            }
        });
    }
}
