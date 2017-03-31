package com.smartindia.hackathon.biotechnology.ResearchApproval.Model;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smartindia.hackathon.biotechnology.ResearchApproval.Api.ResearchApprovalApi;
import com.smartindia.hackathon.biotechnology.ResearchApproval.Model.Data.ResearchApprovalData;
import com.smartindia.hackathon.biotechnology.ResearchApproval.Model.Data.ResearchData;
import com.smartindia.hackathon.biotechnology.ResearchApproval.ResearchApprovalCallback;
import com.smartindia.hackathon.biotechnology.ResearchApproval.ResearchCallback;
import com.smartindia.hackathon.biotechnology.helper.Urls;
import com.smartindia.hackathon.biotechnology.login.api.LoginApi;
import com.smartindia.hackathon.biotechnology.login.model.data.LoginData;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRsrchApprvlProvider implements ResearchApprovalProvider {

    private final Retrofit retrofit;
    private ResearchApprovalApi approvalApi;
    public RetrofitRsrchApprvlProvider()
    {
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
    public void requestResearch(String access_token, final ResearchCallback researchCallback) {

         approvalApi=retrofit.create(ResearchApprovalApi.class);
        Call<ResearchData> call = approvalApi.requestResearch(access_token);

        call.enqueue(new Callback<ResearchData>() {
            @Override
            public void onResponse(Call<ResearchData> call, Response<ResearchData> response) {
                researchCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ResearchData> call, Throwable t) {
                t.printStackTrace();
                researchCallback.onFailure();
            }
        });
    }

    @Override
    public void requestResearchApproval(String instituteId, String studentId, String action, final ResearchApprovalCallback approvalCallback) {
        approvalApi=retrofit.create(ResearchApprovalApi.class);
        Call<ResearchApprovalData> call= approvalApi.requestResearchApproval(instituteId,studentId,action);
        call.enqueue(new Callback<ResearchApprovalData>() {
            @Override
            public void onResponse(Call<ResearchApprovalData> call, Response<ResearchApprovalData> response) {
                approvalCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ResearchApprovalData> call, Throwable throwable) {
                throwable.printStackTrace();
                approvalCallback.onFailure();
            }
        });
    }
}
