package com.smartindia.hackathon.biotechnology.login.view;

import com.smartindia.hackathon.biotechnology.login.model.data.LoginData;
import com.smartindia.hackathon.biotechnology.login.model.data.ProfLogInData;

public interface LoginView {

    void showProgressBar(boolean show);
    void showMessage(String message);
    void onLoginVerified(LoginData loginData);
    void onProfessorLoginVerified(ProfLogInData profLogInData);
    void signOutonError();
}
