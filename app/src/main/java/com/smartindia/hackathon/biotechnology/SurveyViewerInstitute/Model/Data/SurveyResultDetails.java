package com.smartindia.hackathon.biotechnology.SurveyViewerInstitute.Model.Data;

public class SurveyResultDetails {
    private String survey_id, survey_name, ques1, ques2, ques3, ques4, ans1, ans2, ans3, ans4;

    public SurveyResultDetails(String survey_id, String survey_name, String ques1, String ques2, String ques3,
                               String ques4, String ans1, String ans2, String ans3, String ans4) {
        this.survey_id = survey_id;
        this.survey_name = survey_name;
        this.ques1 = ques1;
        this.ques2 = ques2;
        this.ques3 = ques3;
        this.ques4 = ques4;
        this.ans1 = ans1;
        this.ans2 = ans2;
        this.ans3 = ans3;
        this.ans4 = ans4;
    }

    public String getSurvey_id() {
        return survey_id;
    }

    public String getSurvey_name() {
        return survey_name;
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

    public String getAns1() {
        return ans1;
    }

    public String getAns2() {
        return ans2;
    }

    public String getAns3() {
        return ans3;
    }

    public String getAns4() {
        return ans4;
    }
}
