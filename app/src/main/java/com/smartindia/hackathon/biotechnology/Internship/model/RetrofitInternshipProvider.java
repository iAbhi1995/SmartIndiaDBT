package com.smartindia.hackathon.biotechnology.Internship.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smartindia.hackathon.biotechnology.Internship.InternshipCallBack;
import com.smartindia.hackathon.biotechnology.Internship.api.InternshipApi;
import com.smartindia.hackathon.biotechnology.Internship.model.data.InternshipData;
import com.smartindia.hackathon.biotechnology.helper.Urls;

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

public class RetrofitInternshipProvider implements InternshipProvider {

private InternshipApi internshipApi;
    public RetrofitInternshipProvider() {

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
           internshipApi=retrofit.create((InternshipApi.class));



    }


    @Override
    public void requestInternship(String token, final InternshipCallBack internshipCallBack) {

        Call<InternshipData> call=internshipApi.getInternship(token);
        call.enqueue(new Callback<InternshipData>() {
            @Override
            public void onResponse(Call<InternshipData> call, Response<InternshipData> response) {

                internshipCallBack.onSuccess(response.body());





            }

            @Override
            public void onFailure(Call<InternshipData> call, Throwable t) {

                internshipCallBack.onFailure();
                t.printStackTrace();




            }
        });



    }
}
