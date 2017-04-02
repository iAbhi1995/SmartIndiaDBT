package com.smartindia.hackathon.biotechnology.SurveyViewerInstitute.Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smartindia.hackathon.biotechnology.SurveyViewerInstitute.Api.SurveyViewerApi;
import com.smartindia.hackathon.biotechnology.SurveyViewerInstitute.Model.Data.ResultData;
import com.smartindia.hackathon.biotechnology.SurveyViewerInstitute.SurveyViewerCallback;
import com.smartindia.hackathon.biotechnology.helper.Urls;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSurveyProvider implements SurveyViewerProvider {


    private final Retrofit retrofit;

    public RetrofitSurveyProvider() {
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
    public void requestSurveyResult(String access_token, final SurveyViewerCallback surveyViewerCallback) {
        SurveyViewerApi surveyViewerApi = retrofit.create(SurveyViewerApi.class);
        Call<ResultData> call = surveyViewerApi.requestSurveyResult(access_token);
        call.enqueue(new Callback<ResultData>() {
            @Override
            public void onResponse(Call<ResultData> call, Response<ResultData> response) {
                surveyViewerCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ResultData> call, Throwable throwable) {
                throwable.printStackTrace();
                surveyViewerCallback.onFailure();
            }
        });
    }
}
