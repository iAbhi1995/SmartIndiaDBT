package com.smartindia.hackathon.biotechnology.insturmentUse.api;

import com.smartindia.hackathon.biotechnology.Internship.model.data.InternshipData;
import com.smartindia.hackathon.biotechnology.helper.Urls;
import com.smartindia.hackathon.biotechnology.insturmentUse.model.data.InsturmentUseData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by aman on 30/3/17.
 */

public interface InsturmentUseApi {

    @GET(Urls.REQUEST_INSTRUMENT_USE)
    Call<InsturmentUseData> getInsturment(@Query("access_token") String token, @Query("id") String id, @Query("name")String name, @Query("email")String email,
                                          @Query(("phone"))String phone, @Query("institute")String institute);
}
