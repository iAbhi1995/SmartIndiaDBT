package com.smartindia.hackathon.biotechnology.Internship.view;

import com.smartindia.hackathon.biotechnology.Internship.model.data.InternshipCityData;
import com.smartindia.hackathon.biotechnology.Internship.model.data.InternshipCollegeData;
import com.smartindia.hackathon.biotechnology.Internship.model.data.InternshipData;
import com.smartindia.hackathon.biotechnology.Internship.model.data.InternshipTopicData;
import com.smartindia.hackathon.biotechnology.helper.SharedPrefs;

/**
 * Created by aman on 27/3/17.
 */

public interface InternshipView {


    void showError(String message);
   // void showDialog();    //it will be used after wards after consulting from aman bhai
    //List-Spinners

    void showSpinnerCity(InternshipData internshipData);
    void showSpinnerCollege(InternshipData internshipData);
    void showSpinnerTopic(InternshipData internshipData);
    void check(InternshipData internshipData);




}
