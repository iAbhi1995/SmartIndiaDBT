package com.smartindia.hackathon.biotechnology.Professor.Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smartindia.hackathon.biotechnology.helper.Urls;
import com.smartindia.hackathon.biotechnology.Professor.ProfessorCallBack;
import com.smartindia.hackathon.biotechnology.Professor.API.ProfessorApi;
import com.smartindia.hackathon.biotechnology.Professor.Model.ProfessorProvider;
import com.smartindia.hackathon.biotechnology.Professor.Model.Data.ProfessorData;

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

public class RetrofitProfessorProvider implements ProfessorProvider {

    public ProfessorApi professorApi;

    public RetrofitProfessorProvider() {

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

        professorApi = retrofit.create(ProfessorApi.class);

    }


    @Override
    public void requestProfessor(String token, String type,String city,String topic, final ProfessorCallBack professorCallBack) {

        Call<ProfessorData> call = professorApi.getProfessor(token, type,city,topic);
        call.enqueue(new Callback<ProfessorData>() {
            @Override
            public void onResponse(Call<ProfessorData> call, Response<ProfessorData> response) {
                professorCallBack.onSuccess(response.body());


            }

            @Override
            public void onFailure(Call<ProfessorData> call, Throwable t) {

                professorCallBack.onFailure();
                t.printStackTrace();


            }
        });


    }
}
