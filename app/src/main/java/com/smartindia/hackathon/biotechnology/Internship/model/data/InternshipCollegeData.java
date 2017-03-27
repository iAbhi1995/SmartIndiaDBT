package com.smartindia.hackathon.biotechnology.Internship.model.data;

/**
 * Created by aman on 27/3/17.
 */

public class InternshipCollegeData {



    private String college;
    private String CollegeId;

    public String getCollegeId() {
        return CollegeId;
    }

    public void setCollegeId(String collegeId) {
        CollegeId = collegeId;
    }

    public String getCollege() {
        return college;
    }

    public InternshipCollegeData(String college, String collegeId) {
        this.college = college;
        CollegeId = collegeId;
    }
}
