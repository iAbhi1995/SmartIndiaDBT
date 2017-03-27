package com.smartindia.hackathon.biotechnology.request.model.data;

import java.util.List;

/**
 * Created by aman on 27/3/17.
 */

public class RequestData {

    private boolean success;
    private String message;
    private List<RequestDataDetails> dataDetailsList;

    public List<RequestDataDetails> getDataDetailsList() {
        return dataDetailsList;
    }

    public void setDataDetailsList(List<RequestDataDetails> dataDetailsList) {
        this.dataDetailsList = dataDetailsList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public RequestData(boolean success, String message, List<RequestDataDetails> dataDetailsList) {

        this.success = success;
        this.message = message;
        this.dataDetailsList = dataDetailsList;
    }
















}
