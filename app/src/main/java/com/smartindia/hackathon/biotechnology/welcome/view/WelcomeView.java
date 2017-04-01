package com.smartindia.hackathon.biotechnology.welcome.view;

import com.smartindia.hackathon.biotechnology.welcome.model.data.PageDetails;

import java.util.List;


public interface WelcomeView {

    void showMessage(String error);

    void showProgressBar(boolean show);

    void setData(List<PageDetails> pageDetails);
}
