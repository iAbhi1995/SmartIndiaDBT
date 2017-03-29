package com.smartindia.hackathon.biotechnology.MyProfile.Model.Data;

/**
 * Created by Abhishek on 26-03-2017.
 */
public class MyProfileData {
    private String uid;
    private String name;
    private String college;
    private String place;
    private String emailId;
    private String phoneNo;

    public MyProfileData(String uid, String name, String college, String place, String emailId, String phoneNo) {
        this.uid=uid;
        this.name=name;
        this.college = college;
        this.place = place;
        this.emailId = emailId;
        this.phoneNo = phoneNo;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmail_id(String email_id) {
        this.emailId = email_id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}