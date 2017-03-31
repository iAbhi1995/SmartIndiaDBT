package com.smartindia.hackathon.biotechnology.ResearchApproval.Model;

import com.smartindia.hackathon.biotechnology.ResearchApproval.ResearchApprovalCallback;
import com.smartindia.hackathon.biotechnology.ResearchApproval.ResearchCallback;

/**
 * Created by Abhishek on 30-03-2017.
 */

public interface ResearchApprovalProvider {
    void requestResearch(String access_token, ResearchCallback researchCallback);
    void requestResearchApproval(String instituteId, String studentId, String action, ResearchApprovalCallback approvalCallback);
}
