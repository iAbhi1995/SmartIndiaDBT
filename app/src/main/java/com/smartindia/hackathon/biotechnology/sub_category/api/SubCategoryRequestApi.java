package com.smartindia.hackathon.biotechnology.sub_category.api;



import com.smartindia.hackathon.biotechnology.sub_category.model.data.SubCategoryData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface SubCategoryRequestApi {

    @GET("get_tabs")
    Call<SubCategoryData> getSubCategoryData(@Query("access_token") String access_token
            );


}
