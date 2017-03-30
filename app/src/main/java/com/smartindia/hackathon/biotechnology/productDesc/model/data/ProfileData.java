package com.smartindia.hackathon.biotechnology.productDesc.model.data;

/**
 * Created by aman on 29/3/17.
 */

public class ProfileData {

    private String name;
    private String email;
    private String institution;
    private String skills;
    private String place;
    private String degree;
    private String experience;
    private String resumeLink;
    private String imageLink;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getResumeLink() {
        return resumeLink;
    }

    public void setResumeLink(String resumeLink) {
        this.resumeLink = resumeLink;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public ProfileData(String name, String email, String institution, String skills, String place, String degree, String experience, String resumeLink, String imageLink) {

        this.name = name;
        this.email = email;
        this.institution = institution;
        this.skills = skills;
        this.place = place;
        this.degree = degree;
        this.experience = experience;
        this.resumeLink = resumeLink;
        this.imageLink = imageLink;
    }
}
