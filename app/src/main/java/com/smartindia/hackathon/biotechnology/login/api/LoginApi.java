package com.smartindia.hackathon.biotechnology.login.api;

import com.smartindia.hackathon.biotechnology.helper.Urls;
import com.smartindia.hackathon.biotechnology.login.model.data.LoginData;
import com.smartindia.hackathon.biotechnology.login.model.data.OTPdata;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Abhishek on 28-03-2017.
 */

public interface LoginApi {


    @GET(Urls.Login)
    Call<LoginData> requestLogin(@Query("name") String name,
                                 @Query("email") String email,
                                 @Query("user_type") String user_type);

    @GET(Urls.OTP)
    Call<OTPdata> requestOtp(@Query("otp") String otp);


}
