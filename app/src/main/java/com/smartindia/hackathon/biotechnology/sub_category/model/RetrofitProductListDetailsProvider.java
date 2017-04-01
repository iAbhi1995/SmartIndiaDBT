package com.smartindia.hackathon.biotechnology.sub_category.model;

import android.util.Log;

import com.smartindia.hackathon.biotechnology.helper.Urls;
import com.smartindia.hackathon.biotechnology.sub_category.OnProductListGetRequest;
import com.smartindia.hackathon.biotechnology.sub_category.api.SearchListRequestApi;
import com.smartindia.hackathon.biotechnology.sub_category.model.data.ProductListData;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitProductListDetailsProvider implements ProductListDetailsProvider {
    private static final String TAG = "RetrofitProducts";

    @Override
    public void requestProductList(String query, String access_token, int subCategoryId, final OnProductListGetRequest onProductListGetRequest) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(120,TimeUnit.SECONDS).readTimeout(120,TimeUnit.SECONDS).addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

            SearchListRequestApi searchListRequestApi=retrofit.create(SearchListRequestApi.class);
            Call<ProductListData> productListDataCall=searchListRequestApi.getProductListData(query,access_token,subCategoryId);

            productListDataCall.enqueue(new Callback<ProductListData>() {
                @Override
                public void onResponse(Call<ProductListData> call, Response<ProductListData> response) {
                    onProductListGetRequest.onSuccess(response.body());
                }
                @Override
                public void onFailure(Call<ProductListData> call, Throwable t) {
                    onProductListGetRequest.onFailure();
                    t.printStackTrace();
                }
            });


    }
}
