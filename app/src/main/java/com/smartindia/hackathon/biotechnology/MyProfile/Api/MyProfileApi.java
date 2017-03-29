package com.smartindia.hackathon.biotechnology.MyProfile.Api;

import com.smartindia.hackathon.biotechnology.MyProfile.Model.Data.MyProfileData;
import com.smartindia.hackathon.biotechnology.MyProfile.Model.Data.PDFuploadResponse;
import com.smartindia.hackathon.biotechnology.MyProfile.Model.Data.SkillsData;
import com.smartindia.hackathon.biotechnology.helper.Urls;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by Abhishek on 26-03-2017.
 */

public interface MyProfileApi {

    @Multipart
    @POST(Urls.POSTING_RESUME_PDF)
    Call<PDFuploadResponse> uploadFile(@Part MultipartBody.Part file, @Part("file") RequestBody name);


    @POST(Urls.POSTING_MY_PROFILE)
    Call<MyProfileData> requestMyProfile(@Field("uid") String uid,
                                      @Field("name") String name, @Field("college") String college,
                                      @Field("place") String place,@Field("email_id") String emailId
                            ,@Field("phone_no") String phoneNo);

    @GET(Urls.GET_SKILLS)
    Call<SkillsData> requestSkills(/*what is to be sent*/);


}