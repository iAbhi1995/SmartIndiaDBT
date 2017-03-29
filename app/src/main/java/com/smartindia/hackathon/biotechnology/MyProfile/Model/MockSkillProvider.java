package com.smartindia.hackathon.biotechnology.MyProfile.Model;

import android.os.Handler;

import com.smartindia.hackathon.biotechnology.MyProfile.Model.Data.SkillsData;
import com.smartindia.hackathon.biotechnology.MyProfile.SkillsCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abhishek on 28-03-2017.
 */

public class MockSkillProvider implements SkillsProvider{

    @Override
    public void requestSkills(final SkillsCallback skillsCallBack) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                skillsCallBack.onSuccess(getMockLoginData());
            }
        },500);
    }

    public SkillsData getMockLoginData()
    {
        List<String> skills=new ArrayList<>();
        skills.add("Genetics");
        skills.add("Molecular evolution");
        SkillsData skillsData = new SkillsData(skills,true);
        return  skillsData;
    }
}
