package com.smartindia.hackathon.biotechnology.Internship.model;

import com.smartindia.hackathon.biotechnology.Internship.InternshipCallBack;

/**
 * Created by aman on 27/3/17.
 */

public interface InternshipProvider {

    void requestInternship(String token,String city,String topic, InternshipCallBack internshipCallBack);



}
