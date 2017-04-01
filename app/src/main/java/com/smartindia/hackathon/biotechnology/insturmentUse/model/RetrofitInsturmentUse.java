package com.smartindia.hackathon.biotechnology.insturmentUse.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smartindia.hackathon.biotechnology.Internship.api.InternshipApi;
import com.smartindia.hackathon.biotechnology.helper.Urls;
import com.smartindia.hackathon.biotechnology.insturmentUse.InsturmentUseCallBack;
import com.smartindia.hackathon.biotechnology.insturmentUse.api.InsturmentUseApi;
import com.smartindia.hackathon.biotechnology.insturmentUse.model.data.InsturmentUseData;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aman on 30/3/17.
 */

public class RetrofitInsturmentUse implements InsturmentProvider {


    private InsturmentUseApi insturmentUseApi;


    public RetrofitInsturmentUse() {

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
        // addCustomerRequestApi= retrofit.create(AddCustomerRequestApi.class);
        insturmentUseApi = retrofit.create((InsturmentUseApi.class));
    }

    @Override
    public void requestInsturment(String id, String token, String name, String email, String phone,
                                  String institute, final InsturmentUseCallBack insturmentUseCallBack) {
        Call<InsturmentUseData> call = insturmentUseApi.getInsturment(token, id, name, email, phone, institute);
        call.enqueue(new Callback<InsturmentUseData>() {
            @Override
            public void onResponse(Call<InsturmentUseData> call, Response<InsturmentUseData> response) {
                insturmentUseCallBack.OnSuccess(response.body());
            }

            @Override
            public void onFailure(Call<InsturmentUseData> call, Throwable t) {
                insturmentUseCallBack.OnFailure();
                t.printStackTrace();
            }
        });
    }
}