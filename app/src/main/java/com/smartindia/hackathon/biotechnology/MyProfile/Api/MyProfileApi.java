package com.smartindia.hackathon.biotechnology.MyProfile.Api;

import android.util.Log;

import com.smartindia.hackathon.biotechnology.MyProfile.Model.Data.MyProfileData;
import com.smartindia.hackathon.biotechnology.helper.Urls;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
public interface MyProfileApi {
    @Multipart
    @POST(Urls.PROFILE_UPLOAD)
    Call<MyProfileData> upload(
            @Part("access_token") RequestBody access_token,
            @Part("key_type") RequestBody keyType,
            @Part("user_institution") RequestBody user_institution,
            @Part("user_skills") RequestBody user_skills,
            @Part("user_place") RequestBody user_place,
            @Part("year") RequestBody user_currentyear,
            @Part("user_qualification") RequestBody user_qualification,
            @Part("user_experience") RequestBody user_experience,
            @Part MultipartBody.Part file
    );
}