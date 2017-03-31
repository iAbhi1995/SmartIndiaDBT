package com.smartindia.hackathon.biotechnology.applyInternship;

import com.smartindia.hackathon.biotechnology.applyInternship.Model.Data.ApplyInternData;

/**
 * Created by Abhishek on 30-03-2017.
 */

public interface ApplyInternshipCallback {

    void onSuccess(ApplyInternData applyInternData);

    void onFailure();
}
