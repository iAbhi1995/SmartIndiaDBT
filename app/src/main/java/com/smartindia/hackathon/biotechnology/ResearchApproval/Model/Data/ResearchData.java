package com.smartindia.hackathon.biotechnology.ResearchApproval.Model.Data;

import java.util.ArrayList;
import java.util.List;

public class ResearchData
{
    private boolean success;
    private String message;
    private List<ResearchDataDetails> researchDataDetailsList=new ArrayList<>();


    public ResearchData(boolean success, String message, List<ResearchDataDetails> researchDataDetailsList) {
        this.success = success;
        this.message = message;
        this.researchDataDetailsList = researchDataDetailsList;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public List<ResearchDataDetails> getResearchDataDetailsList() {
        return researchDataDetailsList;
    }
}