package com.smartindia.hackathon.biotechnology.SurveyUpload.API;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by ayush on 28-03-2017.
 */

public interface SurveyApi {
        @Multipart
        @POST("upload")
        Call<ResponseBody> upload(
                @Part("survey_title") RequestBody survey_title,
                @Part("description") RequestBody description,
                @Part("survey_scale") RequestBody survey_scale,
                @Part("survey_question1") RequestBody survey_question1,
                @Part("survey_question2") RequestBody survey_question2,
                @Part("survey_question3") RequestBody survey_question3,
                @Part("survey_question4") RequestBody survey_question4,
                @Part MultipartBody.Part file
        );
}
