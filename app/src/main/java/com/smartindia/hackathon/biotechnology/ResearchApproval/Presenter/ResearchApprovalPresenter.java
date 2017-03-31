package com.smartindia.hackathon.biotechnology.ResearchApproval.Presenter;

/**
 * Created by Abhishek on 30-03-2017.
 */

public interface ResearchApprovalPresenter
{
    void requestResearch(String access_token);
    void requestResearchApproval(String institute_id,String student_id,String action);


}
