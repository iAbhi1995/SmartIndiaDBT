package com.smartindia.hackathon.biotechnology.setInternship;

import com.smartindia.hackathon.biotechnology.setInternship.model.data.SetInternshipData;

/**
 * Created by aman on 29/3/17.
 */

public interface SetInternshipCallBack {
    void onSuccess(SetInternshipData setInternshipData);
    void onFailure();
}
