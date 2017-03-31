package com.smartindia.hackathon.biotechnology.login.api;

import com.smartindia.hackathon.biotechnology.helper.Urls;
import com.smartindia.hackathon.biotechnology.login.model.data.LoginData;
import com.smartindia.hackathon.biotechnology.login.model.data.ProfLogInData;
import com.smartindia.hackathon.biotechnology.login.model.data.SignUpResultData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface LoginApi {

    @GET(Urls.Login)
    Call<LoginData> requestLogin(@Query("name") String name,
                                 @Query("email") String email,
                                 @Query("id") String id);


    @POST(Urls.PROFESSOR_SIGN_UP)
    Call<SignUpResultData> requestSignUp(@Query("name") String name,
                                         @Query("email") String email);

    @POST(Urls.PROFESSOR_LOGIN)
    Call<ProfLogInData> requestProfLogin(@Query("email") String email,
                                         @Query("pass") String password);
}
