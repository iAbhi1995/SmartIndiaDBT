package com.smartindia.hackathon.biotechnology.request.model.data;

/**
 * Created by aman on 27/3/17.
 */

public class RequestDataDetails {
    private String name;
    private String status;
    private String note;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public RequestDataDetails(String status, String note, String name) {

        this.status = status;
        this.note = note;
        this.name = name;
    }








}
