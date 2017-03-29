package com.smartindia.hackathon.biotechnology.Professor.API;

import com.smartindia.hackathon.biotechnology.Internship.model.data.InternshipData;
import com.smartindia.hackathon.biotechnology.Professor.Model.Data.ProfessorData;
import com.smartindia.hackathon.biotechnology.helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;



/**
 * Created by aman on 28/3/17.
 */

public interface ProfessorApi {






        @GET(Urls.REQUEST_PROFESSOR)
        Call<ProfessorData> getProfessor(@Query("access_token") String token, @Query("type") String type, @Query("city") String city, @Query("topic")String topic);
    }






