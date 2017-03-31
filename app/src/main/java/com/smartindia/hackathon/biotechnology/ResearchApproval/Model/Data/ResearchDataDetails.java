package com.smartindia.hackathon.biotechnology.ResearchApproval.Model.Data;

public class ResearchDataDetails
{
    private String researchName,stuName,stuEmail,researchId,stuId;
    private boolean flag;

    public ResearchDataDetails(String researchName, String stuName, String stuEmail, String researchId, String stuId,boolean flag) {
        this.researchName = researchName;
        this.stuName = stuName;
        this.stuEmail = stuEmail;
        this.researchId = researchId;
        this.stuId = stuId;
        this.flag=flag;
    }

    public String getResearchName() {
        return researchName;
    }

    public String getStuName() {
        return stuName;
    }

    public String getStuEmail() {
        return stuEmail;
    }

    public String getResearchId() {
        return researchId;
    }

    public String getStuId() {
        return stuId;
    }

    public boolean isFlag() {
        return flag;
    }
}