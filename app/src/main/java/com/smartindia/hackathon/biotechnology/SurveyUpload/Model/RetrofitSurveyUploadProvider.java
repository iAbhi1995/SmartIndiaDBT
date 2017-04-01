package com.smartindia.hackathon.biotechnology.SurveyUpload.Model;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smartindia.hackathon.biotechnology.SurveyUpload.API.SurveyApi;
import com.smartindia.hackathon.biotechnology.SurveyUpload.Model.Data.SureveyUploadData;
import com.smartindia.hackathon.biotechnology.SurveyUpload.View.OnSurveyUploadCallBack;
import com.smartindia.hackathon.biotechnology.helper.Urls;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ayush on 28-03-2017.
 */

public class RetrofitSurveyUploadProvider implements SurveyUploadProvider
{
    private SurveyApi surveyApi;
    public RetrofitSurveyUploadProvider(){

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
            surveyApi = retrofit.create(SurveyApi.class);
    }

    public void requestUpload(String access_toke,String typ,String uri, String survey_titl, String survey_scal, String survey_descriptio, String survey_questio1, String
            survey_questio2, String survey_questio3, String survey_questio4, final OnSurveyUploadCallBack onSurveyUploadCallBack)
    {
        File file = new File(uri);

        final RequestBody requestBody = RequestBody.create(MediaType.parse("application/pdf"), file);
        MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("file", file.getName(), requestBody);
        RequestBody access_token = RequestBody.create(MediaType.parse("text/plain"), access_toke);
        RequestBody type = RequestBody.create(MediaType.parse("text/plain"), typ);
        RequestBody survey_title = RequestBody.create(MediaType.parse("text/plain"), survey_titl);
        RequestBody survey_scale = RequestBody.create(MediaType.parse("text/plain"), survey_scal);
        RequestBody survey_description = RequestBody.create(MediaType.parse("text/plain"),survey_descriptio);
        RequestBody survey_question1 = RequestBody.create(MediaType.parse("text/plain"), survey_questio1);
        RequestBody survey_question2 = RequestBody.create(MediaType.parse("text/plain"), survey_questio2);
        RequestBody survey_question3 = RequestBody.create(MediaType.parse("text/plain"), survey_questio3);
        RequestBody survey_question4 = RequestBody.create(MediaType.parse("text/plain"), survey_questio4);

        Call<SureveyUploadData> sureveyUploadDataCall = surveyApi.upload(access_token,type,survey_title,survey_scale,survey_description,survey_question1,survey_question2,survey_question3,survey_question4,fileToUpload);
        sureveyUploadDataCall.enqueue(new Callback<SureveyUploadData>() {
            @Override
            public void onResponse(Call<SureveyUploadData> call, Response<SureveyUploadData> response) {
                        onSurveyUploadCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<SureveyUploadData> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
