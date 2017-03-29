package com.smartindia.hackathon.biotechnology.professor.api;

import com.smartindia.hackathon.biotechnology.Internship.model.data.InternshipData;
import com.smartindia.hackathon.biotechnology.helper.Urls;
import com.smartindia.hackathon.biotechnology.professor.model.data.ProfessorData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;



/**
 * Created by aman on 28/3/17.
 */

public interface ProfessorApi {






        @GET(Urls.REQUEST_PROFESSOR)
        Call<ProfessorData> getProfessor(@Query("access_token") String token, @Query("type") String type,@Query("city") String city,@Query("topic")String topic);
    }






