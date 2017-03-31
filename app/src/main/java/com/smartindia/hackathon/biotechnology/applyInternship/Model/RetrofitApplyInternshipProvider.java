package com.smartindia.hackathon.biotechnology.applyInternship.Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smartindia.hackathon.biotechnology.applyInternship.Api.ApplyInternshipApi;
import com.smartindia.hackathon.biotechnology.applyInternship.ApplyInternshipCallback;
import com.smartindia.hackathon.biotechnology.applyInternship.GetInternshipCallback;
import com.smartindia.hackathon.biotechnology.applyInternship.Model.Data.ApplyInternData;
import com.smartindia.hackathon.biotechnology.applyInternship.Model.Data.GetInternshipData;
import com.smartindia.hackathon.biotechnology.helper.Urls;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitApplyInternshipProvider implements ApplyInternProvider {

    private final Retrofit retrofit;
    private ApplyInternshipApi applyInternshipApi;

    public RetrofitApplyInternshipProvider() {
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
    public void getInternship(String id, String access_token, final GetInternshipCallback getInternshipCallback) {
        applyInternshipApi = retrofit.create(ApplyInternshipApi.class);
        Call<GetInternshipData> call = applyInternshipApi.getInternship(id, access_token);

        call.enqueue(new Callback<GetInternshipData>() {
            @Override
            public void onResponse(Call<GetInternshipData> call, Response<GetInternshipData> response) {
                getInternshipCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<GetInternshipData> call, Throwable t) {
                getInternshipCallback.onFailure();
                t.printStackTrace();
            }
        });
    }

    @Override
    public void applyInternship(String id, String access_token, final ApplyInternshipCallback applyInternshipCallback) {
        applyInternshipApi = retrofit.create(ApplyInternshipApi.class);
        Call<ApplyInternData> call = applyInternshipApi.applyInternship(id, access_token);
        call.enqueue(new Callback<ApplyInternData>() {
            @Override
            public void onResponse(Call<ApplyInternData> call, Response<ApplyInternData> response) {
                applyInternshipCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ApplyInternData> call, Throwable t) {
                t.printStackTrace();
                applyInternshipCallback.onFailure();
            }
        });
    }
}
