package com.smartindia.hackathon.biotechnology.request.model;

import com.smartindia.hackathon.biotechnology.request.RequestCallBack;

/**
 * Created by aman on 27/3/17.
 */

public interface RequestProvider {

    void requestAppStatus(String token, RequestCallBack requestCallBack);

}
