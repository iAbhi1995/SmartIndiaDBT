package com.smartindia.hackathon.biotechnology.MyProfile.Model;

import com.smartindia.hackathon.biotechnology.MyProfile.SkillsCallback;

/**
 * Created by Abhishek on 28-03-2017.
 */

public interface SkillsProvider {
    void requestSkills(SkillsCallback skillCallBack);
}
