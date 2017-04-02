package com.smartindia.hackathon.biotechnology.ResearchPaper.Model;

import com.smartindia.hackathon.biotechnology.ResearchPaper.Model.Data.ResearchPaperData;
import com.smartindia.hackathon.biotechnology.ResearchPaper.ResearchPaperCallback;

/**
 * Created by ayush on 02-04-2017.
 */

public class MockResearchPaperProvider implements ResearchPaperProvider {
    @Override
    public void requestResearchPaper(String access_token, String id, ResearchPaperCallback researchPaperCallback) {
        ResearchPaperData researchPaperData = new ResearchPaperData(true,"Success","Hey Bro");
        researchPaperCallback.onSuccess(researchPaperData);
    }
}
