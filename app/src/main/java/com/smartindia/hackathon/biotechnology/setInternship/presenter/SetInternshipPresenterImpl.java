package com.smartindia.hackathon.biotechnology.setInternship.presenter;

import com.smartindia.hackathon.biotechnology.setInternship.SetInternshipCallBack;
import com.smartindia.hackathon.biotechnology.setInternship.model.SetInternshipProvider;
import com.smartindia.hackathon.biotechnology.setInternship.model.data.SetInternshipData;
import com.smartindia.hackathon.biotechnology.setInternship.view.SetInternshipView;

/**
 * Created by aman on 29/3/17.
 */

public class SetInternshipPresenterImpl implements SetInternsipPresenter {

    private SetInternshipProvider setInternshipProvider;
    private SetInternshipView setInternshipView;


    public SetInternshipPresenterImpl(SetInternshipProvider setInternshipProvider, SetInternshipView setInternshipView) {
        this.setInternshipProvider = setInternshipProvider;
        this.setInternshipView = setInternshipView;
    }

    @Override
    public void requestIntern(String token, String skill, String company,
                              String location, String date, String duration,
                              String stipend, String applyBy, String aboutCompany,
                              String aboutInternship, String no, String perk, String apply) {

        setInternshipProvider.requestIntern(token,company, location,date,
                duration, stipend, applyBy, aboutCompany, aboutInternship,
                no,perk, apply, new SetInternshipCallBack() {
                    @Override
                    public void onSuccess(SetInternshipData setInternshipData) {
                        if (setInternshipData.isSuccess()) {

                        } else {
                            setInternshipView.showMessage(setInternshipData.getMessage());
                        }
                    }
                    @Override
                    public void onFailure() {
                        setInternshipView.showMessage("UNABLE TO CONNECT");

                    }
                });

    }
}
