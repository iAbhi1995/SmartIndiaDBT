package com.smartindia.hackathon.biotechnology.request.model;

import android.os.Handler;
import android.util.Log;

import com.smartindia.hackathon.biotechnology.professor.model.data.ProfessorCityData;
import com.smartindia.hackathon.biotechnology.professor.model.data.ProfessorData;
import com.smartindia.hackathon.biotechnology.request.RequestCallBack;
import com.smartindia.hackathon.biotechnology.request.model.data.RequestData;
import com.smartindia.hackathon.biotechnology.request.model.data.RequestDataDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 29/3/17.
 */

public class MockRequestProvider implements RequestProvider{


    @Override
    public void requestAppStatus(String token, final RequestCallBack requestCallBack) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                requestCallBack.onSuccess(getmock());

                Log.d("Mock", "1");


            }
        }, 500);
    }


    public RequestData getmock() {
        List<RequestDataDetails> requestDatas = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            RequestDataDetails requestData = new RequestDataDetails("aman", "asd", "ad", "ddd", "ddddw");
            requestDatas.add(requestData);
        }
        RequestData requestDatass = new RequestData(true, "message", requestDatas);
return requestDatass;

    }




}
