package com.smartindia.hackathon.biotechnology.MyProfile.Model.Data;

import java.util.List;

/**
 * Created by Abhishek on 28-03-2017.
 */

public class SkillsData {
    private List<String> skills;
    private boolean success;
    public SkillsData(List<String> skills, boolean success) {
        this.skills = skills;
        this.success = success;
    }

    public List<String> getSkills() {
        return skills;
    }

    public boolean isSuccess() {
        return success;
    }
}
