package com.smartindia.hackathon.biotechnology.professor.api;

import com.smartindia.hackathon.biotechnology.helper.Urls;
import com.smartindia.hackathon.biotechnology.professor.model.data.CityData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by iket on 2/4/17.
 */

public interface CityApi {

    @GET(Urls.REQUEST_CITY)
    Call<CityData> getCity(@Query("type")String type);
}
