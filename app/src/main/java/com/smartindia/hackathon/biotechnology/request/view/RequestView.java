package com.smartindia.hackathon.biotechnology.request.view;

import com.smartindia.hackathon.biotechnology.request.model.data.RequestDataDetails;

import java.util.List;

/**
 * Created by aman on 27/3/17.
 */

public interface RequestView {

    void showProgressbar(boolean show);
    void showMessage(String message);
    void dataReceive(List<RequestDataDetails> requestDataDetailsList);
}
