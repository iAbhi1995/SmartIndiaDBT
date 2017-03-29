package com.smartindia.hackathon.biotechnology.Internship.api;

import com.smartindia.hackathon.biotechnology.Internship.model.data.InternshipData;
import com.smartindia.hackathon.biotechnology.helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by aman on 27/3/17.
 */

public interface InternshipApi {

    @GET(Urls.REQUEST_INTERNSHIP)
    Call<InternshipData> getInternship(@Query("access_token") String token,@Query("city") String city,@Query("topic")String topic);
}
