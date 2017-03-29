package com.smartindia.hackathon.biotechnology.MyProfile.Model;

import com.smartindia.hackathon.biotechnology.MyProfile.MyProfileCallback;

/**
 * Created by Abhishek on 27-03-2017.
 */

public interface MyProfileProvider {
    void requestMyProfile( String uid,
                           String name,String college,
                           String place,String emailId,String phoneNo, MyProfileCallback myProfileCallback);
    void requestPDFUpload(String mediaPath, MyProfileCallback myProfileCallback);
}