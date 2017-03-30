package com.smartindia.hackathon.biotechnology.setInternship.presenter;

import com.smartindia.hackathon.biotechnology.setInternship.SetInternshipCallBack;

/**
 * Created by aman on 29/3/17.
 */

public interface SetInternsipPresenter {

    void requestIntern(String token,String skill,String company,String location,String date,String duration,String stipend,String applyBy,String aboutCompany,String aboutInternship,
                       String no,String perk,String apply);

}
