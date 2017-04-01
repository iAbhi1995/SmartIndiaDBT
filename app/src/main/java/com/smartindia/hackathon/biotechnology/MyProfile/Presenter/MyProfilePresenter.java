package com.smartindia.hackathon.biotechnology.MyProfile.Presenter;

/**
 * Created by Abhishek on 28-03-2017.
 */

public interface MyProfilePresenter {
    void requestUpload(String access_token,String keyType,String file_image,String file_pdf,String user_institution,String user_skills,String user_place,String user_currentyear,String user_qualification,String user_experience);

}
