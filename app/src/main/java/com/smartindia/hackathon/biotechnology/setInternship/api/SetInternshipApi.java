package com.smartindia.hackathon.biotechnology.setInternship.api;

import com.smartindia.hackathon.biotechnology.helper.Urls;
import com.smartindia.hackathon.biotechnology.request.model.data.RequestData;
import com.smartindia.hackathon.biotechnology.setInternship.SetInternshipCallBack;
import com.smartindia.hackathon.biotechnology.setInternship.model.data.SetInternshipData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by aman on 29/3/17.
 */

public interface SetInternshipApi {

    @GET(Urls.SET_INTERNSHIP)
    Call<SetInternshipData> getIntern(@Query("access_token")String token,@Query("access_token")String company,@Query("access_token")String location,@Query("access_token")String date,@Query("access_token")String duration,@Query("access_token")String stipend,@Query("access_token")String applyBy,@Query("access_token")String aboutCompany,@Query("access_token")String aboutInternship,
                                      @Query("access_token")String no,@Query("access_token")String perk,@Query("access_token")String apply);



}
