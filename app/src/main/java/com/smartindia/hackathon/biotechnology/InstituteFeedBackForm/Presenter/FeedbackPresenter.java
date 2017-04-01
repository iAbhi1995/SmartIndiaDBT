package com.smartindia.hackathon.biotechnology.InstituteFeedBackForm.Presenter;


public interface FeedbackPresenter {
    void requestFeedbackQues();
    void requestSubmitFeedback(String instId, String answer1, String answer2, String answer3, String answer4, String answer5);
}
