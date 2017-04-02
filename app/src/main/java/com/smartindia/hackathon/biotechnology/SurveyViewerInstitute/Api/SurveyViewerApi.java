package com.smartindia.hackathon.biotechnology.SurveyViewerInstitute.Api;

import com.smartindia.hackathon.biotechnology.SurveyViewerInstitute.Model.Data.ResultData;
import com.smartindia.hackathon.biotechnology.helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SurveyViewerApi {
    @GET(Urls.SURVEY_VIEWER_PROFESSOR)
    Call<ResultData> requestSurveyResult(@Query("access_token") String access_token);
}



