package com.smartindia.hackathon.biotechnology.login.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smartindia.hackathon.biotechnology.helper.Urls;
import com.smartindia.hackathon.biotechnology.login.LoginCallBack;
import com.smartindia.hackathon.biotechnology.login.api.LoginApi;
import com.smartindia.hackathon.biotechnology.login.model.data.LoginData;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Abhishek on 28-03-2017.
 */


public class RetrofitLoginProvider implements LoginProvider {

    private LoginApi loginApi;
    private Retrofit retrofit;

    @Override
    public void requestLogin( String name, String email,String user_type,final LoginCallBack loginCallBack) {
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
        Call<LoginData> call = loginApi.requestLogin(name,email,user_type);
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
}
