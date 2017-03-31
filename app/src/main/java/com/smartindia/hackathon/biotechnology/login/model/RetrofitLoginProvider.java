package com.smartindia.hackathon.biotechnology.login.model;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smartindia.hackathon.biotechnology.helper.Urls;
import com.smartindia.hackathon.biotechnology.login.LoginCallBack;
import com.smartindia.hackathon.biotechnology.login.ProfLoginCallBack;
import com.smartindia.hackathon.biotechnology.login.SignUpCallBack;
import com.smartindia.hackathon.biotechnology.login.api.LoginApi;
import com.smartindia.hackathon.biotechnology.login.model.data.LoginData;
import com.smartindia.hackathon.biotechnology.login.model.data.ProfLogInData;
import com.smartindia.hackathon.biotechnology.login.model.data.SignUpResultData;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitLoginProvider implements LoginProvider {

    private LoginApi loginApi;
    private Retrofit retrofit;

    public RetrofitLoginProvider()
    {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().
                connectTimeout(120, java.util.concurrent.TimeUnit.SECONDS).
                readTimeout(120, java.util.concurrent.TimeUnit.SECONDS).
                writeTimeout(120, java.util.concurrent.TimeUnit.SECONDS).
                addInterceptor(interceptor).build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(Urls.Base_Url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
    }
    @Override
    public void requestLogin( String name, String email,String id,final LoginCallBack loginCallBack) {

        loginApi = retrofit.create(LoginApi.class);
        Call<LoginData> call = loginApi.requestLogin(name,email,id);

        call.enqueue(new Callback<LoginData>() {
            @Override
            public void onResponse(Call<LoginData> call, Response<LoginData> response) {
                loginCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<LoginData> call, Throwable t) {
                loginCallBack.onFailure();
                t.printStackTrace();
            }
        });

    }

    @Override
    public void requestSignUp(String name, String email, final SignUpCallBack signUpCallBack) {
        loginApi = retrofit.create(LoginApi.class);
        Call<SignUpResultData> call = loginApi.requestSignUp(name,email);

        call.enqueue(new Callback<SignUpResultData>() {
            @Override
            public void onResponse(Call<SignUpResultData> call, Response<SignUpResultData> response) {
                signUpCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<SignUpResultData> call, Throwable t) {
                t.printStackTrace();
                signUpCallBack.onFailure();

            }
        });
    }

    @Override
    public void requestProfLogin(String email, String password, final ProfLoginCallBack profLoginCallBack) {
        loginApi = retrofit.create(LoginApi.class);
        Call<ProfLogInData> call = loginApi.requestProfLogin(email,password);

        call.enqueue(new Callback<ProfLogInData>() {
            @Override
            public void onResponse(Call<ProfLogInData> call, Response<ProfLogInData> response) {
                profLoginCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ProfLogInData> call, Throwable t) {
                t.printStackTrace();
                profLoginCallBack.onFailure();
            }
        });
    }

    @Override
    public void handleBackButton() {

    }
}