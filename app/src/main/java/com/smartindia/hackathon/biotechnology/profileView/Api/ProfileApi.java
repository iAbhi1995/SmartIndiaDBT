package com.smartindia.hackathon.biotechnology.profileView.Api;

import com.smartindia.hackathon.biotechnology.helper.Urls;
import com.smartindia.hackathon.biotechnology.profileView.Model.Data.ProfileData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ProfileApi {
    @GET(Urls.PROFILE_VIEW)
    Call<ProfileData> requestProfile(@Query("access_token") String access_token,
                                     @Query("id") String id);
}