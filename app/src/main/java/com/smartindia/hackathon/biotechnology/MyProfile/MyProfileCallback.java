package com.smartindia.hackathon.biotechnology.MyProfile;

import com.smartindia.hackathon.biotechnology.MyProfile.Model.Data.MyProfileData;
public interface MyProfileCallback {
    void onSuccess(MyProfileData myProfileData);
    void onFailure(String error);;
}
