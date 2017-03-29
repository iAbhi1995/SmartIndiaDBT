package com.smartindia.hackathon.biotechnology.MyProfile.view;

import com.smartindia.hackathon.biotechnology.MyProfile.Model.Data.SkillsData;

/**
 * Created by Abhishek on 27-03-2017.
 */

public interface MyProfileView{

    void showMessage(String message);
    void showLoading(boolean show);

    void onSkillsReceived(SkillsData skillsData);
}
