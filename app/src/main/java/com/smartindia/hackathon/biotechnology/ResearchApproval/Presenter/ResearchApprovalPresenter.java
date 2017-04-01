package com.smartindia.hackathon.biotechnology.ResearchApproval.Presenter;

import com.smartindia.hackathon.biotechnology.ResearchApproval.Model.RetrofitRsrchApprvlProvider;
import com.smartindia.hackathon.biotechnology.ResearchApproval.View.ResearchApprovalApprovalFragment;

/**
 * Created by Abhishek on 30-03-2017.
 */

public interface ResearchApprovalPresenter
{
    void requestResearch(String access_token);
    void requestResearchApproval(String research_id,String student_id,String action);
}
