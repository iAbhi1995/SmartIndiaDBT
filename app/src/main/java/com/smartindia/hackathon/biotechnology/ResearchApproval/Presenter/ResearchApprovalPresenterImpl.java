package com.smartindia.hackathon.biotechnology.ResearchApproval.Presenter;

import com.smartindia.hackathon.biotechnology.ResearchApproval.Model.Data.ResearchApprovalData;
import com.smartindia.hackathon.biotechnology.ResearchApproval.Model.Data.ResearchData;
import com.smartindia.hackathon.biotechnology.ResearchApproval.Model.ResearchApprovalProvider;
import com.smartindia.hackathon.biotechnology.ResearchApproval.ResearchApprovalCallback;
import com.smartindia.hackathon.biotechnology.ResearchApproval.ResearchCallback;
import com.smartindia.hackathon.biotechnology.ResearchApproval.View.ResearchApprovalView;
import com.smartindia.hackathon.biotechnology.ResearchApproval.View.ResearchView;
import com.smartindia.hackathon.biotechnology.helper.SharedPrefs;

public class ResearchApprovalPresenterImpl implements ResearchApprovalPresenter {

    private ResearchApprovalProvider provider;
    private ResearchApprovalView researchApprovalView;
    private ResearchView researchView;

    public ResearchApprovalPresenterImpl(ResearchApprovalProvider provider, ResearchApprovalView researchApprovalView) {
        this.provider = provider;
        this.researchApprovalView = researchApprovalView;
    }
    public ResearchApprovalPresenterImpl(ResearchApprovalProvider provider, ResearchView researchView) {
        this.provider = provider;
        this.researchView = researchView;
    }

    @Override
    public void requestResearch(String access_token) {
       researchView.showProgressBar(true);
        provider.requestResearch(access_token, new ResearchCallback() {
            @Override
            public void onSuccess(ResearchData researchData) {
                if (researchData.isSuccess()) {
                    researchView.showProgressBar(false);
                    researchView.showRecyclerView(researchData);
                } else {
                   researchView.showProgressBar(false);
                    researchView.showMessage(researchData.getMessage());
                }
            }

            @Override
            public void onFailure() {
                researchView.showProgressBar(false);
                researchView.showMessage("Connection Error! Try Again");
            }
        });
    }

    @Override
    public void requestResearchApproval(final String institute_id, String student_id, final String action) {
        provider.requestResearchApproval(institute_id, student_id, action, new ResearchApprovalCallback() {
            @Override
            public void onSuccess(ResearchApprovalData approvalData) {
                if(approvalData.isSuccess()) {
                    if(approvalData.isSuccess()) {
                        if(action.equals("1"))
                        researchApprovalView.showMessage("Request Accepted");
                        else
                            researchApprovalView.showMessage("Request Rejected");
                       // requestResearch(institute_id);
                    }
                }
                else
                {
                    researchApprovalView.showMessage(approvalData.getMessage());
                }
            }
            @Override
            public void onFailure() {
                researchApprovalView.showMessage("Connection Error! Try Again");
            }
        });
       }
}