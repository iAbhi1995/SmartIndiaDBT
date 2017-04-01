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
    Call<SetInternshipData> getIntern(@Query("access_token")String token,@Query("city")String location,@Query("start_date")String date,@Query("time_period")String duration,@Query("stipend")String stipend,@Query("apply_by")String applyBy,@Query("about_research")String aboutInternship,
                                      @Query("seats")String no,@Query("perk")String perk,@Query("criteria")String apply);



}
