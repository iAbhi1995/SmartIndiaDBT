package com.smartindia.hackathon.biotechnology.request.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smartindia.hackathon.biotechnology.helper.Urls;
import com.smartindia.hackathon.biotechnology.request.RequestCallBack;
import com.smartindia.hackathon.biotechnology.request.api.RequestApi;
import com.smartindia.hackathon.biotechnology.request.model.data.RequestData;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aman on 27/3/17.
 */

public class RetrofitRequestProvider implements RequestProvider{
    public RequestApi requestApi;

    public RetrofitRequestProvider(){


        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
requestApi = retrofit.create(RequestApi.class);
    }

    @Override
    public void requestAppStatus(String token, final RequestCallBack requestCallBack) {

        Call<RequestData>call=requestApi.getStatus(token);
        call.enqueue(new Callback<RequestData>() {
            @Override
            public void onResponse(Call<RequestData> call, Response<RequestData> response) {
                requestCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<RequestData> call, Throwable t) {

                requestCallBack.onFailure();
                t.printStackTrace();


            }
        });
    }
}



