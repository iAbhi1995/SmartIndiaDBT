package com.smartindia.hackathon.biotechnology.ResearchApproval.Model.Data;

public class ResearchDataDetails
{
    private String researchName,stuName,stuEmail,researchId,stuId;

    public ResearchDataDetails(String researchName, String stuName, String stuEmail, String researchId, String stuId) {
        this.researchName = researchName;
        this.stuName = stuName;
        this.stuEmail = stuEmail;
        this.researchId = researchId;
        this.stuId = stuId;
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
}