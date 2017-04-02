package com.smartindia.hackathon.biotechnology.ResearchPaper;

import com.smartindia.hackathon.biotechnology.ResearchPaper.Model.Data.ResearchPaperData;

public interface ResearchPaperCallback {
    void onSuccess(ResearchPaperData body);

    void onFailure();
}
