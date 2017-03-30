package com.smartindia.hackathon.biotechnology.SurveyFilling.Model.Data;

/**
 * Created by Abhishek on 29-03-2017.
 */

public class SurveyData {
    private String title,description,ques1,ques2,ques3,ques4;
    private boolean success;
    public SurveyData(String title, String description, String ques1, String ques2, String ques3, String ques4, boolean success) {
        this.title = title;
        this.description = description;
        this.ques1 = ques1;
        this.ques2 = ques2;
        this.ques3 = ques3;
        this.ques4 = ques4;
        this.success = success;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getQues1() {
        return ques1;
    }

    public String getQues2() {
        return ques2;
    }

    public String getQues3() {
        return ques3;
    }

    public String getQues4() {
        return ques4;
    }

    public boolean isSuccess() {
        return success;
    }
}