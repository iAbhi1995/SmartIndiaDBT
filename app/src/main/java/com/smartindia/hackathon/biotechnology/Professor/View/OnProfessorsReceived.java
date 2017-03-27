package com.smartindia.hackathon.biotechnology.Professor.View;

import com.smartindia.hackathon.biotechnology.Professor.Model.Data.Professor_details;

/**
 * Created by ayush on 27-03-2017.
 */

public interface OnProfessorsReceived {
    void onSuccess(Professor_details professor_details);
    void onFailure();
}
