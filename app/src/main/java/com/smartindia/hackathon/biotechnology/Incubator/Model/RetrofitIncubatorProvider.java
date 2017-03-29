package com.smartindia.hackathon.biotechnology.Incubator.Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smartindia.hackathon.biotechnology.Incubator.API.IncubatorApi;
import com.smartindia.hackathon.biotechnology.Incubator.Model.Data.IncubatorData;
import com.smartindia.hackathon.biotechnology.Incubator.View.OnIncubatorsReceived;
import com.smartindia.hackathon.biotechnology.helper.Urls;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ayush on 28-03-2017.
 */

public class RetrofitIncubatorProvider implements IncubatorProvider{
    private IncubatorApi incubatorApi;

    public RetrofitIncubatorProvider() {
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
        incubatorApi=retrofit.create(IncubatorApi.class);
    }

    @Override
    public void getIncubators(String type,String id, final OnIncubatorsReceived onIncubatorReceived) {
        Call<IncubatorData> call=incubatorApi.getIncubators("","");
        call.enqueue(new Callback<IncubatorData>() {
            @Override
            public void onResponse(Call<IncubatorData> call, Response<IncubatorData> response) {
                onIncubatorReceived.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<IncubatorData> call, Throwable t) {
                onIncubatorReceived.onFailure();
                t.printStackTrace();
            }
        });
    }
}

