package com.smartindia.hackathon.biotechnology.ResearchApproval.Model;

import android.os.Handler;
import android.util.Log;

import com.smartindia.hackathon.biotechnology.ResearchApproval.Model.Data.ResearchApprovalData;
import com.smartindia.hackathon.biotechnology.ResearchApproval.Model.Data.ResearchData;
import com.smartindia.hackathon.biotechnology.ResearchApproval.Model.Data.ResearchDataDetails;
import com.smartindia.hackathon.biotechnology.ResearchApproval.ResearchApprovalCallback;
import com.smartindia.hackathon.biotechnology.ResearchApproval.ResearchCallback;

import java.util.ArrayList;
import java.util.List;


public class MockProvider implements ResearchApprovalProvider {
    private ResearchData mockResearchData;
    private ResearchApprovalData mockResearchApprovalData;

    @Override
    public void requestResearch(String access_token, final ResearchCallback researchCallback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                researchCallback.onSuccess(getMockResearchData());
            }
        }, 500);
    }

    @Override
    public void requestResearchApproval(String instituteId, String studentId, String action, final ResearchApprovalCallback approvalCallback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                approvalCallback.onSuccess(getMockResearchApprovalData());
            }
        }, 500);
    }

    public ResearchData getMockResearchData() {
        ResearchDataDetails details = new ResearchDataDetails("Hybrid research", "Abhishek", "meabhi7@gmail.com", "0001", "Ae101", false);
        List<ResearchDataDetails> list = new ArrayList<>();
        for(int i=0;i<5;i++) {
            list.add(details);
            list.add(details);
            list.add(details);
        }
        mockResearchData = new ResearchData(true, "Success", list);
        return mockResearchData;
    }

    public ResearchApprovalData getMockResearchApprovalData() {
        mockResearchApprovalData =new ResearchApprovalData(true,"Success");
        return mockResearchApprovalData;
    }
}
