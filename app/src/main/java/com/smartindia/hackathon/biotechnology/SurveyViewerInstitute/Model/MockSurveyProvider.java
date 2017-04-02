package com.smartindia.hackathon.biotechnology.SurveyViewerInstitute.Model;

import android.os.Handler;

import com.smartindia.hackathon.biotechnology.SurveyViewerInstitute.Model.Data.ResultData;
import com.smartindia.hackathon.biotechnology.SurveyViewerInstitute.Model.Data.SurveyResultDetails;
import com.smartindia.hackathon.biotechnology.SurveyViewerInstitute.SurveyViewerCallback;

import java.util.ArrayList;
import java.util.List;

public class MockSurveyProvider implements SurveyViewerProvider {
    private ResultData mockSurveyData;

    @Override
    public void requestSurveyResult(String access_token, final SurveyViewerCallback surveyViewerCallback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                surveyViewerCallback.onSuccess(getMockSurveyData());
            }
        }, 500);
    }

    public ResultData getMockSurveyData() {
        SurveyResultDetails detail1 = new SurveyResultDetails("aaa", "Survey for Diabetes", "Do you have diabetes?",
                "Are of the age group of 20-40", "Do you eat anything oily?", "Do you have a sudden heart pain at times", "75", "80", "20", "30");
        SurveyResultDetails detail2 = new SurveyResultDetails("aaa", "Survey for Diabetes", "Do you have diabetes?",
                "Are of the age group of 20-40", "Do you eat anything oily?", "Do you have a sudden heart pain at times", "75", "80", "20", "30");
        List<SurveyResultDetails> list = new ArrayList<>();
        list.add(detail1);
        list.add(detail2);
        mockSurveyData = new ResultData("Success", true, list);
        return mockSurveyData;
    }
}
