package com.smartindia.hackathon.biotechnology.InstituteFeedBackForm.View;

import com.smartindia.hackathon.biotechnology.InstituteFeedBackForm.Model.Data.FeedbackQues;

public interface FeedbackView {
    void showProgressBar(boolean b);

    void showMessage(String message);
    void setQuestions(FeedbackQues questions);
}
