package com.smartindia.hackathon.biotechnology.productDesc.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smartindia.hackathon.biotechnology.helper.Urls;
import com.smartindia.hackathon.biotechnology.productDesc.ProductCallBack;
import com.smartindia.hackathon.biotechnology.productDesc.api.ProductApi;
import com.smartindia.hackathon.biotechnology.productDesc.model.data.ProductData;
import com.smartindia.hackathon.biotechnology.professor.api.ProfessorApi;

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

public class RetrofitProductProvider implements ProductProvider {

private ProductApi productApi;
    public RetrofitProductProvider() {
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

        productApi = retrofit.create(ProductApi.class);

    }

    @Override
    public void requestProduct(String token, String type, String id, final ProductCallBack productCallBack) {

        Call<ProductData>call=productApi.getProduct(token,type,id);
        call.enqueue(new Callback<ProductData>() {
            @Override
            public void onResponse(Call<ProductData> call, Response<ProductData> response) {
                productCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ProductData> call, Throwable t) {


                productCallBack.onFailure();
                t.printStackTrace();
            }
        });



    }
}
