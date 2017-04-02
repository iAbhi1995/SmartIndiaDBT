package com.smartindia.hackathon.biotechnology.SurveyViewerInstitute.Presenter;


import com.smartindia.hackathon.biotechnology.SurveyViewerInstitute.Model.Data.ResultData;
import com.smartindia.hackathon.biotechnology.SurveyViewerInstitute.Model.SurveyViewerProvider;
import com.smartindia.hackathon.biotechnology.SurveyViewerInstitute.SurveyViewerCallback;
import com.smartindia.hackathon.biotechnology.SurveyViewerInstitute.View.SurveyView;

public class SurveyViewerPresenterImpl implements SurveyViewerPresenter {

    private SurveyView surveyView;
    private SurveyViewerProvider surveyProvider;

    public SurveyViewerPresenterImpl(SurveyView surveyView, SurveyViewerProvider surveyProvider) {
        this.surveyProvider = surveyProvider;
        this.surveyView = surveyView;
    }

    @Override
    public void requestSurveyResult(String access_token) {
        surveyView.showProgressBar(true);
        surveyProvider.requestSurveyResult(access_token, new SurveyViewerCallback() {

            @Override
            public void onSuccess(ResultData resultData) {
                if (resultData.isSuccess()) {
                    surveyView.showProgressBar(false);
                    surveyView.setSurveyAdapter(resultData);
                } else {
                    surveyView.showProgressBar(false);
                    surveyView.showMessage(resultData.getMessage());
                }
            }

            @Override
            public void onFailure() {
                surveyView.showProgressBar(false);
                surveyView.showMessage("Something wwnt wrong! Please try again");
            }

        });
    }
}
