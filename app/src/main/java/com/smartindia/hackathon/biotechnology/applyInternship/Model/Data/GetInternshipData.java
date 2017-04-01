package com.smartindia.hackathon.biotechnology.applyInternship.Model.Data;

public class GetInternshipData {

    private String message,title,institute_name,location,startDate,duration,
    stipend,applyBy,whoCanApply,perks,internshipNumber,internshipDetail;
    private boolean success;

    public GetInternshipData(String message, String title, String institute_name,
                             String location, String startDate, String duration,
                             String stipend, String applyBy,
                             String whoCanApply, String perks, String internshipNumber, String internshipDetail, boolean success) {
        this.message = message;
        this.title = title;
        this.institute_name = institute_name;
        this.location = location;
        this.startDate = startDate;
        this.duration = duration;
        this.stipend = stipend;
        this.applyBy = applyBy;
//        this.aboutTheCompany = aboutTheCompany;
        this.whoCanApply = whoCanApply;
        this.perks = perks;
        this.internshipNumber = internshipNumber;
        this.internshipDetail = internshipDetail;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getTitle() {
        return title;
    }


    public String getLocation() {
        return location;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getDuration() {
        return duration;
    }

    public String getStipend() {
        return stipend;
    }

    public String getApplyBy() {
        return applyBy;
    }

    public String getWhoCanApply() {
        return whoCanApply;
    }

    public String getInternshipDetail() {
        return internshipDetail;
    }

    public String getInternshipNumber() {
        return internshipNumber;
    }

    public String getPerks() {
        return perks;
    }

    public String getInstitute_name() {
        return institute_name;
    }
}
