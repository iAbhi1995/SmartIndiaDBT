package com.smartindia.hackathon.biotechnology.profileView.Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smartindia.hackathon.biotechnology.helper.Urls;
import com.smartindia.hackathon.biotechnology.profileView.Api.ProfileApi;
import com.smartindia.hackathon.biotechnology.profileView.Model.Data.ProfileData;
import com.smartindia.hackathon.biotechnology.profileView.ProfileCallback;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Abhishek on 02-04-2017.
 */

public class RetrofitProfileProvider implements ProfileProvider {
    private final Retrofit retrofit;
    private ProfileApi profileApi;

    public RetrofitProfileProvider() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().
                addInterceptor(interceptor).build();

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
    public void requestProfile(String access_token, String id, final ProfileCallback profileCallback) {
        profileApi = retrofit.create(ProfileApi.class);
        Call<ProfileData> call = profileApi.requestProfile(access_token, id);

        call.enqueue(new Callback<ProfileData>() {
            @Override
            public void onResponse(Call<ProfileData> call, Response<ProfileData> response) {
                profileCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ProfileData> call, Throwable t) {
                profileCallback.onFailure();
                t.printStackTrace();
            }
        });
    }
}
