package com.smartindia.hackathon.biotechnology.ResearchPaper.Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smartindia.hackathon.biotechnology.ResearchPaper.Api.ResearchPaperApi;
import com.smartindia.hackathon.biotechnology.ResearchPaper.Model.Data.ResearchPaperData;
import com.smartindia.hackathon.biotechnology.ResearchPaper.ResearchPaperCallback;
import com.smartindia.hackathon.biotechnology.helper.Urls;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitResearchPaperProvider implements ResearchPaperProvider {
    private final Retrofit retrofit;
    private ResearchPaperApi researchPaperApi;

    public RetrofitResearchPaperProvider() {
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
    public void requestResearchPaper(String access_token, String id, final ResearchPaperCallback paperCallback) {
        researchPaperApi = retrofit.create(ResearchPaperApi.class);
        Call<ResearchPaperData> call = researchPaperApi.requestResearch(access_token, id);
        call.enqueue(new Callback<ResearchPaperData>() {
            @Override
            public void onResponse(Call<ResearchPaperData> call, Response<ResearchPaperData> response) {
                paperCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ResearchPaperData> call, Throwable throwable) {
                paperCallback.onFailure();
                throwable.printStackTrace();
            }
        });
    }
}
