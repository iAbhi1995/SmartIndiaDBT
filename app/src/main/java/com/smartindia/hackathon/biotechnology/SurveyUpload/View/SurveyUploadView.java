package com.smartindia.hackathon.biotechnology.SurveyUpload.View;

/**
 * Created by ayush on 28-03-2017.
 */

public interface SurveyUploadView {
    void showMessage(String message);
    void showLoading(boolean show);
    void onSurveyUploadVerified();
}
