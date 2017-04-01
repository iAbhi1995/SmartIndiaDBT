package com.smartindia.hackathon.biotechnology.InstituteFeedBackForm;


import com.smartindia.hackathon.biotechnology.InstituteFeedBackForm.Model.Data.FeedbackQues;

public interface FeedbackQuesCallback {
    public void onSuccess(FeedbackQues body) ;

    void onFailure();
}
