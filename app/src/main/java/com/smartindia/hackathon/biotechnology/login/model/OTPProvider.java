package com.smartindia.hackathon.biotechnology.login.model;

import com.smartindia.hackathon.biotechnology.login.OTPCallBack;

/**
 * Created by Abhishek on 28-03-2017.
 */

public interface OTPProvider {
    void requestOtp(String otp, OTPCallBack otpCallBack);
}
