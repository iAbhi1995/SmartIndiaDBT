package com.smartindia.hackathon.biotechnology.login;

import com.smartindia.hackathon.biotechnology.login.model.data.ProfLogInData;

public interface ProfLoginCallBack {
    void onSuccess(ProfLogInData profLogInData);
    void onFailure();
}
