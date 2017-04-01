package com.smartindia.hackathon.biotechnology.InstituteFeedBackForm.Model;


import android.os.Handler;

import com.smartindia.hackathon.biotechnology.InstituteFeedBackForm.FeedbackPostCallback;
import com.smartindia.hackathon.biotechnology.InstituteFeedBackForm.FeedbackQuesCallback;
import com.smartindia.hackathon.biotechnology.InstituteFeedBackForm.Model.Data.FeedbackQues;
import com.smartindia.hackathon.biotechnology.InstituteFeedBackForm.Model.Data.FeedbackSubmit;

public class MockFeedbackProvider implements FeedbackProvider{


    private FeedbackQues mockQuesData;
    private FeedbackSubmit postFeedData;

    @Override
    public void requestFeedbackQues(final FeedbackQuesCallback quesCallback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                quesCallback.onSuccess(getMockQuesData());
            }
        }, 500);
    }

    @Override
    public void requestSubmitFeedback(String instId, String answer1, String answer2, String answer3, String answer4, String comment, final FeedbackPostCallback postCallback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                postCallback.onSuccess(getPostFeedData());
            }
        }, 500);
    }

    public FeedbackQues getMockQuesData() {
        mockQuesData=new FeedbackQues("Success","How much useful was the information provided?","How was the User Interface?",
                "What the keyword based search useful?","How will you rate the feature of Survey form ?",true);
        return mockQuesData;
    }

    public FeedbackSubmit getPostFeedData() {
        postFeedData=new FeedbackSubmit("Success",true);
        return postFeedData;
    }
}
