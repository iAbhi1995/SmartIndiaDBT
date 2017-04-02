package com.smartindia.hackathon.biotechnology.BiotechPark.Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smartindia.hackathon.biotechnology.BiotechPark.API.BiotechParkApi;
import com.smartindia.hackathon.biotechnology.BiotechPark.BiotechParkCallback;
import com.smartindia.hackathon.biotechnology.BiotechPark.Model.Data.BiotechParkData;
import com.smartindia.hackathon.biotechnology.helper.Urls;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class RetrofitBiotechParkProvider implements BiotechParkProvider{
    private BiotechParkApi biotechParkApi;

    public RetrofitBiotechParkProvider() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).connectTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES).build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        biotechParkApi=retrofit.create(BiotechParkApi.class);
    }

    @Override
    public void getBiotechPark(String type, String id, final BiotechParkCallback biotechParkCallback) {
        Call<BiotechParkData> call=biotechParkApi.getBiotechPark(type,id);
        call.enqueue(new Callback<BiotechParkData>() {
            @Override
            public void onResponse(Call<BiotechParkData> call, Response<BiotechParkData> response) {
                biotechParkCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<BiotechParkData> call, Throwable t) {
                biotechParkCallback.onFailure();
                t.printStackTrace();
            }
        });
    }
}