package com.smartindia.hackathon.biotechnology.ResearchPaper.Model;

import com.smartindia.hackathon.biotechnology.ResearchPaper.ResearchPaperCallback;

public interface ResearchPaperProvider {
    void requestResearchPaper(String access_token, String id, ResearchPaperCallback paperCallback);

}
