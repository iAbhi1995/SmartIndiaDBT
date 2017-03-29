package com.smartindia.hackathon.biotechnology.MyProfile.Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smartindia.hackathon.biotechnology.MyProfile.Api.MyProfileApi;
import com.smartindia.hackathon.biotechnology.MyProfile.Model.Data.MyProfileData;
import com.smartindia.hackathon.biotechnology.MyProfile.Model.Data.PDFuploadResponse;
import com.smartindia.hackathon.biotechnology.MyProfile.Model.Data.SkillsData;
import com.smartindia.hackathon.biotechnology.MyProfile.MyProfileCallback;
import com.smartindia.hackathon.biotechnology.MyProfile.SkillsCallback;
import com.smartindia.hackathon.biotechnology.helper.Urls;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class RetrofitProfileProvider implements MyProfileProvider, SkillsProvider {

    private Retrofit retrofit;
    private MyProfileApi myProfileApi;

    public RetrofitProfileProvider(String uid) {

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
    public void requestMyProfile(String uid,
                                 String name, String college,
                                 String place, String emailId, String phoneNo, final MyProfileCallback myProfileCallback) {
        MyProfileApi myProfileApi = retrofit.create(MyProfileApi.class);
        Call<MyProfileData> call = myProfileApi.requestMyProfile(uid,
                name, college,
                place, emailId, phoneNo);
        call.enqueue(new Callback<MyProfileData>() {
            @Override
            public void onResponse(Call<MyProfileData> call, Response<MyProfileData> response) {
                myProfileCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<MyProfileData> call, Throwable t) {
                t.printStackTrace();
                myProfileCallback.onFailure("Unable to Connect to Api");
            }
        });
    }


    @Override
    public void requestPDFUpload(String mediaPath, final MyProfileCallback myProfileCallback) {

        File file = new File(mediaPath);
        RequestBody requestBody = RequestBody.create(MediaType.parse("pdf"), file);
        MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("file", file.getName(), requestBody);
        RequestBody filename = RequestBody.create(MediaType.parse("pdf"), file.getName());


        myProfileApi = retrofit.create(MyProfileApi.class);
        Call<PDFuploadResponse> call = myProfileApi.uploadFile(fileToUpload, filename);
        call.enqueue(new Callback<PDFuploadResponse>() {
            @Override
            public void onResponse(Call<PDFuploadResponse> call, Response<PDFuploadResponse> response) {
                myProfileCallback.onSuccessPDF(response.body());
            }

            @Override
            public void onFailure(Call<PDFuploadResponse> call, Throwable t) {
                myProfileCallback.onFailurePDF();
                t.printStackTrace();
            }
        });
    }


    @Override
    public void requestSkills(final SkillsCallback skillCallBack) {
        myProfileApi = retrofit.create(MyProfileApi.class);
        Call<SkillsData> call = myProfileApi.requestSkills();
        call.enqueue(new Callback<SkillsData>() {

            @Override
            public void onResponse(Call<SkillsData> call, Response<SkillsData> response) {
                skillCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<SkillsData> call, Throwable t) {
                t.printStackTrace();
                skillCallBack.onFailure();
            }
        });
    }
}