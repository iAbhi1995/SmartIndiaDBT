package com.smartindia.hackathon.biotechnology.MyProfile.Presenter;

/**
 * Created by Abhishek on 28-03-2017.
 */

public interface MyProfilePresenter {

    void requestSkills();

    void requestMyProfile(String uid,
                          String name, String college,
                          String place, String emailId, String phoneNo);

}
