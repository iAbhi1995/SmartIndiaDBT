package com.smartindia.hackathon.biotechnology.MyProfile.Model;

import com.smartindia.hackathon.biotechnology.MyProfile.MyProfileCallback;

public interface MyProfileProvider {
    void requestUpload( String file_image,String file_pdf,String user_institution,String user_skills,String user_place,String user_currentyear,String user_qualification,String user_experience, MyProfileCallback myProfileCallback);
}