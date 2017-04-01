package com.smartindia.hackathon.biotechnology.InstituteFeedBackForm.Model;


import com.smartindia.hackathon.biotechnology.InstituteFeedBackForm.FeedbackPostCallback;
import com.smartindia.hackathon.biotechnology.InstituteFeedBackForm.FeedbackQuesCallback;

public interface FeedbackProvider {

    void requestFeedbackQues(FeedbackQuesCallback quesCallback);
    void requestSubmitFeedback(String instId, String answer1, String answer2, String answer3, String answer4, String answer5, FeedbackPostCallback postCallback);
}
