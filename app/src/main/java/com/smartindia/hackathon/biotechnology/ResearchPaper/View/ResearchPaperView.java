package com.smartindia.hackathon.biotechnology.ResearchPaper.View;

import com.smartindia.hackathon.biotechnology.ResearchPaper.Model.Data.ResearchPaperData;

public interface ResearchPaperView {
    void showResearchPaper(ResearchPaperData researchPaperData);

    void showProgressBar(boolean b);

    void showMessage(String s);
}
