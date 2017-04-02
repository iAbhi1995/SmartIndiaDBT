package com.smartindia.hackathon.biotechnology.ResearchPaper.Api;

import com.smartindia.hackathon.biotechnology.ResearchPaper.Model.Data.ResearchPaperData;
import com.smartindia.hackathon.biotechnology.helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ResearchPaperApi {

    @GET(Urls.REQUEST_RESEARCH_PAPER)
    Call<ResearchPaperData> requestResearch(@Query("access_token") String access_token, @Query("id") String id);

}
