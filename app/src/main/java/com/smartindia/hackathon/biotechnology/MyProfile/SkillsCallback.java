package com.smartindia.hackathon.biotechnology.MyProfile;

import com.smartindia.hackathon.biotechnology.MyProfile.Model.Data.SkillsData;

/**
 * Created by Abhishek on 28-03-2017.
 */

public interface SkillsCallback {
    void onSuccess(SkillsData skillsData);
    void onFailure();
}
