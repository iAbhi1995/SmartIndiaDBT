package com.smartindia.hackathon.biotechnology.MyProfile.Api;

import com.smartindia.hackathon.biotechnology.MyProfile.Model.Data.MyProfileData;
import com.smartindia.hackathon.biotechnology.helper.Urls;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by Abhishek on 26-03-2017.
 */

public interface MyProfileApi {


    @Multipart
    @POST("upload")
    Call<MyProfileData> upload(
            @Part("user_institution") RequestBody user_institution,
            @Part("user_skills") RequestBody user_skills,
            @Part("user_place") RequestBody user_place,
            @Part("user_currentyear") RequestBody user_currentyear,
            @Part("user_qualification") RequestBody user_qualification,
            @Part("user_experience") RequestBody user_experience,
            @Part MultipartBody.Part file_image,
            @Part MultipartBody.Part file_pdf

    );
}