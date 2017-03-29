package com.smartindia.hackathon.biotechnology.SurveyFilling.Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smartindia.hackathon.biotechnology.SurveyFilling.Api.SurveyApi;
import com.smartindia.hackathon.biotechnology.SurveyFilling.Model.Data.SurveyData;
import com.smartindia.hackathon.biotechnology.SurveyFilling.Model.Data.SurveyResponse;
import com.smartindia.hackathon.biotechnology.SurveyFilling.SurveyCallback;
import com.smartindia.hackathon.biotechnology.SurveyFilling.SurveyResponseCallback;
import com.smartindia.hackathon.biotechnology.helper.Urls;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSurveyProvider implements SurveyProvider {

    private final Retrofit retrofit;

    public RetrofitSurveyProvider() {
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
    }

    @Override
    public void requestSurvey(String id, String type, String access_token, final SurveyCallback surveyCallback) {
        SurveyApi surveyApi=retrofit.create(SurveyApi.class);
        Call<SurveyData> call = surveyApi.requestSurvey(id,type,access_token);
        call.enqueue(new Callback<SurveyData>() {
            @Override
            public void onResponse(Call<SurveyData> call, Response<SurveyData> response) {
                surveyCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<SurveyData> call, Throwable t) {
            t.printStackTrace();
                surveyCallback.onFailure();
            }
        });

    }

    @Override
    public void requestSurveyPost(String id, String type, String access_token, String answer1, String answer2, String answer3, String answer4, final SurveyResponseCallback responseCallback) {
        SurveyApi surveyApi=retrofit.create(SurveyApi.class);
        Call<SurveyResponse> call = surveyApi.requestSurveyPost(id,type,access_token,answer1,answer2,answer3,answer4);
        call.enqueue(new Callback<SurveyResponse>() {
            @Override
            public void onResponse(Call<SurveyResponse> call, Response<SurveyResponse> response) {
                responseCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<SurveyResponse> call, Throwable t) {
                t.printStackTrace();
                responseCallback.onFailure();

            }
            });
    }
}