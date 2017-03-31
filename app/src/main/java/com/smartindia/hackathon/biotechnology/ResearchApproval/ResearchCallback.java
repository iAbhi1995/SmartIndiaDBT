package com.smartindia.hackathon.biotechnology.ResearchApproval;

import com.smartindia.hackathon.biotechnology.ResearchApproval.Model.Data.ResearchData;

public interface ResearchCallback {

    void onSuccess(ResearchData body);

    void onFailure();
}
