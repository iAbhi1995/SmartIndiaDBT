package com.smartindia.hackathon.biotechnology.InstituteFeedBackForm.Api;


import com.smartindia.hackathon.biotechnology.InstituteFeedBackForm.Model.Data.FeedbackQues;
import com.smartindia.hackathon.biotechnology.InstituteFeedBackForm.Model.Data.FeedbackSubmit;
import com.smartindia.hackathon.biotechnology.helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FeedbackApi {


    @GET(Urls.FEEDBACK_QUES)
    Call<FeedbackQues> requestFeedbackQues();


    @GET(Urls.FEEDBACK_SUBMIT)
    Call<FeedbackSubmit> requestSubmitFeedback(@Query("inst_id") String institute_id ,
                                       @Query("ans1") String answer1,@Query("ans2") String answer2,@Query("ans3") String answer3,
                                               @Query("ans4") String answer4,@Query("ans5") String answer5);
}