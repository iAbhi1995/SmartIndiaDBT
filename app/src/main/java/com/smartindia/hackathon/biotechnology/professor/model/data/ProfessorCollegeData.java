package com.smartindia.hackathon.biotechnology.Professor.Model.Data;

/**
 * Created by aman on 27/3/17.
 */

public class ProfessorCollegeData {

    private String college;
private String collegeId;

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }

    public ProfessorCollegeData(String college, String collegeId) {

        this.college = college;
        this.collegeId = collegeId;
    }
}
