package com.smartindia.hackathon.biotechnology.MyProfile.Model;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smartindia.hackathon.biotechnology.MyProfile.Api.MyProfileApi;
import com.smartindia.hackathon.biotechnology.MyProfile.Model.Data.MyProfileData;
import com.smartindia.hackathon.biotechnology.MyProfile.view.MyProfileCallback;
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

public class RetrofitProfileProvider implements MyProfileProvider{

    private MyProfileApi myProfileApi;
    public RetrofitProfileProvider(){

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        myProfileApi = retrofit.create(MyProfileApi.class);
    }

    public void requestUpload(String access_toke,String keyTyp,String file_imag, String file_pd, String user_institutio, String user_skill, String user_plac, String user_currentyea, String user_qualificatio, String user_experienc, final MyProfileCallback myProfileCallback)
    {
        File file = new File(file_imag);
        File file_pdf = new File(file_pd);

        final RequestBody requestBodypdf = RequestBody.create(MediaType.parse("application/pdf"), file_pdf);
        RequestBody requestBodyimg = RequestBody.create(MediaType.parse("image/*"), file);
        MultipartBody.Part fileToUploadimg = MultipartBody.Part.createFormData("file", file.getName(), requestBodyimg);
        MultipartBody.Part fileToUploadpdf = MultipartBody.Part.createFormData("file_pdf", file_pdf.getName(), requestBodypdf);
        RequestBody access_token = RequestBody.create(MediaType.parse("text/plain"), access_toke);
        RequestBody keyType = RequestBody.create(MediaType.parse("text/plain"), keyTyp);
        RequestBody user_institution = RequestBody.create(MediaType.parse("text/plain"), user_institutio);
        RequestBody user_skills = RequestBody.create(MediaType.parse("text/plain"), user_skill);
        RequestBody user_place = RequestBody.create(MediaType.parse("text/plain"),user_plac);
        RequestBody user_currentyear = RequestBody.create(MediaType.parse("text/plain"), user_currentyea);
        RequestBody user_qualification = RequestBody.create(MediaType.parse("text/plain"), user_qualificatio);
        RequestBody user_experience = RequestBody.create(MediaType.parse("text/plain"), user_experienc);

        Call<MyProfileData> myProfileDataCall = myProfileApi.upload(access_token,keyType,user_institution,user_skills,user_place,user_currentyear,user_qualification,user_experience,fileToUploadimg);
        myProfileDataCall.enqueue(new Callback<MyProfileData>() {
            @Override
            public void onResponse(Call<MyProfileData> call, Response<MyProfileData> response) {
                myProfileCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<MyProfileData> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
