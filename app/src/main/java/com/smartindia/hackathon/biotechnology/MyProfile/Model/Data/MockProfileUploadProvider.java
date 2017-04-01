package com.smartindia.hackathon.biotechnology.MyProfile.Model.Data;

import com.smartindia.hackathon.biotechnology.MyProfile.Model.MyProfileProvider;
import com.smartindia.hackathon.biotechnology.MyProfile.MyProfileCallback;

/**
 * Created by ayush on 01-04-2017.
 */

public class MockProfileUploadProvider implements MyProfileProvider {
    @Override
    public void requestUpload(String access_token, String keyType, String file_image, String file_pdf, String user_institution, String user_skills, String user_place, String user_currentyear, String user_qualification, String user_experience, MyProfileCallback myProfileCallback) {
        MyProfileData myProfileData = new MyProfileData("Success",true);
        myProfileCallback.onSuccess(myProfileData);
    }
}
