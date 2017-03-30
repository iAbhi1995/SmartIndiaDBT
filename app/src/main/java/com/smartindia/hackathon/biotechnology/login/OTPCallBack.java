package com.smartindia.hackathon.biotechnology.login;

import com.smartindia.hackathon.biotechnology.login.model.data.OTPdata;

/**
 * Created by Abhishek on 28-03-2017.
 */

public interface OTPCallBack {
    void onSuccess(OTPdata otpData);
    void onFailure();
}
