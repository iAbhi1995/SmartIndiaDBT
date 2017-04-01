package com.smartindia.hackathon.biotechnology.InstituteFeedBackForm.Model.Data;

public class FeedbackQues {
    private String message,ques1,ques2,ques3,ques4;
    private boolean success;

    public FeedbackQues(String message, String ques1, String ques2, String ques3, String ques4, boolean success) {
        this.message = message;
        this.ques1 = ques1;
        this.ques2 = ques2;
        this.ques3 = ques3;
        this.ques4 = ques4;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
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

}