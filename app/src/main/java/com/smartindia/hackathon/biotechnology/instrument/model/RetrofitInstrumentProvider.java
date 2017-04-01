package com.smartindia.hackathon.biotechnology.instrument.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smartindia.hackathon.biotechnology.helper.Urls;
import com.smartindia.hackathon.biotechnology.instrument.InstrumentCallBack;
import com.smartindia.hackathon.biotechnology.instrument.api.InstrumentApi;
import com.smartindia.hackathon.biotechnology.instrument.model.data.InstrumentData;
import com.smartindia.hackathon.biotechnology.productDesc.model.data.InsturmentData;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aman on 1/4/17.
 */

public class RetrofitInstrumentProvider implements Instrument_Provider {

    private InstrumentApi instrumentApi;

    public RetrofitInstrumentProvider() {
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
        instrumentApi = retrofit.create((InstrumentApi.class));
        // insturmentUseApi = retrofit.create((InsturmentUseApi.class));
    }

    @Override
    public void request_Instrument(String token, String type, String id, final InstrumentCallBack instrumentCallBack) {

        Call<InstrumentData> call = instrumentApi.getInstrument(token, type, id);
        call.enqueue(new Callback<InstrumentData>() {
            @Override
            public void onResponse(Call<InstrumentData> call, Response<InstrumentData> response) {
                instrumentCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<InstrumentData> call, Throwable t) {
                instrumentCallBack.onFailure();
                t.printStackTrace();
            }
        });
    }
}
