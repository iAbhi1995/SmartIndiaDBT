package com.smartindia.hackathon.biotechnology.Internship;

import com.smartindia.hackathon.biotechnology.Internship.model.data.InternshipCityData;
import com.smartindia.hackathon.biotechnology.Internship.model.data.InternshipData;

/**
 * Created by aman on 27/3/17.
 */

public interface InternshipCallBack {


    void onSuccess(InternshipData internshipData);
    void onFailure();
}
