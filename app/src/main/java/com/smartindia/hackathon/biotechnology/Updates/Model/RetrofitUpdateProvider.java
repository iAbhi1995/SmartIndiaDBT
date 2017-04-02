package com.smartindia.hackathon.biotechnology.Updates.Model;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smartindia.hackathon.biotechnology.Updates.Api.UpdatesApi;
import com.smartindia.hackathon.biotechnology.Updates.Model.Data.UpdateData;
import com.smartindia.hackathon.biotechnology.Updates.UpdateCallback;
import com.smartindia.hackathon.biotechnology.helper.Urls;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUpdateProvider implements UpdateProvider {

    private final Retrofit retrofit;

    public RetrofitUpdateProvider() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
    }


    @Override
    public void requestUpdate(final UpdateCallback updateCallback) {
        UpdatesApi updatesApi = retrofit.create(UpdatesApi.class);
        Call<UpdateData> call = updatesApi.requestUpdate();
        call.enqueue(new Callback<UpdateData>() {
            @Override
            public void onResponse(Call<UpdateData> call, Response<UpdateData> response) {
                updateCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<UpdateData> call, Throwable t) {
                updateCallback.onFailure();
                t.printStackTrace();
            }

        });
    }
}