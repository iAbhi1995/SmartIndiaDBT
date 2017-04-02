package com.smartindia.hackathon.biotechnology.Updates.Api;

import com.smartindia.hackathon.biotechnology.Updates.Model.Data.UpdateData;
import com.smartindia.hackathon.biotechnology.helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UpdatesApi {
    @GET(Urls.REQUEST_UPDATES)
    Call<UpdateData> requestUpdate();
}

