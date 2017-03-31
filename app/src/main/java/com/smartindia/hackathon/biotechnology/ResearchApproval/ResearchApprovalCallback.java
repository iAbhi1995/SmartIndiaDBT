package com.smartindia.hackathon.biotechnology.ResearchApproval;

import com.smartindia.hackathon.biotechnology.ResearchApproval.Model.Data.ResearchApprovalData;

/**
 * Created by Abhishek on 30-03-2017.
 */

public interface ResearchApprovalCallback {
    void onSuccess(ResearchApprovalData body);

    void onFailure();
}
