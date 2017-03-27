package com.smartindia.hackathon.biotechnology.request;

import com.smartindia.hackathon.biotechnology.request.model.data.RequestData;

/**
 * Created by aman on 27/3/17.
 */

public interface RequestCallBack {



    void onSuccess(RequestData requestData);
    void onFailure();
}
