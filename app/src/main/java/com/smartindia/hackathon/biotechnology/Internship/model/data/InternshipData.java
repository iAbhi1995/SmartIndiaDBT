package com.smartindia.hackathon.biotechnology.Internship.model.data;

import java.util.List;

/**
 * Created by aman on 27/3/17.
 */

public class InternshipData {
    private boolean success;
    private String message;
    List<InternshipCollegeData> internshipCollegeData;
    List<InternshipTopicData> internshipTopicData;

    List<InternshipCityData> internshipCityData;
    List<InternshipItemData> internshipItemDataList;

    public InternshipData(boolean success, String message, List<InternshipCollegeData> internshipCollegeData,
                          List<InternshipTopicData> internshipTopicData, List<InternshipCityData> internshipCityData,
                          List<InternshipItemData> internshipItemDataList) {
        this.success = success;
        this.message = message;
        this.internshipCollegeData = internshipCollegeData;
        this.internshipTopicData = internshipTopicData;
        this.internshipCityData = internshipCityData;
        this.internshipItemDataList = internshipItemDataList;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<InternshipCollegeData> getInternshipCollegeData() {
        return internshipCollegeData;
    }

    public void setInternshipCollegeData(List<InternshipCollegeData> internshipCollegeData) {
        this.internshipCollegeData = internshipCollegeData;
    }

    public List<InternshipTopicData> getInternshipTopicData() {
        return internshipTopicData;
    }

    public void setInternshipTopicData(List<InternshipTopicData> internshipTopicData) {
        this.internshipTopicData = internshipTopicData;
    }

    public List<InternshipCityData> getInternshipCityData() {
        return internshipCityData;
    }

    public void setInternshipCityData(List<InternshipCityData> internshipCityData) {
        this.internshipCityData = internshipCityData;
    }

    public List<InternshipItemData> getInternshipItemDataList() {
        return internshipItemDataList;
    }

    public void setInternshipItemDataList(List<InternshipItemData> internshipItemDataList) {
        this.internshipItemDataList = internshipItemDataList;
    }
}
