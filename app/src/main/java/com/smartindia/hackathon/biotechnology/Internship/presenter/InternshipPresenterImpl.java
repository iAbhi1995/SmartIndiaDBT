package com.smartindia.hackathon.biotechnology.Internship.presenter;

import com.smartindia.hackathon.biotechnology.Internship.InternshipCallBack;
import com.smartindia.hackathon.biotechnology.Internship.model.InternshipProvider;
import com.smartindia.hackathon.biotechnology.Internship.model.data.InternshipCityData;
import com.smartindia.hackathon.biotechnology.Internship.model.data.InternshipData;
import com.smartindia.hackathon.biotechnology.Internship.view.InternshipView;

/**
 * Created by aman on 27/3/17.
 */

public class InternshipPresenterImpl implements InternshipPresenter{
private InternshipProvider internshipProvider;
    private InternshipView internshipView;


    public InternshipPresenterImpl(InternshipProvider internshipProvider, InternshipView internshipView) {
        this.internshipProvider = internshipProvider;
        this.internshipView = internshipView;
    }

    @Override
    public void requestInternship(String token) {
        internshipProvider.requestInternship(token, new InternshipCallBack() {
            @Override
            public void onSuccess(InternshipData internshipData) {
                if(internshipData.isSuccess())
                {internshipView.check(internshipData);
            }
            else
                {internshipView.showError(internshipData.getMessage());

                }

            }

            @Override
            public void onFailure() {
                internshipView.showError("NO INTERNET CONNECTION");
            }
        });




    }
}
