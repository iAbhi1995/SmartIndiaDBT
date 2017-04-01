package com.smartindia.hackathon.biotechnology.instrument.api;

import com.smartindia.hackathon.biotechnology.helper.Urls;
import com.smartindia.hackathon.biotechnology.instrument.model.data.InstrumentData;
import com.smartindia.hackathon.biotechnology.productDesc.model.data.InsturmentData;
import com.smartindia.hackathon.biotechnology.productDesc.model.data.ProductData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by aman on 1/4/17.
 */

public interface InstrumentApi
{
    @GET(Urls.REQUEST_PRODUCT)
    Call<InstrumentData> getInstrument(@Query("access_token") String token,
                                       @Query("type") String type, @Query("id") String id);
}





