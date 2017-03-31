package com.smartindia.hackathon.biotechnology.applyInternship.View;

import com.smartindia.hackathon.biotechnology.applyInternship.Model.Data.ApplyInternData;
import com.smartindia.hackathon.biotechnology.applyInternship.Model.Data.GetInternshipData;

public interface GetInternshipView {
    void showProgressBar(boolean b);
    void showMessage(String message);
    void ShowInternDetails(GetInternshipData getInternshipData);
    void SuccessfullApplication(ApplyInternData applyInternData);
}
