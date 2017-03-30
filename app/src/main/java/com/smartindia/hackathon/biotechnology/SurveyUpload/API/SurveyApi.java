package com.smartindia.hackathon.biotechnology.SurveyUpload.API;

import com.smartindia.hackathon.biotechnology.SurveyUpload.Model.Data.SureveyUploadData;
import com.smartindia.hackathon.biotechnology.SurveyUpload.View.OnSurveyUploadCallBack;
import com.smartindia.hackathon.biotechnology.helper.Urls;

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
        @POST(Urls.SURVEY_UPLOAD)
        Call<SureveyUploadData> upload(
                @Part("access_token") RequestBody access_token,
                @Part("type") RequestBody type,
                @Part("title") RequestBody survey_title,
                @Part("description") RequestBody description,
                @Part("field") RequestBody survey_scale,
                @Part("ques1") RequestBody survey_question1,
                @Part("ques2") RequestBody survey_question2,
                @Part("ques3") RequestBody survey_question3,
                @Part("ques4") RequestBody survey_question4,
                @Part MultipartBody.Part file
        );
}
