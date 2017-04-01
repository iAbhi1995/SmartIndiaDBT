package com.smartindia.hackathon.biotechnology.InstituteFeedBackForm;

import com.smartindia.hackathon.biotechnology.InstituteFeedBackForm.Model.Data.FeedbackSubmit;

public interface FeedbackPostCallback {
    void onSuccess(FeedbackSubmit body);

    void onFailure();
}
