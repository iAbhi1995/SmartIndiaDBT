package com.smartindia.hackathon.biotechnology.SurveyFilling.Api;

import com.smartindia.hackathon.biotechnology.SurveyFilling.Model.Data.SurveyData;
import com.smartindia.hackathon.biotechnology.SurveyFilling.Model.Data.SurveyResponse;
import com.smartindia.hackathon.biotechnology.helper.Urls;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface SurveyApi {

    @GET(Urls.GETTING_SURVEY)
    Call<SurveyData> requestSurvey(@Field("id") String id,
                                   @Field("user") String type, @Field("access_token") String access_token);

    @POST(Urls.POSTING_SURVEY)
    Call<SurveyResponse> requestSurveyPost(@Field("id") String id,
                                           @Field("user") String type, @Field("access_token") String access_token, @Field("answer1") String answer1,
                                           @Field("answer2") String answer2, @Field("answer3") String answer3, @Field("answer4") String answer4);


}
