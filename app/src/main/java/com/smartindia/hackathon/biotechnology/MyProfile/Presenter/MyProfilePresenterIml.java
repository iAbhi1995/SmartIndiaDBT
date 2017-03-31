package com.smartindia.hackathon.biotechnology.MyProfile.Presenter;

import com.smartindia.hackathon.biotechnology.MyProfile.Model.Data.MyProfileData;
import com.smartindia.hackathon.biotechnology.MyProfile.Model.MyProfileProvider;
import com.smartindia.hackathon.biotechnology.MyProfile.MyProfileCallback;
import com.smartindia.hackathon.biotechnology.MyProfile.view.MyProfileView;

/**
 * Created by Abhishek on 28-03-2017.
 */

public class MyProfilePresenterIml implements MyProfilePresenter {

    MyProfileView myProfileView;
    MyProfileProvider myProfileProvider;

    public MyProfilePresenterIml(MyProfileView myProfileView, MyProfileProvider myProfileProvider)
    {
        this.myProfileView = myProfileView;
        this.myProfileProvider = myProfileProvider;
    }

    @Override
    public void requestUpload(String file_image, String file_pdf, String user_institution, String user_skills, String user_place, String user_currentyear, String user_qualification, String user_experience) {
        myProfileView.showLoading(true);
        myProfileProvider.requestUpload(file_image,file_pdf,user_institution,user_skills,user_place,user_currentyear,user_qualification,user_experience, new MyProfileCallback() {
            @Override
            public void onSuccess(MyProfileData myProfileData) {
                if (myProfileData.isSuccess()) {
                    myProfileView.showLoading(false);
                    myProfileView.onMyProfileUploadVerified();
                } else {
                    myProfileView.showLoading(false);
                    myProfileView.showMessage(myProfileData.getMessage());

                }
            }

            @Override
            public void onFailure(String error) {
                myProfileView.showLoading(false);
                myProfileView.showMessage("Failed");
            }
        });
    }
}
