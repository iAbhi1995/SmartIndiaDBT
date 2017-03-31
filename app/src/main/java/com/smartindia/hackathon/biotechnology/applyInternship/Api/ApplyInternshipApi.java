package com.smartindia.hackathon.biotechnology.applyInternship.Api;

import com.smartindia.hackathon.biotechnology.applyInternship.Model.Data.ApplyInternData;
import com.smartindia.hackathon.biotechnology.applyInternship.Model.Data.GetInternshipData;
import com.smartindia.hackathon.biotechnology.helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApplyInternshipApi
{
    @GET(Urls.REQUEST_INTERNSHIP_DETAILS)
    Call<GetInternshipData> getInternship(@Query("intern_id") String intern_id, @Query("access_token") String access_token);

    @POST(Urls.APPLY_INTERNSHIP)
    Call<ApplyInternData> applyInternship(@Query("intern_id") String intern_id, @Query("access_token") String access_token);
}
