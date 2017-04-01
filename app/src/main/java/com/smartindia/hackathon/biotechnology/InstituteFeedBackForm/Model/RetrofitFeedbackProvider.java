package com.smartindia.hackathon.biotechnology.InstituteFeedBackForm.Model;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smartindia.hackathon.biotechnology.InstituteFeedBackForm.Api.FeedbackApi;
import com.smartindia.hackathon.biotechnology.InstituteFeedBackForm.FeedbackPostCallback;
import com.smartindia.hackathon.biotechnology.InstituteFeedBackForm.FeedbackQuesCallback;
import com.smartindia.hackathon.biotechnology.InstituteFeedBackForm.Model.Data.FeedbackQues;
import com.smartindia.hackathon.biotechnology.InstituteFeedBackForm.Model.Data.FeedbackSubmit;
import com.smartindia.hackathon.biotechnology.helper.Urls;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitFeedbackProvider implements FeedbackProvider {
    private final Retrofit retrofit;
    private FeedbackApi feedbackApi;

    public RetrofitFeedbackProvider() {
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
    public void requestFeedbackQues(final FeedbackQuesCallback quesCallback) {
        feedbackApi = retrofit.create(FeedbackApi.class);
        Call<FeedbackQues> call = feedbackApi.requestFeedbackQues();

        call.enqueue(new Callback<FeedbackQues>() {
            @Override
            public void onResponse(Call<FeedbackQues> call, Response<FeedbackQues> response) {
                quesCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<FeedbackQues> call, Throwable t) {
                quesCallback.onFailure();
                t.printStackTrace();
            }
        });
    }

    @Override
    public void requestSubmitFeedback(String instId, String answer1, String answer2, String answer3, String answer4, String answer5, final FeedbackPostCallback postCallback) {
        feedbackApi = retrofit.create(FeedbackApi.class);
        Call<FeedbackSubmit> call = feedbackApi.requestSubmitFeedback(instId, answer1, answer2, answer3, answer4, answer5);

        call.enqueue(new Callback<FeedbackSubmit>() {
            @Override
            public void onResponse(Call<FeedbackSubmit> call, Response<FeedbackSubmit> response) {
                postCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<FeedbackSubmit> call, Throwable t) {
                postCallback.onFailure();
                t.printStackTrace();
            }
        });
    }
}