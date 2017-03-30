package com.smartindia.hackathon.biotechnology.login.model.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smartindia.hackathon.biotechnology.helper.Urls;
import com.smartindia.hackathon.biotechnology.login.OTPCallBack;
import com.smartindia.hackathon.biotechnology.login.api.LoginApi;
import com.smartindia.hackathon.biotechnology.login.model.OTPProvider;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class RetrofitOTPProvider implements OTPProvider {
    private Retrofit retrofit;
    private LoginApi loginApi;

    @Override
    public void requestOtp(String otp, final OTPCallBack otpCallBack) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(Urls.Base_Url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
        loginApi = retrofit.create(LoginApi.class);
        Call<OTPdata> call = loginApi.requestOtp(otp);
        call.enqueue(new Callback<OTPdata>() {
            @Override
            public void onResponse(Call<OTPdata> call, Response<OTPdata> response) {
                otpCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<OTPdata> call, Throwable t) {
                otpCallBack.onFailure();
                t.printStackTrace();
            }
        });
    }
}