package com.smartindia.hackathon.biotechnology.InstituteFeedBackForm.Presenter;

import android.util.Log;

import com.smartindia.hackathon.biotechnology.InstituteFeedBackForm.FeedbackPostCallback;
import com.smartindia.hackathon.biotechnology.InstituteFeedBackForm.FeedbackQuesCallback;
import com.smartindia.hackathon.biotechnology.InstituteFeedBackForm.Model.Data.FeedbackQues;
import com.smartindia.hackathon.biotechnology.InstituteFeedBackForm.Model.Data.FeedbackSubmit;
import com.smartindia.hackathon.biotechnology.InstituteFeedBackForm.Model.FeedbackProvider;
import com.smartindia.hackathon.biotechnology.InstituteFeedBackForm.View.FeedbackView;

public class FeedbackPresenterImpl implements FeedbackPresenter {
    private FeedbackProvider feedbackProvider;
    private FeedbackView feedbackView;

    public FeedbackPresenterImpl(FeedbackProvider feedbackProvider, FeedbackView feedbackView) {
        this.feedbackProvider = feedbackProvider;
        this.feedbackView = feedbackView;
    }

    @Override
    public void requestFeedbackQues() {
        feedbackView.showProgressBar(true);
        feedbackProvider.requestFeedbackQues(new FeedbackQuesCallback() {
            @Override
            public void onSuccess(FeedbackQues feedbackQues) {
                if (feedbackQues.isSuccess()) {
                    feedbackView.showProgressBar(false);
                } else {
                    feedbackView.showProgressBar(false);
                    feedbackView.showMessage(feedbackQues.getMessage());
                }
            }

            @Override
            public void onFailure() {
                feedbackView.showProgressBar(false);
                feedbackView.showMessage("Something went wrong! Try Again");
            }
        });
    }

    @Override
    public void requestSubmitFeedback(String instId, String answer1, String answer2, String answer3, String answer4, String comment) {
        feedbackView.showProgressBar(true);
        feedbackProvider.requestSubmitFeedback(instId, answer1, answer2, answer3, answer4, comment, new FeedbackPostCallback() {
            @Override
            public void onSuccess(FeedbackSubmit feedbackSubmit) {
                if (feedbackSubmit.isSuccess()) {
                    Log.d("abhi","InFeedback Success");
                    feedbackView.showProgressBar(false);
                    feedbackView.showMessage("FeedBack Submitted");

                } else {
                    Log.d("abhi","InFeedback false");
                    feedbackView.showProgressBar(false);
                    feedbackView.showMessage(feedbackSubmit.getMessage());
                }
            }

            @Override
            public void onFailure() {

                Log.d("abhi","InFeedback failure");
                feedbackView.showProgressBar(false);
                feedbackView.showMessage("Something went wrong! Try Again");
            }
        });
    }
}
