package com.smartindia.hackathon.biotechnology.profileView.Model.Data;


public class ProfileData {

    private String message, name, place, college, email, qualification, passingYear, skills, experience, type;
    private boolean success;

    public ProfileData(String message, String name, String place, String college, String email, String qualification, String passingYear, String skills, String experience, String type, boolean success) {
        this.message = message;
        this.name = name;
        this.place = place;
        this.college = college;
        this.email = email;
        this.qualification = qualification;
        this.passingYear = passingYear;
        this.skills = skills;
        this.experience = experience;
        this.type = type;
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }

    public String getPlace() {
        return place;
    }

    public String getCollege() {
        return college;
    }

    public String getEmail() {
        return email;
    }

    public String getQualification() {
        return qualification;
    }

    public String getPassingYear() {
        return passingYear;
    }

    public String getSkills() {
        return skills;
    }

    public String getExperience() {
        return experience;
    }

    public String getType() {
        return type;
    }
}
