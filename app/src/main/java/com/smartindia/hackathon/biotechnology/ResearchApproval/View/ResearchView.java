package com.smartindia.hackathon.biotechnology.ResearchApproval.View;


import com.smartindia.hackathon.biotechnology.ResearchApproval.Model.Data.ResearchData;

public interface ResearchView {

    void showProgressBar(boolean b);

    void showMessage(String message);

    void showRecyclerView(ResearchData researchData);
}
