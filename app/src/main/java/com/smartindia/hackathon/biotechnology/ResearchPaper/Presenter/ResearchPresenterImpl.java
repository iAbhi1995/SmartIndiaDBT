package com.smartindia.hackathon.biotechnology.ResearchPaper.Presenter;

import com.smartindia.hackathon.biotechnology.ResearchPaper.Model.Data.ResearchPaperData;
import com.smartindia.hackathon.biotechnology.ResearchPaper.Model.ResearchPaperProvider;
import com.smartindia.hackathon.biotechnology.ResearchPaper.ResearchPaperCallback;
import com.smartindia.hackathon.biotechnology.ResearchPaper.View.ResearchPaperView;

public class ResearchPresenterImpl implements ResearchPresenter {
    private ResearchPaperView researchPaperView;
    private ResearchPaperProvider paperProvider;

    public ResearchPresenterImpl(ResearchPaperView researchPaperView, ResearchPaperProvider paperProvider) {
        this.researchPaperView = researchPaperView;

        this.paperProvider = paperProvider;
    }


    @Override
    public void requestResearchPaper(String access_token, String id) {
        researchPaperView.showProgressBar(true);
        paperProvider.requestResearchPaper(access_token, id, new ResearchPaperCallback() {
            @Override
            public void onSuccess(ResearchPaperData body) {
                if(body.isSuccess())
                {
                    researchPaperView.showProgressBar(false);
                    researchPaperView.showResearchPaper(body);

                }
                else
                {
                    researchPaperView.showProgressBar(false);
                    researchPaperView.showMessage(body.getMessage());
                }
            }
            @Override
            public void onFailure() {
                researchPaperView.showProgressBar(false);
                researchPaperView.showMessage("Something went wrong! Please try again");
            }
        });
    }
}
