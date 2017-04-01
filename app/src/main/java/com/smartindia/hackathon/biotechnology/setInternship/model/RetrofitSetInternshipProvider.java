package com.smartindia.hackathon.biotechnology.setInternship.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smartindia.hackathon.biotechnology.helper.Urls;
import com.smartindia.hackathon.biotechnology.setInternship.SetInternshipCallBack;
import com.smartindia.hackathon.biotechnology.setInternship.api.SetInternshipApi;
import com.smartindia.hackathon.biotechnology.setInternship.model.data.SetInternshipData;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aman on 29/3/17.
 */

public class RetrofitSetInternshipProvider implements SetInternshipProvider{
    public SetInternshipApi setInternshipApi;

    public RetrofitSetInternshipProvider() {


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

        setInternshipApi=retrofit.create(SetInternshipApi.class);
    }



    @Override
    public void requestIntern(String token, String company,String location,String date,String duration,String stipend,String applyBy,String aboutCompany,String aboutInternship,
                              String no,String perk,String apply, final SetInternshipCallBack setInternshipCallBack) {

        Call<SetInternshipData> call=setInternshipApi.getIntern(token, location,date, duration, stipend, applyBy,  aboutInternship,
                no,perk, apply);
        call.enqueue(new Callback<SetInternshipData>() {
            @Override
            public void onResponse(Call<SetInternshipData> call, Response<SetInternshipData> response) {
                setInternshipCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<SetInternshipData> call, Throwable t) {
                        setInternshipCallBack.onFailure();
                t.printStackTrace();
            }
        });

    }
}
