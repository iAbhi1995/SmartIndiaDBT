package com.smartindia.hackathon.biotechnology.request.api;

import com.smartindia.hackathon.biotechnology.Internship.model.data.InternshipData;
import com.smartindia.hackathon.biotechnology.helper.Urls;
import com.smartindia.hackathon.biotechnology.request.model.data.RequestData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by aman on 27/3/17.
 */

public interface RequestApi {

    @GET(Urls.REQUEST_REQUEST)
    Call<RequestData> getStatus(@Query("access_token")String token);

}
