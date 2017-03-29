package com.smartindia.hackathon.biotechnology.BiotechPark.API;

import com.smartindia.hackathon.biotechnology.BiotechPark.Model.Data.BiotechParkData;
import com.smartindia.hackathon.biotechnology.helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ayush on 27-03-2017.
 */

public interface BiotechParkApi {
    @GET(Urls.REQUEST_BIOTECH_PARKS)
    Call<BiotechParkData> getBiotechPark(@Query("type") String type ,@Query("id") String id);
}
