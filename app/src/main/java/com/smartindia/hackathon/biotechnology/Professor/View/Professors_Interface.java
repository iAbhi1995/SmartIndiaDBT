package com.smartindia.hackathon.biotechnology.Professor.View;

import com.smartindia.hackathon.biotechnology.Professor.Model.Data.Professor_details;

/**
 * Created by ayush on 27-03-2017.
 */

public interface Professors_Interface {
    void showMessage(String error);
    void showProgressBar(boolean show);
    void onOfferReceived(Professor_details professor_details);
}
