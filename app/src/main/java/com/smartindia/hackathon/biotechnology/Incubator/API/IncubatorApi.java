package com.smartindia.hackathon.biotechnology.Incubator.API;

import com.smartindia.hackathon.biotechnology.Incubator.Model.Data.IncubatorData;
import com.smartindia.hackathon.biotechnology.helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ayush on 27-03-2017.
 */

public interface IncubatorApi {
    @GET(Urls.REQUEST_INCUBATORS)
    Call<IncubatorData> getIncubators(@Query("type") String type ,@Query("id") String id);
}
