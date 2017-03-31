package com.smartindia.hackathon.biotechnology.ResearchApproval.Api;

import com.smartindia.hackathon.biotechnology.ResearchApproval.Model.Data.ResearchApprovalData;
import com.smartindia.hackathon.biotechnology.ResearchApproval.Model.Data.ResearchData;
import com.smartindia.hackathon.biotechnology.helper.Urls;
import com.smartindia.hackathon.biotechnology.login.model.data.SignUpResultData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ResearchApprovalApi{

    @GET(Urls.REQUEST_RESEARCH)
    Call<ResearchData> requestResearch(@Query("access_token") String access_token);


    @POST(Urls.REQUEST_RESEARCH_APPROVAL)
    Call<ResearchApprovalData> requestResearchApproval(@Query("inst_id")  String institute_id, @Query("stu_id") String stu_id, @Query("action") String action);
}