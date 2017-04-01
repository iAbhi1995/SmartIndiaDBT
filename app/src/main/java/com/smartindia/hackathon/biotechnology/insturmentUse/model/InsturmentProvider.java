package com.smartindia.hackathon.biotechnology.insturmentUse.model;

import com.smartindia.hackathon.biotechnology.helper.SharedPrefs;
import com.smartindia.hackathon.biotechnology.insturmentUse.InsturmentUseCallBack;

/**
 * Created by aman on 30/3/17.
 */

public interface InsturmentProvider {


    void requestInsturment(String id, String token,String name, String email, String phone,String institute, InsturmentUseCallBack insturmentUseCallBack);


}
