package com.smartindia.hackathon.biotechnology.MyProfile;

import com.smartindia.hackathon.biotechnology.MyProfile.Model.Data.MyProfileData;
import com.smartindia.hackathon.biotechnology.MyProfile.Model.Data.PDFuploadResponse;

/**
 * Created by Abhishek on 27-03-2017.
 */

public interface MyProfileCallback {

    void onSuccess(MyProfileData myProfileData);
    void onFailure(String s);

    void onSuccessPDF(PDFuploadResponse pdFuploadResponse);
    void onFailurePDF();

}