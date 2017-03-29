package com.smartindia.hackathon.biotechnology.login.view;

import com.smartindia.hackathon.biotechnology.login.model.data.OTPdata;

/**
 * Created by Abhishek on 28-03-2017.
 */

public interface OTPView {
    void showProgressBar(boolean show);
    void showMessage(String message);
    void onOTPVerified(OTPdata otpData);
}
