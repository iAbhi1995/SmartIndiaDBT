package com.smartindia.hackathon.biotechnology.applyInternship.Presenter;


import com.smartindia.hackathon.biotechnology.applyInternship.ApplyInternshipCallback;
import com.smartindia.hackathon.biotechnology.applyInternship.GetInternshipCallback;
import com.smartindia.hackathon.biotechnology.applyInternship.Model.ApplyInternProvider;
import com.smartindia.hackathon.biotechnology.applyInternship.Model.Data.ApplyInternData;
import com.smartindia.hackathon.biotechnology.applyInternship.Model.Data.GetInternshipData;
import com.smartindia.hackathon.biotechnology.applyInternship.View.GetInternshipView;

public class ApplyInternPresenterImpl implements ApplyInternPresenter {

    private ApplyInternProvider applyInternProvider;
    private GetInternshipView getInternshipView;

    public ApplyInternPresenterImpl(ApplyInternProvider applyInternProvider, GetInternshipView getInternshipView) {
        this.applyInternProvider = applyInternProvider;
        this.getInternshipView = getInternshipView;
    }


    @Override
    public void getInternship(String id, String access_token) {
        getInternshipView.showProgressBar(true);
        applyInternProvider.getInternship(id, access_token, new GetInternshipCallback() {
            @Override
            public void onSuccess(GetInternshipData getInternshipData) {
                if (getInternshipData.isSuccess()) {
                    getInternshipView.showProgressBar(false);
                    getInternshipView.ShowInternDetails(getInternshipData);
                } else {
                    getInternshipView.showProgressBar(false);
                    getInternshipView.showMessage(getInternshipData.getMessage());
                }
            }

            @Override
            public void onFailure() {
                getInternshipView.showProgressBar(false);
                getInternshipView.showMessage("Something went wrong!" +
                        "Try Again");
            }
        });
    }

    @Override
    public void applyInternship(String id, String access_token) {
        getInternshipView.showProgressBar(true);


        applyInternProvider.applyInternship(id, access_token, new ApplyInternshipCallback() {
            @Override
            public void onSuccess(ApplyInternData applyInternData) {
                if (applyInternData.isSuccess()) {
                    getInternshipView.showProgressBar(false);
                    getInternshipView.SuccessfullApplication(applyInternData);
                } else {
                    getInternshipView.showProgressBar(false);
                    getInternshipView.showMessage(applyInternData.getMessage());
                }
            }

            @Override
            public void onFailure() {
                getInternshipView.showProgressBar(false);
                getInternshipView.showMessage("Something went wrong!Please Try again");
            }
        });
    }
}
