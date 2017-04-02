package com.smartindia.hackathon.biotechnology.SurveyViewerInstitute.View;

import com.smartindia.hackathon.biotechnology.SurveyViewerInstitute.Model.Data.ResultData;

public interface SurveyView {
    void showProgressBar(boolean b);

    void showMessage(String message);

    void setSurveyAdapter(ResultData resultData);
}
