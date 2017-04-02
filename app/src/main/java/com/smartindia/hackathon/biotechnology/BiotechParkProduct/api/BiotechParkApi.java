package com.smartindia.hackathon.biotechnology.BiotechParkProduct.api;

import com.smartindia.hackathon.biotechnology.BiotechParkProduct.model.data.BiotechParkData;
import com.smartindia.hackathon.biotechnology.helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ayush on 27-03-2017.
 */

public interface BiotechParkApi {
    @GET(Urls.REQUEST_BIOTECH_PARKS)
    Call<BiotechParkData> getBiotechPark(@Query("access_token") String token,
                                         @Query("type") String type, @Query("id") String id);
}
