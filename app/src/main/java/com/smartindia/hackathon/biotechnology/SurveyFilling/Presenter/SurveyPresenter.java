package com.smartindia.hackathon.biotechnology.SurveyFilling.Presenter;

/**
 * Created by Abhishek on 29-03-2017.
 */

public interface SurveyPresenter {
   void requestSurvey(String id,String type,String access_token);

    void requestSurveyPost(String id,String type,String access_token,
                          String answer1,String answer2,String answer3,String answer4);
}
