package com.smartindia.hackathon.biotechnology.applyInternship;

import com.smartindia.hackathon.biotechnology.applyInternship.Model.Data.GetInternshipData;


public interface GetInternshipCallback {
    void onSuccess(GetInternshipData getInternshipData);
    void onFailure();
}
