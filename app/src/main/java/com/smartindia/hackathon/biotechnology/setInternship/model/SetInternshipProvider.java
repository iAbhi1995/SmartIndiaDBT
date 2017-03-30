package com.smartindia.hackathon.biotechnology.setInternship.model;

import com.smartindia.hackathon.biotechnology.request.RequestCallBack;
import com.smartindia.hackathon.biotechnology.setInternship.SetInternshipCallBack;

/**
 * Created by aman on 29/3/17.
 */

public interface SetInternshipProvider {



    void requestIntern(String token,String company,String location,String date,String duration,String stipend,String applyBy,String aboutCompany,String aboutInternship,
                       String no,String perk,String apply, SetInternshipCallBack setInternshipCallBack);
}
