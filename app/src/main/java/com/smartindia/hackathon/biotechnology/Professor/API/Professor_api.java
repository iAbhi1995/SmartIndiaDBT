package com.smartindia.hackathon.biotechnology.Professor.API;

/**
 * Created by ayush on 27-03-2017.
 */

import com.smartindia.hackathon.biotechnology.Professor.Model.Data.Professor_details;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
public interface Professor_api {

        @GET("www")
        Call<Professor_details>getProfessors(@Query("access_token") String access_token);
    }


